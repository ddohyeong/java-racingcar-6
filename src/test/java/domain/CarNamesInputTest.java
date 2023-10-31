package domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNamesInputTest {
	private static final CarNamesInput validatedCarNamesInput = new CarNamesInput("abc");

	@Test
	public void 이름은_쉼표로_구분한다() {
		//given
		String names = "pobi,crong";
		// when
		CarNamesInput carNamesInput = new CarNamesInput(names);
		List<String> nameList = carNamesInput.splitByCommaToList(names);
		//then
		Assertions.assertThat(nameList).containsExactly("pobi", "crong");
	}

	@Test
	void 이름은_5글자_이하가_아니라면_예외발생() {
		//given
		String name = "abcedf";

		// when & then
		Assertions.assertThatThrownBy(() -> validatedCarNamesInput.validateNameLength(name))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 이름이_공백이면_예외_발생() {
		//given
		String name = " ";
		// when & then
		Assertions.assertThatThrownBy(() -> validatedCarNamesInput.validateNameBlank(name))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 이름이_빈_값이면_예외_발생() {
		//given
		String name = "";
		// when & then
		Assertions.assertThatThrownBy(() -> validatedCarNamesInput.validateNameEmpty(name))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 이름들에_중복이_있으면_에외_발생() {
		//given
		List<String> names = Arrays.asList("pobi","pobi");

		// when & then
		Assertions.assertThatThrownBy(() -> validatedCarNamesInput.validateNamesDuplicate(names))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 이름_앞뒤로_공백시_없애기() {
		//given
		String name = " asdf ";
		CarNamesInput carNamesInput = new CarNamesInput("abc");
		// when & then
		String trimmedName = carNamesInput.trimName(name);
		Assertions.assertThat(trimmedName).isEqualTo("asdf");
	}
}
