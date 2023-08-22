package stack.genericStack;

public interface IStack<T> {
    void push(T val) throws StackOverflowException;
    T pop();
    int size();
}
