package view;

import java.util.Scanner;

public class InputView {
	Scanner sc = new Scanner(System.in);

	public String readInput() {
		return sc.nextLine();
	}

	public String readRestartInput() {
		String input = readInput(); // 공통 입력 메서드 호출
		validateRestart(input);
		return input;
	}

	private void validateRestart(String input) {
		if (!input.equals("1") && !input.equals("2")) {
			throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
		}
	}
}
