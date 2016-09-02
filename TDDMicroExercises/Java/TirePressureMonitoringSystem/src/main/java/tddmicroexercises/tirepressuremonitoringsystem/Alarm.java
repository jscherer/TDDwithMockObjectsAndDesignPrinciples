package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

	private Sensor sensor;
	private boolean alarmOn = false;

	/**
	 * DIP, constructor dependency injection
	 * @param sensorBelowThreshhold
	 */
	public Alarm(Sensor sensor) {
		this.sensor = sensor;
	}

	public boolean isAlarmOn() {
		return !sensor.isWithinThreshold();
	}
}
