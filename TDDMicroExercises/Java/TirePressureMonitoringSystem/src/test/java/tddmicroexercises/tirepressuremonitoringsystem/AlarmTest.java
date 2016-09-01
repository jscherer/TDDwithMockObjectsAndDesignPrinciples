package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlarmTest {

	Alarm alarm = new Alarm();
	
	@Before
	public void setUp() throws Exception {
		alarm = new Alarm();
	}
	
	@Test
	public void testCreateAlarm() {
		assertThat(alarm, notNullValue());
	}

	@Test
	public final void testAlarmIsOffWhenCreated() {
		assertThat(alarm.isAlarmOn(), is(false));
	}
	
	@Test
	public final void testAlarmIsOnWhenPressureBelowThreshhold() {
		alarm = new Alarm(new ISensor() {
			
			@Override
			public double popNextPressurePsiValue() {
				return Alarm.lowPressureThreshold -1;
			}
		});
		assertThat(alarm.isAlarmOn(), is(true));	
	}


}
