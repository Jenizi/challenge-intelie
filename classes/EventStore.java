package classes;
import interfaces.IEventStore;
import models.Event;
import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EventStore implements IEventStore {
    public EventStore(ArrayList<Event> eventsList){

        this.eventList = eventsList;
    }

    ArrayList<Event> eventList;

    //this function adds an item to the event list.
    public void insert(Event event) {
        eventList.add(event);
    }

    //this function deletes all event list items.
    public void removeAll(String type) {
        eventList.removeIf(s -> s.type().equals(type));
    }

    //this function filters items by event attributes.
    public EventIterator query(String type, long startTime, long endTime) {
        ArrayList<Event> filteredList = this.eventList.stream()
                .filter(event -> Objects.equals(event.type(), type) && event.timestamp() >= startTime && event.timestamp() <= endTime)
                .collect(Collectors.toCollection(ArrayList::new));

        return new EventIterator(filteredList);
    }
}
