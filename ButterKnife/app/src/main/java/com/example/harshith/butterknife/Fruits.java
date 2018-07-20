package com.example.harshith.butterknife;

public class Fruits {

    String fruit;
    int image;

    Fruits(String f,Integer i){
        this.fruit=f;
        this.image=i;
    }

    public String getF(){
        return this.fruit;
    }

    public Integer getI(){
        return this.image;
    }
}
