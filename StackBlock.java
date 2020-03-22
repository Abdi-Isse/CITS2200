import CITS2200.Stack;
import CITS2200.Underflow;
import CITS2200.Overflow;

public class StackBlock implements Stack {

    private int first;
    private Object[] stack;

/**
 * Create an empty stack of size @param
 * @param size
 */
    public StackBlock(int size)
    {
        if(size < 1) throw new IllegalArgumentException("Size can not be less than 1");
        stack = new Object[size];
        first = 0;
    }

/**
 * Checks to see if the stack is empty, otherwise returns false
 * @return boolean
 */
    public boolean isEmpty()
    {
        return (first == 0);
    }

/**
 * Checks to see if the stack is full, otherwise returns false
 * @return boolean
 */
    public boolean isFull()
    {
        return (first >= stack.length);
    }

/**
 * Push Object o onto the top of the stack
 * @param o
 * @throws Overflow exception if the stack is full
 */
    public void push(Object o) throws Overflow
    {
        if(isFull()) throw new Overflow("Stack is full");
        stack[first] = o;
        first++;
    }

/**
 * 
 * @return object on the top of the stack
 * @throws Underflow exception if stack is empty
 */
    public Object examine() throws Underflow
    {
        if(!isEmpty()) return stack[first - 1];
        else throw new Underflow("Examining empty list");
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
        if(!isEmpty()) {
            first--;
            return stack[first];
        }
        else throw new Underflow("Stack is empty");
    }
}