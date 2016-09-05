package jscherer.tddmicroexercises.turnticketdispenser;

public class TicketDispenser implements Sequence<TurnTicket> {

	static int turnNumber = 0;
	private Sequence<TurnTicket> sequence;

	public TicketDispenser() {
		this.sequence = new DefaultSequence();
	}

	/**
	 * @param sequence
	 */
	public TicketDispenser(Sequence<TurnTicket> sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return
	 * @see jscherer.tddmicroexercises.turnticketdispenser.Sequence#next()
	 */
	@Override
	public TurnTicket next() {
		return sequence.next();
	}

	/**
	 * @return the turnNumber
	 */
	protected int getTurnNumber() {
		return TicketDispenser.turnNumber;
	}

	/**
	 * @param turnNumber the turnNumber to set
	 */
	protected static void setTurnNumber(int turnNumber) {
		TicketDispenser.turnNumber = turnNumber;
	}

	/**
	 * deprecated use next() instead
	 * 
	 * @return TurnTicket with the next turnNumber
	 */
	public TurnTicket getTurnTicket() {
		return next();
	}

	class DefaultSequence implements Sequence<TurnTicket> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see jscherer.tddmicroexercises.turnticketdispenser.Sequence#next()
		 */
		@Override
		public TurnTicket next() {
			return new TurnTicket(turnNumber++);
		}

	}
}
