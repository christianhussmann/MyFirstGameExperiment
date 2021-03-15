package com.company.main.Player;

public class Player {
    private int level;
    private int exp;

    public Player(){
        this.level = 1;
        this.exp = 0;
    }

    public int getLevel(){
        return level;
    }

    public int getExp(){
        return exp;
    }
    public void setLevel(int level){
        this.level = level;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public void levelUp(int exp, int level){
        if(exp==level)
            setLevel(level + 1);
            setExp(0);

    }

}
