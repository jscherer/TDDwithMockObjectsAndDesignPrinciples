package tddmicroexercises.tirepressuremonitoringsystem;

public interface ISensor {
    final static double LOW_PRESSURE_THRESHOLD = 17;
    final static double HIGH_PRESSURE_THRESHOLD = 21;

	boolean isWithinThreshold();
}
