package tddmicroexercises.tirepressuremonitoringsystem;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class AlarmTest {
	
	@Test
	public final void testAlarmIsOnWhenPressureNotWithinThreshhold() {
		Alarm alarm = new Alarm(new Sensor() {

			@Override
			public boolean isWithinThreshold() {
				return false;
			}
		});
		
		assertThat(alarm.isAlarmOn(), is(true));	
	}
	
	
	@Test
	public final void testAlarmIsOnWhenPressureNotWithinThreshholdJava8() {
		Alarm alarm = new Alarm( () -> false );
		assertThat(alarm.isAlarmOn(), is(true));	
	}
		
	@Test
	public final void testAlarmIsOnWhenPressureNotWithinThreshholdSensorMock() {
		// arrange (given)
		Sensor mockSensor = mock(Sensor.class);
		when(mockSensor.isWithinThreshold()).thenReturn(false);
		
		Alarm alarm = new Alarm(mockSensor);
		
		// act (when)
		alarm.isAlarmOn();
		
		// verify behaviour (then)
		verify(mockSensor).isWithinThreshold();
	}
	
	
}
