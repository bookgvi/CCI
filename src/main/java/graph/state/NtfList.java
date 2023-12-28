package graph.state;

import java.util.List;
import java.util.ArrayList;
public class NtfList {

    private final static NtfList INSTANCE = new NtfList();

    private final List<String> infoList = new ArrayList<>();
    private final List<String> errorList = new ArrayList<>();

    private NtfList() {
    }

    public static NtfList getInstance() {
        return new NtfList();
    }

    public void addInfo(String ntf) {
        infoList.add(ntf);
    }

    public List<String> getInfoList() {
        return new ArrayList<>(infoList);
    }

    public void addError(String ntf) {
        errorList.add(ntf);
    }

    public List<String> getErrorList() {
        return new ArrayList<>(errorList);
    }
}
