package baseball.view;

import baseball.model.Result;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameView {
	private static final String INSERT_YOUR_NUMBERS = "숫자를 입력해주세요 : ";
	private static final String N_BALL_N_STRIKE = "%d볼 %d스트라이크";
	private static final String N_BALL = "%d볼";
	private static final String N_STRIKE = "%d스트라이크";
	private static final String NOTHING = "낫싱";

	public static String insertYourNumbers() {
		System.out.print(INSERT_YOUR_NUMBERS);
		return readLine();
	}

	public static void showHint(Result result) {
		System.out.println(getHint(result.getBallCount(), result.getStrikeCount()));
	}

	private static String getHint(int ballCount, int strikeCount) {
		if (ballCount > 0 && strikeCount > 0) {
			return String.format(N_BALL_N_STRIKE, ballCount, strikeCount);
		}
		if (ballCount > 0 && strikeCount == 0) {
			return String.format(N_BALL, ballCount);
		}
		if (ballCount == 0 && strikeCount > 0) {
			return String.format(N_STRIKE, strikeCount);
		}
		return NOTHING;
	}
}
