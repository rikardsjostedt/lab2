public abstract class Truck implements Transportable
{

	private MoveHelper moveHelper;
	private int maxSpeed;

	public Truck(int x, int y, int maxSpeed) {
		this.moveHelper = new MoveHelper(x,y,this);
		this.maxSpeed = maxSpeed;
	}
	//TODO THIS IS PARTLY DUPLICATED CODE!!! SHOULD THIS BE IN MOVEHELPER? (gas+brake)
	/**
	 * Calls incrementSpeed as long as the supplied amount is in the interval [0, 1]
	 * @param amount the amount to increase speed with
	 */
	public void gas(double amount){
		if (amount > 1 || amount < 0 )//TODO ADD CHECK FOR FLATBED DOWN
			return;
		moveHelper.incrementSpeed(amount);
		moveHelper.move();
	}

	/**
	 * Calls decrementSpeed as long as the supplied amount is in the interval [0, 1]
	 * @param amount the amount to decrease speed with
	 */
	public void brake(double amount){
		if (amount > 1 || amount < 0)
			return;
		moveHelper.decrementSpeed(amount);
		moveHelper.move();
	}

	public int getMaxSpeed()
	{
		return maxSpeed;
	}

}
