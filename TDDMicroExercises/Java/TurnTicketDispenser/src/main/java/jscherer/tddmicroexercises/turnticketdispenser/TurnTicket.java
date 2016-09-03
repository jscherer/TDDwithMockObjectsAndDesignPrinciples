package jscherer.tddmicroexercises.turnticketdispenser;

public class TurnTicket {
	
	private final int turnNumber;

	public TurnTicket(int turnNumber) {
		this.turnNumber = turnNumber;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TurnTicket [turnNumber=" + turnNumber + "]";
	}
	
}
