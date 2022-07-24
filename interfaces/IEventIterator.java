package interfaces;
import models.Event;

public interface IEventIterator extends AutoCloseable {

    boolean moveEvent();
    Event current();
    void remove();
}
