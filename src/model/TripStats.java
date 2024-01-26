package model;

/**
 * @author Misti Christianson - mchristianson
 * CIS175 - Spring 2024
 * Jan 25, 2024
 */
public class TripStats {
	private double gasPrice;
	private double tankCapacity;
	private double tripDistance;
	private double milesPerGallon;

	public TripStats() {
	}
	
	public TripStats(double gasPrice, double tankCapacity, double tripDistance, double milesPerGallon) {
		this();
		this.gasPrice = gasPrice;
		this.tankCapacity = tankCapacity;
		this.tripDistance = tripDistance;
		this.milesPerGallon = milesPerGallon;
		if (milesPerGallon <= 0) {
			throw new IllegalArgumentException("Miles Per Gallon cannot be zero or negative.");
		}
		if (tankCapacity <= 0) {
			throw new IllegalArgumentException("Tank Capacity cannot be zero or negative.");
		}
	}
		
	public double calculateGallonsPerTrip() {
		double gallonsPerTrip = 0.0;
		gallonsPerTrip = this.getTripDistance()/this.getMilesPerGallon();
		return gallonsPerTrip;
	}
	
	public double calculateTripFuelCost() {
		double fuelCost = 0.0;
		fuelCost = this.getGasPrice()*calculateGallonsPerTrip();
		return fuelCost;
	}
	
	public double calculateTanksPerTrip() {
		double tanksPerTrip = 0.0;
		tanksPerTrip = calculateGallonsPerTrip()/this.getTankCapacity();
		return tanksPerTrip;
	}
	/**
	 * @return the gasPrice
	 */
	public double getGasPrice() {
		return gasPrice;
	}
	/**
	 * @param gasPrice the gasPrice to set
	 */
	public void setGasPrice(double gasPrice) {
		this.gasPrice = gasPrice;
	}
	/**
	 * @return the tankCapacity
	 */
	public double getTankCapacity() {
		return tankCapacity;
	}
	/**
	 * @param tankCapacity the tankCapacity to set
	 */
	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	/**
	 * @return the tripDistance
	 */
	public double getTripDistance() {
		return tripDistance;
	}
	/**
	 * @param tripDistance the tripDistance to set
	 */
	public void setTripDistance(double tripDistance) {
		this.tripDistance = tripDistance;
	}
	/**
	 * @return the milesPerGallon
	 */
	public double getMilesPerGallon() {
		return milesPerGallon;
	}
	/**
	 * @param milesPerGallon the milesPerGallon to set
	 */
	public void setMilesPerGallon(double milesPerGallon) {
		this.milesPerGallon = milesPerGallon;
	}
	
	
}
