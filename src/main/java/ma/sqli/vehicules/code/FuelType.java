package ma.sqli.vehicules.code;

import java.util.Arrays;

public enum FuelType
{
	DIESEL(.05, "Diesel"),
	FUEL(.06, "Gasoline"),
	HYBRID(.03, "Hybrid");

	private final double consumptionRate;
	private final String prettyName;
	
	private FuelType (final double consumptionRate, final String prettyName)
	{
		this.consumptionRate = consumptionRate;
		this.prettyName = prettyName;
	}
	
	
	public String getPrettyName()
	{
		return prettyName;
	}



	public double willConsumeLiters (final double kilometers)
	{
		return consumptionRate * kilometers;
	}
	
	public static FuelType fromName (final String name)
	{
		return Arrays.stream(values())
			.filter(fuelType -> fuelType.getPrettyName().equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Invalid fuel type name"));
	}
}
