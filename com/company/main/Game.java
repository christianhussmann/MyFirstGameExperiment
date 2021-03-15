package com.company.main;

import com.company.main.Player.Player;

public class Game {

    public static void main(String[] args){
        Player Player1 = new Player();

        menu(Player1);

    }

    public static void menu(Player Player)
    {
        System.out.println("Welcome Player"+Player.getLevel()+"  "+Player.getExp()+"/"+Player.getLevel()+")\n");
        System.out.println("Monster inventory");
    }
}
