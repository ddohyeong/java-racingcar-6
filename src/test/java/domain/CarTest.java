package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	public void 숫자가_4이상_9이하라면_전진한다(int randomNumber) {
		//given
		Car car = new Car();

		// when
		car.moveByNumber(randomNumber);

		//then
		Assertions.assertThat(car.getLocation()).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void 숫자가_0이상_3이하라면_멈춘다(int randomNumber) {
		//given
		Car car = new Car();

		// when
		car.moveByNumber(randomNumber);

		//then
		Assertions.assertThat(car.getLocation()).isEqualTo(0);
	}

	@Test
	public void 자동차가_움직인_거리만큼_하이픈_생성() {
		//given
		Car car = new Car();
		car.moveByNumber(4);
		// when
		String hyphenByLocation = car.createHyphenByLocation();

		//then
		Assertions.assertThat(hyphenByLocation).isEqualTo("-");
	}
}
