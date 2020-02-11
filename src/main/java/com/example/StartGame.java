package com.example;

import java.util.ArrayList;

public class StartGame {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList= new ArrayList<>();
    private int numOfGuesses = 0 ;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Birds.com");

        DotCom two = new DotCom();
        two.setName("Dogs.com");

        DotCom three = new DotCom();
        three.setName("Cats.com");

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Welcome, Sink the Dotcom.");
        System.out.println(one.getName() +", "+ two.getName() + ", " + three.getName());

        for (DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess: \n>");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Miss";
        for (DotCom dotComToTest :dotComsList){
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Hit!")){
                break;
            }
            if (result.equals("Kill")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dead... You win!");
        System.out.println("Num of Guesses: " + numOfGuesses);
    }

    public static void main(String[] args) {
        StartGame game = new StartGame();
        game.setUpGame();
        game.startPlaying();
    }
}
