package service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballServiceTest {

	private final BaseballService baseballService = new BaseballService();

	@ParameterizedTest
	@CsvSource(value = {
		"0, 0, 낫싱",
		"0, 1, 1볼",
		"0, 3, 3볼",
		"1, 0, 1스트라이크",
		"3, 0, 3스트라이크",
		"1, 1, 1볼 1스트라이크",
		"2, 1, 1볼 2스트라이크" // 상황에 따라 순서 확인 필요 (보통 볼이 먼저)
	})
	@DisplayName("스트라이크와 볼 개수에 따라 정확한 한글 메시지를 생성한다")
	void getResultMessageTest(int strike, int ball, String expected) {
		String result = baseballService.getResultMessage(strike, ball);
		assertThat(result).isEqualTo(expected);
	}
}
