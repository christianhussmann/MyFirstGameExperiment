package com.company.main.Monsters;

public class Monster {

    private int hp;
    private int maxHp;
    private int lvl;
    private int exp;
    private String name;

    public Monster(String name, int lvl, int hp, int maxHp){
        setName(name);
        setLvl(lvl);
        setHp(hp);
        setMaxHp(maxHp);
        exp = 0;

    }

    public int getExp(){
        return exp;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public String getName(){
        return name;
    }

    public int getLvl(){
        return lvl;
    }

    public int getHp(){
        return hp;
    }

    public void setName(){
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int attack(){
        int attackPower = (int)(Math.random()*getLvl()+1)+1;

        if(attackPower > 45){
            attackPower = 45;
        } else if (getLvl()>=10 && attackPower < 10){
            attackPower = 10;
        } else if (getLvl()<10 && attackPower < 10){

        }return attackPower;
    }
    public String lurkingFor(){
        return "        "+name+"        "+lvl;
    }

    public String toString(){
        return "        "+name+"\t\t"+lvl+"     "+hp+"      "+maxHp+"       "+exp+"/"+lvl;



    }



}
