package jscherer.tddmicroexercises.turnticketdispenser;

public class TurnTicket {
	private final int turnNumber;

	public TurnTicket(int turnNumber) {
		this.turnNumber = turnNumber;
	}

	public int getTurnNumber() {
		return turnNumber;
	}
	
	public TurnTicket next() {
		return new TurnTicket(turnNumber + 1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + turnNumber;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TurnTicket))
			return false;
		TurnTicket other = (TurnTicket) obj;
		if (turnNumber != other.turnNumber)
			return false;
		return true;
	}
}
