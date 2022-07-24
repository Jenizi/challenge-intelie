package interfaces;

import classes.EventIterator;
import models.Event;

public interface IEventStore {

    void insert(Event event);
    void removeAll(String type);
    EventIterator query(String type, long startTime, long endTime);
}
