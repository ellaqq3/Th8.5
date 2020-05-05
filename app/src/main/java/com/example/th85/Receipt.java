package com.example.th85;

public class Receipt{

    private String name;
    private float size;
    private float price;

    public Receipt(String a, float b, float c){
        name = a;
        size = b;
        price = c;
    }
    public String getName(){
        return name;
    }

    public float getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }

}
