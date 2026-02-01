package service;

import domain.BaseballNumbers;


public class BaseballService {

	public String playRound(BaseballNumbers computer, BaseballNumbers player) {
		int strike = computer.countStrike(player);
		int ball = computer.countBall(player);
		return getResultMessage(strike, ball);
	}

	public String getResultMessage(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}
		return buildStrikeBallMessage(strike, ball).trim();
	}

	private String buildStrikeBallMessage(int strike, int ball) {
		StringBuilder message = new StringBuilder();
		if (ball > 0) {
			message.append(ball).append("볼 ");
		}
		if (strike > 0) {
			message.append(strike).append("스트라이크");
		}
		return message.toString();
	}
}
