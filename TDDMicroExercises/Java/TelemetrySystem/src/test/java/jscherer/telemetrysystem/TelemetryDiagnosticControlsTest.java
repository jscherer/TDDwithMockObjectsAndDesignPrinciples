package jscherer.telemetrysystem;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TelemetryDiagnosticControlsTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Mock
	private TelemetryClient mockTelemetryClient;
	@InjectMocks
	private TelemetryDiagnosticControls telemetryDiagnosticControls;

	@Before
	public void setUp() throws Exception {
	}

	@Test @Ignore // TODO make test work with mockito
	public void testSuccessfulConnectionWithMock() throws Exception {
		when(mockTelemetryClient.getOnlineStatus())
			.thenReturn(true);
		telemetryDiagnosticControls.checkTransmission();
		assertThat(telemetryDiagnosticControls.getDiagnosticInfo(), not(equalTo("")));
	}
	
	@Test @Ignore // TODO make test work 
	// maybe with mockito doThrow(Exception).when(mockTelemetryClient).setOnlineStatus(false);
	public void testUnableToConnectWithMock() {
		when(mockTelemetryClient.getOnlineStatus())
			.thenReturn(false);
		try {
			telemetryDiagnosticControls.checkTransmission();
			fail("Expected an Exception to be thrown");
		} catch (Exception e) {
			thrown.expect(Exception.class);
	        thrown.expectMessage("Unable to connect.");
		}
	}
}
