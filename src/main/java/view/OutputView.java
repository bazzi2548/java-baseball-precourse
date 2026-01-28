package view;

public class OutputView {
	private static final String ERROR_PREFIX = "[ERROR] ";

	public void printStartMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");

	}

	public void printErrorMessage(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}
