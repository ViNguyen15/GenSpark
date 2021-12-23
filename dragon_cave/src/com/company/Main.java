package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nYou are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)\n");

        int playerChoice = input.nextInt();

        if (playerChoice == 1)
            evilDragon();
        if (playerChoice == 2)
            goodDragon();

    }

    public static void goodDragon(){
        System.out.println("\nYou approach the cave...\n" +
                "You hear a loud thundering roar follow by a large intimidating silhouette...\n" +
                "You then hear a loud hearty laughter as the silhouette turns into a dragon...\n" +
                "The dragon then asked you if you wanted to be friends and offers a golden grail as a sign of your friendship.");
    }

    public static void evilDragon(){
        System.out.println("\nYou approach the cave...\n" +
                "It is dark and spooky...\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "Gobbles you down in one bite!\n");
    }
}
