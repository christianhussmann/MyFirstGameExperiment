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
        System.out.println("1. Monster inventory\n2. Adventure\n3. Heal\n4. Battle Arena \n0. Exit\n");

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

        System.out.println("Warning !!! A wild mehmon attacks you!");
        System.out.println(randomMonster.lurkingFor());

    }

    public static void Heal(){

    }

    public static void BattleArena(){

    }
}
