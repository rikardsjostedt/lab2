import java.util.LinkedList;
import java.util.Queue;

public class FirstInFirstOutStorage extends Storage
{
    private Queue<Transportable> storage = new LinkedList<>();

    public FirstInFirstOutStorage(int length, int width, int capacity)
    {
        super(length,width,capacity);
    }


    //TODO ADD CHECKS TO MAKE SURE ENTITY ISNT LOADED SOMEWHERE ELSE, AND CHECK TO MAKE SURE ITS NEARBY
    public void load(Transportable entity)
    {
        storage.add(entity);
    }

    //TODO ADD UPDATING POSITION TO NEARBY LOCATION
    public Transportable unload()
    {
        return storage.remove();
    }
}
