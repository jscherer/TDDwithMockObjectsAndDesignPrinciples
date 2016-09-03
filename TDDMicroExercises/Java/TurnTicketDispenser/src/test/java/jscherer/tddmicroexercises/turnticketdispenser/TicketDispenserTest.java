package jscherer.tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class TicketDispenserTest {

	TicketDispenser dispenser1, dispenser2;
	TurnTicket nullTicket, ticket11, ticket12, ticket21;

	@Before
	public void setUp() throws Exception {
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
		TicketDispenser.turnNumber = 0;
		TicketDispenser dispenser = new TicketDispenser(new Sequence<TurnTicket>() {
			@Override
			public TurnTicket next() {
				return new TurnTicket(TicketDispenser.turnNumber += 10);
			}
		});
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(10))));
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(20))));
		assertThat(dispenser.next(), is(equalTo(new TurnTicket(30))));
	}

	// TODO: How to do this with a Java 8 lambda expression

	static class TicketDispenserStepSize10 extends TicketDispenser {
		static int turnNumber = 0;

		@Override
		public TurnTicket next() {
			return new TurnTicket(turnNumber += 10);
		}
	}
}
