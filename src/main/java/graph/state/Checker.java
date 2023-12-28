package graph.state;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static graph.state.ExtAttributes.*;

public class Checker {

    private Checker() {
    }

    public static Checker getInstance() {
        return new Checker();
    }

    public void checkKPK(
            NtfList ntfList,
            boolean isType3const171,
            boolean isType3const520,
            boolean isType2const497,
            String payeeAccountNumber,
            String payeeAccountNumber2,
            String payeeAccountNumber3,
            boolean isInnCheckFailed
    ) {

        Map<String, String> extAttributeMsgMap = new HashMap<>();
        extAttributeMsgMap.put(TYPE_3_CONST_171.getSysName(), "new CBSInfoCodes.AccoIsKpkCorProj(payeeAccountNumber, type3const171)");

        String msg0 = "";
        String msg1 = "new CBSInfoCodes.KpkControlModeNotRequired(payeeAccountNumber, type3const520Name)";
        String msg2 = "new CBSInfoCodes.KpkControlModeNotRequired(payeeAccountNumber, type2const497Name)";
        String msg3 = "new CBSInfoCodes.KpkControlModeNotRequiredForBothExtAttributes(payeeAccountNumber, type3const520Name, type2const497Name)";
        String[] ntfMsgForExtAttributes = new String[]{msg0, msg1, msg2, msg3};
        Integer type3const520 = ConvertUtils.toIntegerSafely(isType3const520, 0);
        Integer type2const497 = ConvertUtils.toIntegerSafely(isType2const497, 0) == 1 ? 2 : 0;
        int sum = type3const520 + type2const497;
        if (sum > 0) {
            ntfList.addInfo(ntfMsgForExtAttributes[sum]);
            return;
        } else if (AccountMaskService.getInstance().match(payeeAccountNumber) && isType3const171) {
            ntfList.addInfo(extAttributeMsgMap.get(TYPE_3_CONST_171.getSysName()));
        } else if (AccountMaskService.getInstance().match(payeeAccountNumber3)) {
            ntfList.addInfo("new CBSInfoCodes.AccountIsKpk(payeeAccountNumber3)");
        } else {
            return;
        }
        if (!AccountMaskService.getInstance().match(payeeAccountNumber2)) {
            ntfList.addInfo("new CBSInfoCodes.AccountExcludeFromKpkControl(payeeAccountNumber)");
            return;
        }
        if (isInnCheckFailed) {
            ntfList.addError("new CBSInfoCodes.CorpCardModeViolation()");
        }
    }
}
