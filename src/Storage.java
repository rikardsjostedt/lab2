public abstract class Storage implements Loadable
{
    private int length;
    private int width;
    private int capacity;

    //TODO ADD UPDATE WHEN STORAGE IS MOVING TO MOVE ITS CONTENT OR MOVE COMMENT TO RESPONSIBLE CLASS
    public Storage(int length, int width, int capacity)
    {
        this.length = length;
        this.width = width;
        this.capacity = capacity;
    }
}
