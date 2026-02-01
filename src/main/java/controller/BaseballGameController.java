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
		outputView.printStartMessage();
		BaseballNumbers computer = new BaseballNumbers(RandomNumberGenerator.generate());

		while (true) {
			BaseballNumbers player = askPlayerNumbers();
			String result = baseballService.playRound(computer, player);
			outputView.printResult(result);

			if (result.equals("3스트라이크")) break;
		}
		outputView.printGameEnd();
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
}
