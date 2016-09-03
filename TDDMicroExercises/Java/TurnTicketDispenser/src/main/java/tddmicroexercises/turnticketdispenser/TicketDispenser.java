package tddmicroexercises.turnticketdispenser;

/**
 * Manages a queuing system in a shop.
 * 
 * There may be more than one ticket dispenser but the same ticket should not be
 * issued to two different customers.
 * 
 * @author jscherer
 *
 */
public class TicketDispenser {

	public TurnTicket getTurnTicket() {
		int newTurnNumber = TurnNumberSequence.getNextTurnNumber();
		TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

		return newTurnTicket;
	}
}
