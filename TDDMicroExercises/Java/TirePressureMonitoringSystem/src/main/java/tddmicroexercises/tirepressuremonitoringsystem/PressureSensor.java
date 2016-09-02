package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

public class PressureSensor implements Sensor {

	public static final double OFFSET = 16;

	private final double lowPressureThreshold = 17;
	private final double highPressureThreshold = 21;
	private boolean inThreshold = true;

	public double popNextPressurePsiValue() {
		double pressureTelemetryValue;
		pressureTelemetryValue = samplePressure();

		return OFFSET + pressureTelemetryValue;
	}

	private static double samplePressure() {
		// placeholder implementation that simulate a real sensor in a real tire
		Random basicRandomNumbersGenerator = new Random();
		double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble()
				* basicRandomNumbersGenerator.nextDouble();
		return pressureTelemetryValue;
	}

	/**
	 * replaces check() in Alarm (SRP: Alarm should not check Pressure)
	 */
	@Override
	public boolean isWithinThreshold() {
		check();
		return inThreshold;
	}

	void check() {
		double psiPressureValue = popNextPressurePsiValue();

		if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue) {
			inThreshold = false;
		}
	}
}
