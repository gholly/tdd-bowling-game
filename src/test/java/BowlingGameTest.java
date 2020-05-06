import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import tdd.bowling.games.BowlingGame;
import tdd.bowling.games.Frame;
import tdd.bowling.games.OutOfFramesException;


import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {


    @Test
    public void should_return_0_when_calculate_game_score_given_10_frames_no_hit() throws OutOfFramesException {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 10; i++) {
            game.throwRoll(0, 0);
        }
        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    public void should_return_40_when_calculate_game_score_given_10_frames_4_hits() throws OutOfFramesException {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 10; i++) {
            game.throwRoll(2, 2);
        }
        assertThat(game.getScore()).isEqualTo(40);
    }

    @Test
    public void should_return_48_when_calculate_game_score_given_first_frame_spare_other_frame_4_hits() throws OutOfFramesException {
        BowlingGame game = new BowlingGame();
        game.throwSpareRoll(2,8);
        for (int i = 0; i < 9; i++) {
            game.throwRoll(2, 2);
        }
        assertThat(game.getScore()).isEqualTo(48);

    }

    @Test
    public void should_return_50_when_calculate_game_score_given_first_frame_strike_other_frame_4_hits() throws OutOfFramesException {
        BowlingGame game = new BowlingGame();
        game.throwStrikeRoll(10,0);
        for (int i = 0; i < 9; i++) {
            game.throwRoll(2, 2);
        }
        assertThat(game.getScore()).isEqualTo(50);

    }

    @Test
    public void should_return_150_when_calculate_game_score_given_all_frame_spare() throws OutOfFramesException {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 9; i++) {
            game.throwSpareRoll(5, 5);
        }
        game.throwTenthFrame(5,5,5);
        assertThat(game.getScore()).isEqualTo(150);

    }

    @Test
    public void should_return_300_when_calculate_game_score_given_all_frame_strike() throws OutOfFramesException {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 9; i++) {
            game.throwStrikeRoll(10, 0);
        }
        game.throwTenthFrame(10,10,10);
        assertThat(game.getScore()).isEqualTo(300);

    }

}
