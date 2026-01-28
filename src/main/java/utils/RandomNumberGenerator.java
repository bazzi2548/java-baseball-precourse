package utils;

import java.util.Random;

public class RandomNumberGenerator {
	private static final Random random = new Random();

	public static int[] generate() {
		int[] numbers = new int[3];
		int index = 0;

		while (index < numbers.length) {
			int num = getNumber();
			if (isDuplicate(numbers, num)){
				continue;
			}
			numbers[index] = num;
			index++;
		}

		return numbers;
	}

	private static int getNumber(){
		return random.nextInt(1, 10);
	}

	private static boolean isDuplicate(int[] numbers, int num){
		for (int i = 0; i < 3; i++) {
			if (numbers[i] == num) return true;
		}
		return false;
	}
}
