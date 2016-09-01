package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    final static double lowPressureThreshold = 17;
    final double highPressureThreshold = 21;

    private ISensor sensor = new Sensor();

    private boolean alarmOn = false;
    
    public Alarm() {
    }

    public Alarm(ISensor sensorBelowThreshhold) {
		this.sensor = sensorBelowThreshhold;
	}

	public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
