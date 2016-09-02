package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
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
	public final void testAlarmIsOnWhenPressureNotWithinThreshholdOfSensorMock() {
		
		Sensor mockSensor = mock(Sensor.class);
		when(mockSensor.isWithinThreshold()).thenReturn(false);
		
		Alarm alarm = new Alarm(mockSensor);
		
		assertThat(alarm.isAlarmOn(), is(true));
		
		verify(mockSensor).isWithinThreshold();
	}
	
	
}
