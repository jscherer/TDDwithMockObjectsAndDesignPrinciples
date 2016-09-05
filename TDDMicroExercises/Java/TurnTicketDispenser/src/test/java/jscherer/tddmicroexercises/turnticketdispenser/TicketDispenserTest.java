package jscherer.tddmicroexercises.turnticketdispenser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class TicketDispenserTest {

	TicketDispenser dispenser1, dispenser2;
	TurnTicket nullTicket, ticket11, ticket12, ticket21;
	
	@Mock Sequence<TurnTicket> mockSequence; // threw NPE, why?

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		
		TicketDispenser.setTurnNumber(0);
		
		dispenser1 = new TicketDispenser();
		ticket11 = dispenser1.getTurnTicket();
		ticket12 = dispenser1.getTurnTicket();

		dispenser2 = new TicketDispenser();
		ticket21 = dispenser2.getTurnTicket();
	}

	@Test
	public final void testIssueOneTicket() {
		assertThat(ticket11, is(not(nullTicket)));
	}

	@Test
	public void testIssueTwoDifferentTicketsFromDispenser1() {
		assertThat(ticket11, is(not(ticket12)));
	}

	@Test
	public void testIssueTwoDifferentTicketsFromTwoDispensers() {
		assertThat(ticket11, is(not(ticket21)));
	}

	@Test
	public void testTestTicketSequenceStepSize10WithNestedClass() {
		TicketDispenser dispenser = new TicketDispenserStepSize10();
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(10))));
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(20))));
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(30))));
	}

	@Test
	public void testTestTicketSequenceStepSize10WithConstructorInjection() {
		
		TicketDispenser.setTurnNumber(0);  // fails if removed!
		TicketDispenser dispenser = new TicketDispenser(() -> {
			return new TurnTicket(TicketDispenser.turnNumber += 10);
		});
		
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(10))));
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(20))));
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(30))));
	}

	@Test
	public void testDispenseThreeTicketsWithMockedSequence() {
		when(mockSequence.next())
			.thenReturn(new TurnTicket(10), new TurnTicket(20), new TurnTicket(30));

		TicketDispenser dispenser = new TicketDispenser(mockSequence);
		
		dispenseThreeTurnTickets(dispenser);
		
		verify(mockSequence, times(3)).next();
	}	
	
	/**
	 * @param dispenser
	 */
	private void dispenseThreeTurnTickets(TicketDispenser dispenser) {
		dispenser.next();
		dispenser.next();
		dispenser.next();
	}

	static class TicketDispenserStepSize10 extends TicketDispenser {
		static int turnNumber = 0;

		@Override
		public TurnTicket next() {
			return new TurnTicket(turnNumber += 10);
		}
	}
}

