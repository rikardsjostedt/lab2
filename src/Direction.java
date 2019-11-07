/**
 * Represents the available directions
 */
enum Direction {
	NORTH(0, 1),
	EAST(1, 0),
	SOUTH(0, -1),
	WEST(-1, 0);
	private final int x;
	private final int y;
	private static Direction[] vals = values(); //To avoid array copying

	/**
	 * Constrcutor for Direction
	 * @param x the x attribute
	 * @param y the y attribute
	 */
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Calculates the previous direction in an clockwise manner.
	 * @return the previous direction
	 */
	public Direction previous() {
		return vals[(this.ordinal() - 1) % vals.length];
	}

	/**
	 * Calculates the next direction in an clockwise manner
	 * @return the previous direction
	 */
	public Direction next() {
		return vals[(this.ordinal() + 1) % vals.length];
	}

	/**
	 *
	 * @return the x attribute
	 */
	public int getX() {
		return x;
	}

	/**
	 *
	 * @return the y attribute
	 */
	public int getY() {
		return y;
	}

}
