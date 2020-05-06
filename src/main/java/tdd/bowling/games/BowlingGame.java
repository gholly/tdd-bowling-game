package tdd.bowling.games;

import com.google.common.collect.Lists;

import java.util.List;

public class BowlingGame {

    private int score = 0;
    private List<Frame> frames = Lists.newArrayList();
    private Line line = new Line();

    public void throwRoll(int first, int second) throws OutOfFramesException {
        Frame frame = new Frame(first, second);
        line.AddFrame(frame);
    }

    public int getScore() {

        Frame currentFrame = line.firstFrame;
        while (currentFrame != null) {
            score += currentFrame.getTotalScore();
            if (currentFrame.isSpare() && currentFrame != line.lastFrame) {
                score += currentFrame.nextFrame.getFirst();
            }
            if (currentFrame.isStrike() && currentFrame != line.lastFrame) {
                if (currentFrame.nextFrame.isStrike() && currentFrame.nextFrame.nextFrame != null) {
                    score += currentFrame.nextFrame.nextFrame.getFirst();
                } else {
                    score += currentFrame.nextFrame.getSecond();
                }
            }
//            score += currentFrame.getTotalScore();
            currentFrame = currentFrame.nextFrame;
        }
        return score;
    }

    public void throwSpareRoll(int first, int second) throws OutOfFramesException {
        Frame frame = new Frame(first, second);
        frame.isSpare = true;
        line.AddFrame(frame);
    }

    public void throwStrikeRoll(int first, int second) throws OutOfFramesException {
        Frame frame = new Frame(first, second);
        frame.isStrike = true;
        line.AddFrame(frame);
    }

    public void throwTenthFrame(int first, int second, int bonus) throws OutOfFramesException {
        Frame frame = new Frame(first, second);
        frame.isSpare = true;
        line.AddFrame(frame);
        frame.setBonus(bonus);
    }

    public int getGameScore() {
        return 0;
    }
}
