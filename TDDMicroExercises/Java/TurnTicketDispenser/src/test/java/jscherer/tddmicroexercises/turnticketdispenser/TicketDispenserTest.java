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
	public void testIssueTwoDifferentTickets() {
		assertThat(ticket11, is(not(ticket12)));
	}
}
