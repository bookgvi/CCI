package graph.state.graph.node;

import java.util.function.Consumer;

public class ErrorStateNode extends AbstractStateNode {
    private final Consumer<String> action;
    public ErrorStateNode(String name, boolean isFinal, Consumer<String> action) {
        super(name, isFinal);
        this.action = action;
    }

    public String getName() {
        return super.getName();
    }

    public boolean isFinal() {
        return super.isFinal();
    }

    @Override
    public void behavior(String msg) {
        System.out.println("Error behavior " + msg);
        action.accept(msg);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
