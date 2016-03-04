package com.adaptionsoft.games.uglytrivia;

public class Player {
    private String name;

    private int place;

    private int gold;

    private enum PenaltyBoxState {
        IN, GETTING_OUT, OUT
    }

    private PenaltyBoxState state;

    public Player(String name) {
        this(name, 0, 0, PenaltyBoxState.OUT);
    }

    public Player(String name, int place, int gold, PenaltyBoxState state) {
        this.name = name;
        this.place = place;
        this.gold = gold;
        this.state = state;
    }

    public void processRoll(int roll) {
        if (!isInPenaltyBox()) {
            currentPlayerMoveForward(roll);
            return;
        }

        if (rollingGoodDick(roll)) {
            System.out.println(this.name + " is getting out of the penalty box");
            this.state = PenaltyBoxState.GETTING_OUT;
            currentPlayerMoveForward(roll);
            return;
        }

        System.out.println(this.name + " is not getting out of the penalty box");
    }

    private void currentPlayerMoveForward(int roll) {
        moveForward(roll);

        System.out.println(this.name + "'s new location is " + this.place);
    }

    private void moveForward(int roll) {
        this.place = this.place + roll;
        this.place = this.place <= 11 ? this.place : this.place - 12;
    }

    public boolean isGettingOutInPenaltyBox() {
        return this.state == PenaltyBoxState.GETTING_OUT;
    }

    public boolean isInPenaltyBox() {
        return this.state == PenaltyBoxState.IN;
    }

    public void goToPenaltyBox() {
        this.state = PenaltyBoxState.IN;
    }

    public boolean rollingGoodDick(int roll) {
        return roll % 2 != 0;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }

    public int getGold() {
        return gold;
    }

    public void winAGold() {
        this.gold++;
    }
}
