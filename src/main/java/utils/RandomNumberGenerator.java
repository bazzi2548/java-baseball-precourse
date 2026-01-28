package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
	private static final Random random = new Random();

	public static List<Integer> generate() {
		List<Integer> numbers = new ArrayList<>();
		int index = 0;

		while (index < 3) {
			int num = getNumber();
			if (isDuplicate(numbers, num)){
				continue;
			}

			numbers.add(num);
			index++;
		}

		return numbers;
	}

	private static int getNumber(){
		return random.nextInt(1, 10);
	}

	private static boolean isDuplicate(List<Integer> numbers, int num){
		for (Integer number : numbers) {
			if (number == num)
				return true;
		}

		return false;
	}
}
