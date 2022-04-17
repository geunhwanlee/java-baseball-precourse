package baseball.controller;

import baseball.model.Computer;
import baseball.model.Result;
import baseball.util.BaseballRandomList;
import baseball.view.GameView;

public class GameController {
	public void play() {
		Computer computer = Computer.pick(new BaseballRandomList());
		while (true) {
			Result result = computer.match(GameView.insertYourNumbers());
			GameView.showHint(result);
		}
	}
}
