package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public int countStrike(BaseballNumbers other) {
		int strike = 0;
		for (int i = 0; i < numbers.size(); i++) {
			strike += checkStrikeAt(other, i);
		}
		return strike;
	}

	private int checkStrikeAt(BaseballNumbers other, int index) {
		if (this.numbers.get(index).equals(other.numbers.get(index))) {
			return 1;
		}
		return 0;
	}

	public int countBall(BaseballNumbers other) {
		int totalMatching = 0;
		Set<Integer> computerSet = new HashSet<>(this.numbers);

		for (int number : other.numbers) {
			totalMatching += checkMatching(computerSet, number);
		}

		return totalMatching - countStrike(other);
	}

	private int checkMatching(Set<Integer> set, int number) {
		if (set.contains(number)) {
			return 1;
		}
		return 0;
	}
}
