package ma.sqli.vehicules.code;

import java.util.Map;

import ma.sqli.vehicules.code.entities.Vehicle;
import ma.sqli.vehicules.code.entities.utils.MoveParseResultPair;
import ma.sqli.vehicules.code.parsers.DefaultVehiclesParser;
import ma.sqli.vehicules.code.parsers.VehiclesParser;

public final class Vehicles
{
	private final VehiclesParser vehiclesParser = new DefaultVehiclesParser();
	private final Map<String, ? extends Vehicle> vehicles;
	
	public Vehicles (final String vehicles)
	{
		this.vehicles = vehiclesParser.parseVehicles(vehicles);
	}
	
	public String move (final String vehicle, final String lockedDoors, final String distanceInKilometers)
	{
		final MoveParseResultPair moveParseResultPair = vehiclesParser.parseMoveMethodParameters(lockedDoors, distanceInKilometers);
		
		return vehicles.get(vehicle).move(moveParseResultPair.getFirst(), moveParseResultPair.getSecond());
	}
}
