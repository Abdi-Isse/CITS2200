import CITS2200.Stack;
import CITS2200.Underflow;
import CITS2200.Overflow;

public class StackBlock implements Sort {

/**
 * Create an empty stack of size @param
 * @param size
 */
    public void stackBlock(int size)
    {

    }

/**
 * Checks to see if the stack is empty, otherwise returns false
 * @return boolean
 */
    public boolean isEmpty()
    {
        return first == null;
    }

/**
 * Checks to see if the stack is full, otherwise returns false
 * @return boolean
 */
    public boolean isFull()
    {
        return true;
    }

/**
 * Push Object o onto the top of the stack
 * @param o
 * @throws Overflow exception if the stack is full
 */
    public void push(Object o) throws Overflow
    {
        first = new Link(0, first);
    }

/**
 * 
 * @return object on the top of the stack
 * @throws Underflow exception if stack is empty
 */
    public Object examine() throws Underflow
    {
        if(!isEmpty()) return first.item;
        else throw new Underflow("examining empty list");
    }

/**
 * 
 * remove the first object on top of the stack
 * @excpetion underflow if the stack is empty
 * @return first object on the top of the stack
 * @throws Underflow
 */
    public Object pop() throws Underflow
    {
        top = first;
        if(!isEmpty()) first = first.successor;
        else throw new Underflow("deleting from empty list");
        return top;
    }
}