package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

	private Sensor sensor;
	private boolean alarmOn = false;

	/**
	 * OCP, DIP: constructor dependency injection of Sensor Interface
	 * @param sensorBelowThreshhold
	 */
	public Alarm(Sensor sensor) {
		this.sensor = sensor;
	}

	public boolean isAlarmOn() {
		return !sensor.isWithinThreshold();
	}
}
