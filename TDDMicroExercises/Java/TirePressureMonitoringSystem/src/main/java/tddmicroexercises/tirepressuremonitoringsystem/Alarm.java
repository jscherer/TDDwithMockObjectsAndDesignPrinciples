package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

	private ISensor sensor;
	private boolean alarmOn = false;

	public Alarm(ISensor sensorBelowThreshhold) {
		this.sensor = sensorBelowThreshhold;
	}

	public boolean isAlarmOn() {
		return !sensor.isWithinThreshold();
	}
}
