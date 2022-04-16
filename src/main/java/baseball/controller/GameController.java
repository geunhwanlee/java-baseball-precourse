package baseball.controller;

import baseball.model.Computer;
import baseball.util.BaseballRandomList;
import baseball.view.GameView;

public class GameController {
	public void play() {
		Computer computer = Computer.pick(new BaseballRandomList());
		computer.match(GameView.insertYourNumbers());
	}
}
