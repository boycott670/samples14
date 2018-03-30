package ma.sqli.vehicules.code.parsers;

import java.util.Map;

import ma.sqli.vehicules.code.entities.Vehicle;
import ma.sqli.vehicules.code.entities.utils.MoveParseResultPair;

public interface VehiclesParser
{
	Map<String, ? extends Vehicle> parseVehicles (final String vehicles);
	MoveParseResultPair parseMoveMethodParameters (final String lockedDoors, final String distanceInKilometers);
}
