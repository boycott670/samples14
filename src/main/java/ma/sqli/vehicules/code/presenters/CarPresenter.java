package ma.sqli.vehicules.code.presenters;

import java.util.Locale;
import java.util.Set;

import ma.sqli.vehicules.code.entities.Car;

final class CarPresenter extends VehiclePresenter<Car>
{
	
	CarPresenter(Car vehicle)
	{
		super(vehicle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String present(final Set<Integer> lockedDoors, final double distanceInKilometers)
	{
		final Car car = getVehicle();
		
		if (car.getNumberOfDoors() == lockedDoors.size())
		{
			return String.format(Locale.US, "DOORS OK, MOVING. The CAR will consume %.2f L", car.getFuelType().willConsumeLiters(distanceInKilometers));
		}

		final StringBuilder report = new StringBuilder();
		
		report.append(String.format("DOORS KO, BLOCKED \n"));
		
		report.append(String.format("  _\n"));
		
		for (int doorIndex = 1 ; doorIndex <= car.getNumberOfDoors() ; doorIndex ++)
		{
			report.append(doorIndex == car.getNumberOfDoors() ? '_' : ' ');
			
			report.append(String.format("%c", lockedDoors.contains(doorIndex) ? '|' : doorIndex % 2 == 0 ? '\\' : '/'));
			
			if (doorIndex % 2 == 0 && doorIndex < car.getNumberOfDoors())
			{
				report.append(String.format("\n"));
			}
		}
		
		return report.toString();
	}
	
}
