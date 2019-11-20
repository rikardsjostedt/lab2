import java.util.ArrayDeque;
import java.util.Deque;

/**
 * AnimalShelter<Cat> shelter = new AnimalShelter();
 * shelter.putAnimal(badBoyRex);
 */

public class LastInFirstOutStorage extends Storage
{
    private Deque<Transportable> storage = new ArrayDeque<>();

    public LastInFirstOutStorage(int length, int width, int capacity)
    {
        super(length, width, capacity);
    }


    //TODO ADD CHECKS TO MAKE SURE ENTITY ISNT LOADED SOMEWHERE ELSE, AND CHECK TO MAKE SURE ITS NEARBY
    public void load(Transportable entity)
    {
        storage.add(entity);
    }

    //TODO ADD UPDATING POSITION TO NEARBY LOCATION
    public Transportable unload()
    {
        return storage.pop();
    }

}


