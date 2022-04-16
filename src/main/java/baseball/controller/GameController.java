package baseball.controller;

import baseball.model.Computer;
import baseball.util.BaseballRandomList;

public class GameController {
	public void play() {
		Computer.pick(new BaseballRandomList());
	}
}
