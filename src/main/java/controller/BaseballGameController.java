package controller;

import domain.BaseballNumbers;
import service.BaseballService;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseballGameController {
	private final BaseballService baseballService = new BaseballService();
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void start() {
		boolean isRunning = true;
		while (isRunning) {
			playOneGame();
			isRunning = askRestart();
		}
	}

	private void playOneGame() {
		outputView.printStartMessage();
		BaseballNumbers computer = new BaseballNumbers(RandomNumberGenerator.generate());
		boolean isGameEnd = false;
		while (!isGameEnd) {
			isGameEnd = playTurn(computer);
		}
		outputView.printGameEnd();
	}

	private boolean playTurn(BaseballNumbers computer) {
		BaseballNumbers player = askPlayerNumbers();
		String result = baseballService.playRound(computer, player);
		outputView.printResult(result);
		return result.equals("3스트라이크");
	}

	private BaseballNumbers askPlayerNumbers() {
		while (true) {
			try {
				return new BaseballNumbers(inputView.readInput());
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private boolean askRestart() {
		while (true) {
			try {
				String input = inputView.readRestartInput();
				return input.equals("1");
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}
}
