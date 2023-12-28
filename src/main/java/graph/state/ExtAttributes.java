package graph.state;

public enum ExtAttributes {
    TYPE_3_CONST_171("a1"),
    TYPE_2_CONST_520("a2"),
    TYPE_2_CONST_497("a3");

    private final String sysName;
    ExtAttributes(String sysName) {
        this.sysName = sysName;
    }

    public String getSysName() {
        return sysName;
    }
}
