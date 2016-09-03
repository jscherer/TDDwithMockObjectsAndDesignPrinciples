package jscherer.tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence {
	
	static int min = 1;

	public static int getNextTurnNumber() {
		return nextValue();
	}
	
	public static int nextValue() {
		return min++;
	}

	public static void startWith(int min) {
		TurnNumberSequence.min = min;
	}
}
