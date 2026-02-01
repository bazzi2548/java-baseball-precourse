package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumbersTest {

	@ParameterizedTest
	@ValueSource(strings = {"12", "1234", ""})
	@DisplayName("입력된 숫자가 3자리가 아니면 IllegalArgumentException이 발생한다")
	void validateLengthTest(String input) {
		assertThatThrownBy(() -> new BaseballNumbers(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("정상적인 숫자 입력 시 List로 변환되어 저장된다")
	void createNumbersTest() {
		BaseballNumbers numbers = new BaseballNumbers("123");
		assertThat(numbers.getNumbers()).containsExactly(1, 2, 3);
	}

	@ParameterizedTest
	@ValueSource(strings = {"112", "122", "333", "919"})
	@DisplayName("중복된 숫자가 입력되면 IllegalArgumentException이 발생한다")
	void validateDuplicateTest(String input) {
		assertThatThrownBy(() -> new BaseballNumbers(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복된 숫자가 있습니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"aaa", "AAA", "춘식이", "라2언"})
	@DisplayName("문자 입력시 IllegalArgumentException이 발생한다")
	void validateNumericTest(String input) {
		assertThatThrownBy(() -> new BaseballNumbers(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("숫자 이외의 문자는 입력할 수 없습니다.");
	}

	@Test
	@DisplayName("1미만, 9초과시 IllegalArgumentException이 발생한다")
	void validateNumberRangeTest() {
		assertThatThrownBy(() -> new BaseballNumbers("000"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("1에서 9 사이의 숫자만 입력 가능합니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {
		"123:3", // 3스트라이크
		"124:2", // 2스트라이크
		"145:1", // 1스트라이크
		"456:0"  // 0스트라이크
	}, delimiter = ':')
	@DisplayName("다양한 입력값에 대해 스트라이크 개수를 검증한다")
	void countStrikeTest(String input, int expectedStrike) {
		BaseballNumbers computer = new BaseballNumbers("123");
		BaseballNumbers player = new BaseballNumbers(input);

		int actualStrike = computer.countStrike(player);

		assertThat(actualStrike).isEqualTo(expectedStrike);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"312:3", // 3볼
		"132:2", // 2볼
		"761:1", // 1볼
		"456:0"  // 낫싱
	}, delimiter = ':')
	@DisplayName("다양한 입력값에 대해 볼 개수를 검증한다")
	void countBallTest(String input, int expectedBall) {
		BaseballNumbers computer = new BaseballNumbers("123");
		BaseballNumbers player = new BaseballNumbers(input);

		int actualStrike = computer.countBall(player);

		assertThat(actualStrike).isEqualTo(expectedBall);
	}
}
