package com.example.th85;

import java.util.ArrayList;

public class BottleDispenser {

    private static BottleDispenser bot = null;

    private int bottles;

    private float money = 0;
    private String name = "";
    private float size = 0;
    private int choice = 0;
    private float price = 0;

    ArrayList<Bottle> bottle_list = new ArrayList<Bottle>();
    ArrayList<String> name_list = new ArrayList<String>();
    ArrayList<Receipt> receipt_list = new ArrayList<Receipt>();

    private BottleDispenser() {

        bottles = 5;

        name_list.add("Valitse pullo");

        for(int i = 0;i<bottles;i++) {
            if (i==0) {
                name = "PepsiMax";
                size = 0.5f;
                price = 1.80f;
            }
            if (i==1) {
                name = "PepsiMax";
                size = 1.5f;
                price = 2.2f;
            }
            if (i==2) {
                name = "Coca-ColaZero";
                size = 0.5f;
                price = 2.0f;
            }
            if (i==3) {
                name = "Coca-ColaZero";
                size = 1.5f;
                price = 2.5f;
            }
            if (i==4) {
                name = "FantaZero";
                size = 0.5f;
                price = 1.95f;
            }
            bottle_list.add(new Bottle(name, size, price));
            name_list.add(bottle_list.get(i).getName() +" " +bottle_list.get(i).getSize() + " l " +bottle_list.get(i).getPrice() + " €");
        }
    }

    public static BottleDispenser getInstance() {
        if (bot == null) {
            bot = new BottleDispenser();
        }
        return bot;
    }


    public void addMoney(int mon) {
        money = mon;
    }


    public int buyBottle(String name, float size, float price) {

        if (money >= price) {
            for(int i=0; i < bottle_list.size(); i++) {
                if (bottle_list.get(i).getName().equals(name)) {
                    if (bottle_list.get(i).getSize() == size) {
                        money = money - bottle_list.get(i).getPrice();
                        bottle_list.remove(i);
                        receipt_list.add(new Receipt(bottle_list.get(i).getName(), bottle_list.get(i).getSize(), bottle_list.get(i).getPrice()));
                        break;
                    }
                }
            }
            int i = 11;
            return i;
        } else {
            return 0;
        }
    }

    public float returnMoney() {
        float money_now;
        money_now = money;
        money = 0;
        return money_now;
    }


    public ArrayList<String> getBottle_list() {
        return name_list;
    }

    public ArrayList<Receipt> getReceipt_list(){
        return receipt_list;
    }

}
