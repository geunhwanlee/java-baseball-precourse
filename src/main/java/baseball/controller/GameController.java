package baseball.controller;

import baseball.model.Computer;
import baseball.model.Result;
import baseball.util.BaseballRandomList;
import baseball.view.GameView;

public class GameController {
	public void play() {
		Computer computer = Computer.pick(new BaseballRandomList());
		boolean isAnswer = false;
		while (!isAnswer) {
			Result result = computer.match(GameView.insertYourNumbers());
			GameView.showHint(result);
			isAnswer = result.isAnswer();
		}
	}
}
