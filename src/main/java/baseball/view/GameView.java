package baseball.view;

import baseball.model.Result;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameView {
	private static final String INSERT_YOUR_NUMBERS = "숫자를 입력해주세요 : ";
	private static final String N_BALL_N_STRIKE = "%d볼 %d스트라이크";
	private static final String N_BALL = "%d볼";
	private static final String N_STRIKE = "%d스트라이크";
	private static final String NOTHING = "낫싱";
	private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String RESTART = "1";
	private static final String END = "2";

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

	public static boolean isRestart() {
		System.out.println(GAME_OVER);
		System.out.println(RESTART_OR_END);
		String input = readLine();
		if (input.equals(RESTART)) {
			return true;
		}
		if (input.equals(END)) {
			return false;
		}
		throw new IllegalArgumentException("1과 2 중에서만 선택 가능합니다.");
	}
}
