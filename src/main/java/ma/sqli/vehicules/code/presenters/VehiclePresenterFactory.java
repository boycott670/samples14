package ma.sqli.vehicules.code.presenters;

import ma.sqli.vehicules.code.entities.Car;
import ma.sqli.vehicules.code.entities.Motorcycle;
import ma.sqli.vehicules.code.entities.Truck;
import ma.sqli.vehicules.code.entities.Vehicle;

public final class VehiclePresenterFactory
{
	public static VehiclePresenter<?> getVehiclePresenter (final Vehicle vehicle)
	{
		switch (vehicle.getClass().getSimpleName().toUpperCase())
		{
			case "CAR":
				return new CarPresenter((Car)vehicle);
				
			case "TRUCK":
				return new TruckPresenter((Truck)vehicle);
				
			case "MOTORCYCLE":
				return new MotorcyclePresenter((Motorcycle)vehicle);
		}
		
		throw new UnsupportedOperationException(String.format("A presenter for [%s] is not yet supported", vehicle.getClass().getName()));
	}
}
