package com.company;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.toReverse("dinosaur"));
    }

    public String toReverse(String word){
        String reverse = "";
        for(int i = word.length()-1; i>= 0; i--){
            reverse += word.charAt(i);
        }
        return reverse;
    }
}
