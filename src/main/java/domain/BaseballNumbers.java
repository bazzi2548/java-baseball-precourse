package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {
	private final List<Integer> numbers;

	public BaseballNumbers(String numbers) {
		validateLength(numbers);
		this.numbers = parseInput(numbers);
	}

	public BaseballNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	private List<Integer> parseInput(String input) {
		List<Integer> numbers = new ArrayList<>();

		for (char c : input.toCharArray()) {
			int number = Character.getNumericValue(c);
			validateNumeric(number);
			validateNumberRange(number);

			numbers.add(number);
		}

		validateDuplicate(numbers);
		return numbers;
	}

	private void validateDuplicate(List<Integer> numbers) {
		HashSet<Integer> compare = new HashSet<>(numbers);

		if (numbers.size() != compare.size()) {
			throw new IllegalArgumentException("중복된 숫자가 있습니다.");
		}
	}

	private void validateLength(String numbers) {
		if (numbers.length() != 3) throw new IllegalArgumentException("입력은 세 글자만 가능합니다.");
	}

	private void validateNumeric(int numbers) {
		if (numbers == -1) throw new IllegalArgumentException("숫자가 아닌 문자가 포함되었습니다.");
	}

	private void validateNumberRange(int number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException("1에서 9 사이의 숫자만 입력 가능합니다.");
		}
	}
}
