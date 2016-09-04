package tddmicroexercises.tirepressuremonitoringsystem;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AlarmTest {
	
	@Mock
	private Sensor mockSensor;
	
	@Before
	public void setUp() {
		initMocks(this);
	}
	
	
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
		when(mockSensor.isWithinThreshold()).thenReturn(false);
		Alarm alarm = new Alarm(mockSensor);
		
		// act (when)
		alarm.isAlarmOn();
		
		// verify behaviour (then)
		verify(mockSensor).isWithinThreshold();
	}
	
	
}
