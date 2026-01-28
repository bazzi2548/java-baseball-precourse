package controller;

import service.BaseballService;

public class BaseballGameController {
	private final BaseballService baseballService;

	public BaseballGameController() {
		baseballService = new BaseballService();
	}

	public void start() {
		do {
			baseballService.playGame();
		} while (checkRestart());
	}

	private boolean checkRestart() {

		return false;
	}
}
