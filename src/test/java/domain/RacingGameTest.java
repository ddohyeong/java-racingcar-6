package domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.controller.RacingGameController;

public class RacingGameTest {
	@Test
	public void 최대_이동한_거리를_찾는다() {
		//given
		List<String> namesList = Arrays.asList("pobi", "crong", "an");
		RacingGame racingGame = new RacingGame(namesList);
		RacingGameController racingGameController = new RacingGameController();

		List<Car> cars = racingGame.getCars();
		cars.get(0).moveByNumber(4);
		cars.get(0).moveByNumber(4);
		cars.get(1).moveByNumber(3);
		cars.get(2).moveByNumber(3);

		// when
		int locationWithMostMovement = racingGameController.findLocationWithMostMovement(cars);

		//then
		Assertions.assertThat(locationWithMostMovement).isEqualTo(2);
	}
}
