package ma.sqli.vehicules.code.utils;

public abstract class Pair<F, S>
{
	private final F first;
	private final S second;
	
	protected Pair(F first, S second)
	{
		this.first = first;
		this.second = second;
	}

	public F getFirst()
	{
		return first;
	}

	public S getSecond()
	{
		return second;
	}
}
