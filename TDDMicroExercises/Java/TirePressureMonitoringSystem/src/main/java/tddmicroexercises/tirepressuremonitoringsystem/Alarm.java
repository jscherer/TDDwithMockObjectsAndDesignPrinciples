package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

	private Sensor sensor;
	private boolean alarmOn = false;

	/**
	 * OCP, DIP: constructor dependency injection of Sensor Interface
	 * 
	 * @param sensorBelowThreshhold
	 */
	public Alarm(Sensor sensor) {
		this.sensor = sensor;
	}

	public boolean isAlarmOn() {
		return !sensor.isWithinThreshold();
	}

	/**
	 * @deprecated SRP: Alarm should not check Pressure
	 * use isAlarmOn() instead
	 */
	public void check() {
		PressureSensor ps = (PressureSensor) sensor;
		ps.check();
	}
}
