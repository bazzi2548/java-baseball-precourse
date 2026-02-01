package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

	private final InputView inputView = new InputView();

	@ParameterizedTest
	@ValueSource(strings = {"3", "11", "22", " "})
	void validateRestartTest(String value){
		Assertions.assertThatThrownBy(() -> inputView.validateRestart(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("1 또는 2만 입력 가능합니다.");
	}
}
