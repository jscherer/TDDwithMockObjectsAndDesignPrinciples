package jscherer.tddmicroexercises.turnticketdispenser;

public class TicketDispenser implements Sequence<TurnTicket> {

	protected static int turnNumber = 0;
	
	/**
	 * deprecated use next() instead
	 * @return TurnTicket with the next turnNumber
	 */
	public TurnTicket getTurnTicket() {
		return next();
	}

	
	/* (non-Javadoc)
	 * @see jscherer.tddmicroexercises.turnticketdispenser.Sequence#next()
	 * 
	 * override to change behavior of TurnTicket Sequence (Sequence<TurnTicket>)
	 */
	@Override
	public TurnTicket next() {
		return new TurnTicket(turnNumber++);
	}
}
