package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;

    private QuestionMarker questionMarker;

    private int currentPlayer;

    private static final int GOLD_WIN = 6;

    public Game() {
        players = new ArrayList<Player>();
        questionMarker = new QuestionMarker();
        currentPlayer = 0;
    }

    public boolean add(String playerName) {

        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());

        return true;
    }

    public void roll(int roll) {
        Player player = getCurrentPlayer();

        System.out.println(player.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        player.processRoll(roll);

        if (!player.isInPenaltyBox()) {
            String currentCategory = questionMarker.getCategory(player);
            System.out.println("The category is " + currentCategory);
            questionMarker.askQuestion(currentCategory);
        }
    }

    public boolean wasCorrectlyAnswered() {
        Player player = getCurrentPlayer();
        boolean gameNotOver = true;

        if (!player.isGettingOutInPenaltyBox()) {
            System.out.println("Answer was correct!!!!");
            player.winAGold();
            System.out.println(player.getName() + " now has " + player.getGold() + " Gold Coins.");

            gameNotOver = isNotWin(player);
        }

        setNextPlayer();

        return gameNotOver;
    }

    public boolean wrongAnswer() {
        Player player = getCurrentPlayer();

        System.out.println("Question was incorrectly answered");
        System.out.println(player.getName() + " was sent to the penalty box");
        player.goToPenaltyBox();

        setNextPlayer();
        return true;
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private boolean isNotWin(Player player) {
        return !(player.getGold() == GOLD_WIN);
    }

    private void setNextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }
    }
}
