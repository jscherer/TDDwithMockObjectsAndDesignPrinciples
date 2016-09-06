package jscherer.telemetrysystem;

public class TelemetryDiagnosticControls {
	private static final String DIAGNOSTIC_CHANNEL_CONNECTION_STRING = "*111#";

	private final TelemetryClient telemetryClient;
	private String diagnosticInfo = "";

	public TelemetryDiagnosticControls() {
		telemetryClient = new TelemetryClient();
	}

	public String getDiagnosticInfo() {
		return diagnosticInfo;
	}

	public void setDiagnosticInfo(String diagnosticInfo) {
		this.diagnosticInfo = diagnosticInfo;
	}

	/**
	 * establishes a connection to the telemetry server through the TelemetryClient, 
	 * sends a diagnostic request and receives the response with diagnostic info.
	 * 
	 * @throws Exception
	 */
	public void checkTransmission() throws Exception {
		diagnosticInfo = "";

		telemetryClient.disconnect();

		// 3 trials to establishes a connection to the telemetry server
		int retryLeft = 3;
		while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
			telemetryClient.connect(DIAGNOSTIC_CHANNEL_CONNECTION_STRING);
			retryLeft -= 1;
		}

		if (!telemetryClient.getOnlineStatus()) {
			throw new Exception("Unable to connect.");
		}

		// sends a diagnostic request and receives the response with diagnostic info.
		telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
		diagnosticInfo = telemetryClient.receive();
	}
}
