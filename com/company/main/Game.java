package com.company.main;

import com.company.main.Monsters.Monster;
import com.company.main.Player.Player;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {

    public static int input = 0;
    public static Monster[] monsterList = new Monster[1];
    public static String [] monsterName = {"Chaosfang", "Venomcrackle", "Foulwing", "Warpling", "Webflayer", "Brinemouth", "Vampwings", "Hollowwing", "Cat Mandu"};

    public static void main(String[] args){
        Player Player1 = new Player();
        Monster monster1 = new Monster("Toxinflayer", 1, 20, 10);
        monsterList[0] = monster1;
        do {
            menu(Player1);
        }while (input!=0);

    }

    public static void menu(Player player)
    {
        System.out.println("Welcome Player"+player.getLevel()+"     "+player.getExp()+"/"+player.getLevel()+")\n");
        System.out.println("1. Mehmon inventory\n2. Adventure\n3. Heal\n4. Battle Arena \n0. Exit\n");

        Scanner reader = null;
        reader = new Scanner(System.in);
        input = reader.nextInt();

        switch(input){
            case 1: monsterInventory();
                System.out.println("\nPress any key for the menu!");
                String option = reader.nextLine();
                break;
            case 2: Adventure(player);
                System.out.println("\nPress any key for the menu!");
                option = reader.nextLine();
                option = reader.nextLine();
                break;

            case 3: Heal();
                System.out.println("\nPress any key for the menu!");
                option = reader.nextLine();
                option = reader.nextLine();
                break;

            case 4: BattleArena();
                System.out.println("\nPress any key for the menu!");
                option = reader.nextLine();
                option = reader.nextLine();
                break;

        }
    }
    public static void monsterInventory(){
        System.out.println("Nr. Name\t\tLevel  HP  maxHp  EXP\n");
        System.out.println("-----------------------------------------------------------------------------");

        int i = 1;

        for( Monster pet : monsterList){
            System.out.println(i++ +". "+pet.toString()+"\n");
        }

    }

    public static void Adventure(Player player){
        int random = (int)(Math.random()*8)+1;
        int lvl = (int)(Math.random()*player.getLevel())+1;
        int hp = 10*lvl;
        int maxHp =10*lvl;

        Monster randomMonster = new Monster(monsterName[random], lvl , hp , maxHp);

        System.out.println("Warning !!! A wild Mehmon attacks you!");
        System.out.println(randomMonster.lurkingFor());
        System.out.println("Do you want to fight against it? Press y for Attack!");
        Scanner reader = null;
        reader = new Scanner(System.in);
        String input = reader.nextLine();

        if (input.equals("y")) {
            try {
                System.out.println("Choose a monster you have:");
                monsterInventory();
                int choose = reader.nextInt() - 1;

                Monster[] fightMonster = new Monster[2];
                fightMonster[0] = randomMonster;
                fightMonster[1] = monsterList[choose];

                System.out.println("You choose " + fightMonster[1].getName() + " nice choice!");
                System.out.println(fightMonster[0].getName() + " fight against " + fightMonster[1].getName() + "!");
                System.out.println("------------------------------------------------------------------------------");

                Battle(fightMonster);
                player.setExp(player.getExp() + 1);
                player.levelUp(player.getExp(), player.getLevel());
                System.out.println("Player level up!");


        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You dont have that mehmon.");
        }
        }else{
            menu(player);
        }

    }

    public static void Heal(){

    }

    public static void BattleArena(){

    }
    public static void Battle(Monster[] fightMonster){
        while( fightMonster[0].getHp()>0 && fightMonster[1].getHp()>0){
            int damage = fightMonster[0].attack();
            fightMonster[1].setHp(fightMonster[1].getHp()-damage);
            System.out.println(fightMonster[0].getName()+" did "+fightMonster[1].getName()+" "+damage+ "damage.");
            System.out.println(fightMonster[1].getName()+" now has "+fightMonster[1].getHp()+" Hp left.");
            System.out.println("------------------------------------------");

            if(fightMonster[0].getHp()>0 && fightMonster[1].getHp()>0){
                damage = fightMonster[1].attack();
                fightMonster[0].setHp(fightMonster[0].getHp()-damage);
                System.out.println(fightMonster[1].getName()+" did "+fightMonster[0].getName()+" "+damage+ "damage.");
                System.out.println(fightMonster[0].getName()+" now has "+fightMonster[0].getHp()+" Hp left.");
                System.out.println("------------------------------------------");
            }
        }

        if(fightMonster[0].getHp()>0){
            System.out.println(fightMonster[0].getName()+" has won.");
            System.out.println(fightMonster[0].getName()+" exp +1. ");
            fightMonster[1].setHp(0);
            fightMonster[0].setExp(fightMonster[0].getExp()+1);
            fightMonster[0].levelUP(fightMonster[0].getExp(), fightMonster[0].getLvl());
        } else if (fightMonster[1].getHp()>0){
            System.out.println(fightMonster[1].getName()+" has won.");
            System.out.println(fightMonster[1].getName()+" exp +1. ");
            fightMonster[0].setHp(1);
            fightMonster[1].setExp(fightMonster[1].getExp()+1);
            fightMonster[1].levelUP(fightMonster[1].getExp(), fightMonster[1].getLvl());
        }
    }
}
