package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

public class Sensor implements ISensor {
	public static final double OFFSET = 16;

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

	@Override
	public boolean isWithinThreshold() {
		boolean inThreshold = true;
		double psiPressureValue = popNextPressurePsiValue();

		if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
			inThreshold = false;
		}
		return inThreshold;
	}
}
