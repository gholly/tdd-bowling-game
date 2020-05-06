package tdd.bowling.games;

public class Frame {
    private int first;
    private int second;
    public boolean isSpare;
    public boolean isStrike;
    private int bonus;
    public Frame nextFrame;
    public int number;

    public Frame(int first, int second) {
        this.first = first;
        this.second = second;

    }

    public int getTotalScore() {
        return first + second + bonus;
    }

    public boolean isSpare() {
        return first + second == 10;
    }

    public boolean isStrike() {
        return first == 10;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }



}
