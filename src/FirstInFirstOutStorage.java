import java.util.LinkedList;
import java.util.Queue;

public class FirstInFirstOutStorage<T extends Transportable> extends Storage
{
    private Queue<T> storage = new LinkedList<>();

    public FirstInFirstOutStorage(int length, int width, int capacity)
    {
        super(length,width,capacity);
    }


    //TODO ADD CHECKS TO MAKE SURE ENTITY ISNT LOADED SOMEWHERE ELSE, AND CHECK TO MAKE SURE ITS NEARBY
    public void load(T entity)
    {
        storage.add(entity);
    }

    //TODO ADD UPDATING POSITION TO NEARBY LOCATION
    public T unload()
    {
        return storage.remove();
    }
}
