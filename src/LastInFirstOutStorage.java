import java.util.ArrayDeque;
import java.util.Deque;

/**
 * AnimalShelter<Cat> shelter = new AnimalShelter();
 * shelter.putAnimal(badBoyRex);
 */

public class LastInFirstOutStorage<T extends Transportable> extends Storage
{
    private Deque<T> storage = new ArrayDeque<>();

    public LastInFirstOutStorage(int length, int width, int capacity)
    {
        super(length, width, capacity);
    }


    //TODO ADD CHECKS TO MAKE SURE ENTITY ISNT LOADED SOMEWHERE ELSE, AND CHECK TO MAKE SURE ITS NEARBY
    public void load(T entity)
    {
        storage.add(entity);
    }

    //TODO ADD UPDATING POSITION TO NEARBY LOCATION
    public T unload()
    {
        return storage.pop();
    }

}


