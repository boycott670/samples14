package ma.sqli.vehicules.code.entities.utils;

import java.util.Set;

import ma.sqli.vehicules.code.utils.Pair;

public final class MoveParseResultPair extends Pair<Set<Integer>, Double>
{

	private MoveParseResultPair(Set<Integer> first, Double second)
	{
		super(first, second);
		// TODO Auto-generated constructor stub
	}
	
	public static MoveParseResultPair of (final Set<Integer> lockedDoors, final double distanceInKilometers)
	{
		return new MoveParseResultPair(lockedDoors, distanceInKilometers);
	}
}
