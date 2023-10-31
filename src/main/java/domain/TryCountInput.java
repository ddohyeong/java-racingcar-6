package domain;

public class TryCountInput {

	public void validatePositive(int tryCount) {
		if (tryCount <= 0) {
			throw new IllegalArgumentException();
		}
	}
}
