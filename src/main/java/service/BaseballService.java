package service;

import domain.BaseballNumbers;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseballService {

	private final InputView inputView;
	private final OutputView outputView;

	public BaseballService() {
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void playGame() {
		outputView.printStartMessage();

		BaseballNumbers computer = new BaseballNumbers(RandomNumberGenerator.generate());
		boolean isMatch = false;

		while (!isMatch) {
			try {
				BaseballNumbers player = new BaseballNumbers(inputView.readInput());
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}
}
