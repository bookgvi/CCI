package graph.state.graph.node;

import java.util.Objects;

public abstract class AbstractStateNode implements IStateNode {

    private final String name;
    private final boolean isFinal;

    protected AbstractStateNode(String name, boolean isFinal) {
        this.name = name;
        this.isFinal = isFinal;
    }

    public String getName() {
        return name;
    }

    public boolean isFinal() {
        return isFinal;
    }

    abstract public void behavior(String msg);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractStateNode that = (AbstractStateNode) o;
        return isFinal == that.isFinal && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isFinal);
    }
}
