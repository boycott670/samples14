package ma.sqli.vehicules.code.parsers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import ma.sqli.vehicules.code.FuelType;
import ma.sqli.vehicules.code.entities.Car;
import ma.sqli.vehicules.code.entities.Motorcycle;
import ma.sqli.vehicules.code.entities.Truck;
import ma.sqli.vehicules.code.entities.Vehicle;
import ma.sqli.vehicules.code.entities.utils.MoveParseResultPair;

public final class DefaultVehiclesParser implements VehiclesParser
{

	@Override
	public Map<String, ? extends Vehicle> parseVehicles(String vehicles)
	{
		final Map<? super String, BiFunction<? super FuelType, ? super Integer, ? extends Vehicle>> codeForVehcileTypeMapping = new HashMap<>();
		
		codeForVehcileTypeMapping.put(Car.class.getSimpleName().toUpperCase(), Car::new);
		codeForVehcileTypeMapping.put(Truck.class.getSimpleName().toUpperCase(), Truck::new);
		codeForVehcileTypeMapping.put(Motorcycle.class.getSimpleName().toUpperCase(), Motorcycle::new);
		
		return Arrays.stream(vehicles.split(", "))
			.map(vehicle -> vehicle.split(":"))
			.collect(Collectors.toMap(
				vehicleTokens -> vehicleTokens[0],
				vehicleTokens -> codeForVehcileTypeMapping.get(vehicleTokens[0]).apply(FuelType.fromName(vehicleTokens[1]), Integer.valueOf(vehicleTokens[2]))));
	}

	@Override
	public MoveParseResultPair parseMoveMethodParameters(String lockedDoors, String distanceInKilometers)
	{
		// TODO Auto-generated method stub
		return MoveParseResultPair.of(
			Arrays.stream(lockedDoors.isEmpty() ? new String[0] : lockedDoors.split(" ")).map(Integer::valueOf).collect(Collectors.toSet()),
			Double.valueOf(distanceInKilometers.split(" ")[0]));
	}

}
