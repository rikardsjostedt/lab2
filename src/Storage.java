public abstract class Storage implements Loadable
{
    private int length;
    private int width;
    private int capacity;

    public Storage(int length, int width, int capacity)
    {
        this.length = length;
        this.width = width;
        this.capacity = capacity;
    }
}
