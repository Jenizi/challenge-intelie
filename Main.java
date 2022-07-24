import classes.EventIterator;
import classes.EventStore;
import models.Event;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

     static ArrayList<Event> eventsList = new ArrayList();
     static EventStore eventStore = new EventStore(eventsList);
    static EventIterator eventIterator = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while (num != 7) {
            //this menu is intended to test the functions proposed in this challenge.
            System.out.println("=============  Menu  =============");
            System.out.println("1-Create event.\n");
            System.out.println("2-Filter event.\n");
            System.out.println("3-Choose current event.\n");
            System.out.println("4-Move to the next event.\n");
            System.out.println("5-Remove the current event.\n");
            System.out.println("6-Remove all events.\n");
            System.out.println("7-Exit.");
            System.out.println("==================================");

            num = sc.nextInt();
            switch (num) {
                case 1: {
                    System.out.println("Write the type: ");
                    String type = sc.next();
                    System.out.println("Write the timestamp: ");
                    long timestamp = sc.nextLong();
                    Event event = new Event(type, timestamp);
                    createEvent(event);
                    break;
                }
                case 2: {
                    System.out.println("Write the type: ");
                    String type = sc.next();
                    System.out.println("Write the starttime: ");
                    long startTime = sc.nextLong();
                    System.out.println("Write the endtime: ");
                    long endTime = sc.nextLong();
                    filterEvent(type, startTime, endTime);
                    break;
                }
                case 3: {
                    chooseEvent();
                    break;
                }
                case 4: {
                    moveEvent();
                    break;
                }
                case 5: {
                    removeCurrentEvent();
                    break;
                }
                case 6: {
                    System.out.println("Write the type:");
                    String type = sc.nextLine();
                    removeAllEvents(type);
                    break;
                }
            }
        }
    }
    //the description of each function below is in the EventStore and EventIterator classes.
    public static void createEvent(Event event) {
        eventStore.insert(event);
    }

    public static void filterEvent(String type, long startTime, long endTime) {
        eventIterator = eventStore.query(type, startTime, endTime);
    }

    public static void chooseEvent() {
        Event event = eventIterator.current();
        System.out.println("Type:");
        System.out.println(event.type());
        System.out.println("Timestamp:");
        System.out.println(event.timestamp());
    }
    public static void moveEvent() {
        eventIterator.moveEvent();
    }
    public static void removeCurrentEvent() {
        eventIterator.remove();
    }
    public static void removeAllEvents(String type) {
        eventStore.removeAll(type);
    }
}
