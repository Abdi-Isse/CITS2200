import CITS2200.*;
import CITS2200.Deque;

public class DequeCyclic implements Deque {

    private int first, last, numberOfItems;
    private Object[] queue;
    private int size;

    public DequeCyclic (int s) {
        first = last = size = 0;
        queue = new Object[s];
        numberOfItems = s;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public boolean isFull(){
        return (size == numberOfItems);
    }

    public void pushLeft(Object c) throws Overflow{
        if(isFull()) throw new Overflow("queue is full");
        else if(first == 0 && last == 0 && size == 0) queue[0] = c;
        else {
            last = (last + 1) % queue.length;
            queue[last] = c;
        }
        size++;
    }



    public void pushRight(Object c) throws Overflow{
        if(isFull()) throw new Overflow("queue is full");
        else if(first == 0 && last == 0 && size == 0) queue[0] = c;
        else if(first == 0) {
            first = queue.length - 1;
            queue[first] = c;
        }
        else {
            first--;
            queue[first] = c;
        }
        size++;
    }

    public Object peekLeft() throws Underflow{
        if(isEmpty()) throw new Underflow("queue is empty");
        return queue[first];
    }

    public Object peekRight() throws Underflow{
        if(isFull()) throw new Underflow("queue is empty");
        return queue[last];
    }

    public Object popLeft() throws Underflow{
        Object a = queue[last];
        if(isEmpty()) throw new Underflow("queue is empty");
        else if(last == 0) last = numberOfItems-1;
        else {
            queue[last] = null;
            last--;
        }
        size--;
        return a;
    }

    public Object popRight() throws Underflow{
        Object a = queue[first];
        if(isEmpty()) throw new Underflow("queue is empty");
        else {
            queue[first] = null;
            if(first == numberOfItems - 1) {
                first = 0;
            }
            else {
                first++;
            }
        }
        last--;
        return a;
    }
    
}