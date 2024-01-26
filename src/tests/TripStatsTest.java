package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.TripStats;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Jan 25, 2024
 */
public class TripStatsTest {
	private TripStats trip;
	
	@Before
	public void setUp() throws Exception {
		trip = new TripStats(4.50, 15, 1750, 21);
	}

	@Test
	public void testCalculateGallonsPerTrip() {
		Assert.assertEquals(83.33, trip.calculateGallonsPerTrip(), .01);
	}

	@Test
	public void testZeroMPGValueFail() {
		try {
			new TripStats (0, 0, 0, 0);
			Assert.fail();
		} catch(Exception e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void testNegativeMPGValueFail() {
		try {
			new TripStats (0, 0, 0, -21);
			Assert.fail();
		} catch(Exception e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
			Assert.assertEquals("Miles Per Gallon cannot be zero or negative.", e.getMessage());
		}
	}
	
	@Test
	public void testCalculateTripFuelCost() {
		Assert.assertEquals(375.0, trip.calculateTripFuelCost(), .01);
	}
	
	@Test
	public void testCalculateTanksPerTrip() {
		Assert.assertEquals(5.55, trip.calculateTanksPerTrip(), .01);
	}
	
	@Test
	public void testZeroValueTankCapacityFail() {
		try {
			new TripStats (0, 0, 0, 21);
			Assert.fail();
		} catch(Exception e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void testNegativeValueTankCapacityFail() {
		try {
			new TripStats (0, -15, 0, 21);
			Assert.fail();
		} catch(Exception e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
			Assert.assertEquals("Tank Capacity cannot be zero or negative.", e.getMessage());
		}
	}
	
}
