package jscherer.tddmicroexercises.turnticketdispenser;

public class TicketDispenser implements Sequence<TurnTicket>{

	private static int turnNumber = 0;
	
	public TurnTicket getTurnTicket() {
		return next();
	}

	@Override
	public TurnTicket next() {
		return new TurnTicket(turnNumber++);
	}
}
