package robotwar.common.robotbase;

public enum MOVEMENT {
	LEFT(0), RIGHT(1), UP(2), DOWN(3), NONE(4);

	private int value;

	MOVEMENT(int pValue) {
		value = pValue;
	}

	public int getValue() {
		return value;
	}
}
