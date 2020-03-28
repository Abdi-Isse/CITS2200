import CITS2200.*;
import CITS2200.Deque;

public class DequeCyclic implements Deque {

    private int left, right,numberOfItems;
    private Object[] queue;
    private int size;

    public DequeCyclic (int s) {
        left = right = size = 0;
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
        else if(right == 0 && left == 0 && size == 0) queue[0] = c;
        else {
            left = (left + 1) % queue.length;
            queue[left] = c;
        }
        size++;
    }



    public void pushRight(Object c) throws Overflow{
        if(isFull()) throw new Overflow("queue is full");
        else if(left == 0 && right == 0 && size == 0) queue[0] = c;
        else if(right == 0) {
            right = queue.length - 1;
            queue[right] = c;
        }
        else {
            right--;
            queue[right] = c;
        }
        size++;
    }

    public Object peekLeft() throws Underflow{
        if(isEmpty()) throw new Underflow("queue is empty");
        return queue[left];
    }

    public Object peekRight() throws Underflow{
        if(isEmpty()) throw new Underflow("queue is empty");
        return queue[right];
    }

    public Object popLeft() throws Underflow{
        Object a = queue[left];
        if(isEmpty()) throw new Underflow("queue is empty");
        else if(left == 0) left = numberOfItems-1;
        else {
            queue[left] = null;
            left--;
        }
        size--;
        return a;
    }

    public Object popRight() throws Underflow{
        Object a = queue[right];
        if(isEmpty()) throw new Underflow("queue is empty");
        else {
            queue[right] = null;
            if(right == numberOfItems - 1) {
                right = 0;
            }
            else {
                right++;
            }
        }
        size--;
        return a;
    }
    
}