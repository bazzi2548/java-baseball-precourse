package view;

public class OutputView {
	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_GUIDE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public void printStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public void printResult(String resultMessage) {
		System.out.println(resultMessage);
	}

	public void printGameEnd() {
		System.out.println(GAME_END_MESSAGE);
		System.out.println(RESTART_GUIDE_MESSAGE);
	}

	public void printErrorMessage(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}
