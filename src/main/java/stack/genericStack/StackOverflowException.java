package stack.genericStack;

public class StackOverflowException extends Throwable {
    public StackOverflowException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
