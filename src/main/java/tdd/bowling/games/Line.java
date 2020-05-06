package tdd.bowling.games;


public class Line {
    public Frame firstFrame;
    public Frame lastFrame;


    public void AddFrame(Frame frame) throws OutOfFramesException {

        if (firstFrame == null) {
            frame.number = 1;
            firstFrame = frame;
            lastFrame = frame;
        } else {
            if (lastFrame.number == 10) {
                throw new OutOfFramesException();
            }
            frame.number = lastFrame.number + 1;
            lastFrame.nextFrame = frame;
            lastFrame = frame;
        }

    }
}
