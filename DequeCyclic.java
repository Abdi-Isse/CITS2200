import CITS2200.*;
import CITS2200.Deque;

public class DequeCyclic implements Deque {

    private int first, last;
    private Object[] deque;

    public DequeCyclic (int s) {
        deque = new Object[s];
        first = 0;
        last = -1;
    }

    public boolean isEmpty(){
        return (first == 0);
    }

    public boolean isFull(){
        return (first >= deque.length);
    }

    public void pushLeft(Object c) throws Overflow{
        if(isEmpty()) throw Overflow("deque is empty");
        deque[first] = c;
        first++;
    }

    public void pushRight(Object c) throws Overflow{
        if(isFull()) throw Overflow("deque is full");
        deque[last] = c;
        last++;
    }

    public Object peekLeft() throws Underflow{
        if(isEmpty()) throw Underflow("deque is empty");
        return deque[first];
    }

    public Object peekRight() throws Underflow{
        if(isFull()) throw Underflow("deque is full");
        return deque[last];
    }

    public Object popLeft() throws Underflow{
        if(isEmpty()) throw Underflow("deque is empty");
        first--;
        return deque[first];
    }

    public Object popRight() throws Underflow{
        if(isFull()) throw Underflow("deque is empty");
        last--;
        return deque[last];
    }


    
}