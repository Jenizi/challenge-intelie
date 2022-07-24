package classes;
import interfaces.IEventIterator;
import models.Event;
import java.util.ArrayList;

public class EventIterator implements IEventIterator {
    public EventIterator(ArrayList<Event> eventsList){

        this.eventList = eventsList;
        this.index = -1;
    }

    ArrayList<Event> eventList;
    int index;
    boolean cursorAtTheEnd = false;

    //this function moves the iterator cursor in the list.
    public boolean moveEvent() {
        if (eventList.size() == index + 1){
            cursorAtTheEnd = true;
            return false;
        }
        index += 1;
        return true;
    }

    //this function returns the item from the current cursor position.
    public Event current() {
        if (index == -1) {
            throw new IllegalStateException("You should use moveEvent first.");
        } else if (cursorAtTheEnd) {
            throw new IllegalStateException("The iterator reached the end.");
        } else {
            return eventList.get(index);
        }
    }

    //this function removes the item from the current cursor position.
    public void remove() {
        if (index == -1) {
            throw new IllegalStateException("You should use moveEvent first.");
        } else if (cursorAtTheEnd) {
            throw new IllegalStateException("The iterator reached the end.");
        } else {
            eventList.remove(index);
        }
    }

    @Override
    public void close() throws Exception {

    }
}
