import CITS2200.*;

/**
 * Implementation of a LinkedList that completes the ADT, writing constant time methods for all operations 
 * given in the specification of the list ADT except the previous method.
 * @author Abdihafith Isse
 */
public class ListLinked implements List {

    private Link before;
    private Link after;

    /**
     * Initialises LinkedList
     */
    public ListLinked() {
        after = new Link(null, null);
        before = new Link(null, after);

    }

    /**
     * Puts a window over after-last position
     * @param WindowLinked a 
     * @return void
     */
    public void afterLast(WindowLinked a) {
        a.link = after;
    }

    /**
     * Puts a window over before-first position
     * @param WindowLinked a
     * @return void
     */
    public void beforeFirst(WindowLinked a) {
        a.link = before;
    }

    /** 
     * Deletes and returns the obkect under a window, and place window over the next item
     * @param WindowLinked a
     * @throws OutOfBounds if it can not delete
     * @returns Object item 
     */
    public Object delete(WindowLinked a) throws OutOfBounds {
        if(isBeforeFirst(a) || isAfterLast(a)) {
            throw new OutOfBounds("Can not delete");
        }
        Object item = a.link.item;
        Link next = a.link.successor;
        a.link.item = next.item;
        a.link.successor = next.successor;
        if(after == next){
            after = a.link; 
        }
        return item;
    }

    /**
     * Examines the object under a window
     * @param WindowLinked a
     * @throws OutOfBounds if link can not be retrieved
     * @returns Object item
     */
    public Object examine(WindowLinked a) throws OutOfBounds {
        if(isBeforeFirst(a) || isAfterLast(a)) {
            throw new OutOfBounds("can not retrieve");
        }
        return a.link.item;
    }

    /**
     * Insert an item after a window
     * @param Object e, WindowLinked a
     * @throws OutOfBounds if inserting after the end of the linked list
     * @return void
     */
    public void insertAfter(Object e, WindowLinked a) throws OutOfBounds {
        if(!isAfterLast(a)){
            a.link.successor = new Link(e, a.link.successor);
        }
        else throw new OutOfBounds("Inserting after end of list");

    }

    /**
     * Insert an item before a window
     * @param Object e, WindowLinked a
     * @throws OutOfBounds if inserting after the start of the linked list
     * @return void
     */
    public void insertBefore(Object e, WindowLinked a) throws OutOfBounds {
        if(!isBeforeFirst(a)) {
            a.link.successor = new Link(a.link.item, a.link.successor);
            if(isAfterLast(a)) after = a.link.successor;
            a.link.item = e;
            a.link = a.link.successor;
        }
        else throw new OutOfBounds("Inserting before start of list");

    }

    /**
     * Checks if the window is over the after-last position
     * @param WindowLinked a
     * @return boolean
     */
    public boolean isAfterLast(WindowLinked a) {
        return a.link == after;
    }

    /**
     * Checks if the window is over the before-first position
     * @param WindowLinked a
     * @return boolean
     */
    public boolean isBeforeFirst(WindowLinked a) {
        return a.link == before;
    }

    /**
     * Checks if the list is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return before.successor == after;
    }
    
    /**
     * Move a window to the next position
     * @param WindowLinked a
     * @throws OutOfBounds if callling next after the end of the list
     * @return void
     */
    public void next(WindowLinked a) throws OutOfBounds {
        if(!isAfterLast(a)) a.link = a.link.successor;
        else throw new OutOfBounds("Calling next after the end of the list.");
    }

    /**
     * Move a window to the previous position
     * @param WindowLinked a
     * @throws OutOfBounds if callling previous before the start of the list
     * @return void
     */
    public void previous(WindowLinked a) throws OutOfBounds {
        if(!isBeforeFirst(a)) {
            Link current = before;
            while (current.successor != a.link) {
                current = current.successor;
            }
            a.link = current;
        }
        else throw new OutOfBounds ("Calling previous before start of list.");
    }

    /**
     * Replace the object under a window
     * @param Object e, WindowLinked a
     * @throws OutOfBounds if isBeforeFirst(a) or isAfterLast(a)
     * @return Object item
     */
    public Object replace(Object e, WindowLinked a) throws OutOfBounds {
        if(isBeforeFirst(a) || isAfterLast(a)) {
            throw new OutOfBounds("Can not replace");
        }
        Object item = a.link.item;
        a.link.item = e;
        return item;
    }
}