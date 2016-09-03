package jscherer.tddmicroexercises.turnticketdispenser;

public class TicketDispenser implements Sequence<TurnTicket> {

	protected static int turnNumber = 0;
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
	public TurnTicket next() {
		return sequence.next();
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
