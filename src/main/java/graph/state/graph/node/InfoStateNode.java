package graph.state.graph.node;

import java.util.function.Consumer;

public class InfoStateNode extends AbstractStateNode {

    private final Consumer<String> action;

    public InfoStateNode(String name, boolean isFinal, Consumer<String> action) {
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
        System.out.println("Info behavior " + msg);
        action.accept(msg);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
