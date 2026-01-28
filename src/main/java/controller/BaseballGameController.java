package controller;

import utils.RandomNumberGenerator;

public class BaseballGameController {

	public BaseballGameController() {

	}

	public void start() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		do {
			playGame();
		} while (checkRestart());
	}

	private void playGame() {
		int[] numbers = RandomNumberGenerator.generate();

	}

	private boolean checkRestart() {

		return false;
	}
}
