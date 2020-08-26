package FlyPlane;

import java.util.List;
import java.util.ArrayList;

public abstract class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (observers.contains(flyable))
            return;
        else
            observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        if (observers.contains(flyable))
            return;
        else
            observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        for (Flyable flyable: observers)
            flyable.updateCondition();
    }
}
