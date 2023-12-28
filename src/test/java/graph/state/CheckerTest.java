package graph.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckerTest {

    private NtfList ntfList;
    private Checker checker;

    @BeforeEach
    public void setUp() {
        ntfList = NtfList.getInstance();
        checker = Checker.getInstance();
    }

    @Test
    public void testCheckKPKWhenPayeeAccountMatchesAndIsType3const171ThenInfoAdded() {
        checker.checkKPK(ntfList, true, false, false, "123", "", "", false);
        List<String> infoList = ntfList.getInfoList();
        assertTrue(infoList.contains("new CBSInfoCodes.AccoIsKpkCorProj(payeeAccountNumber, type3const171)"));
    }

    @Test
    public void testCheckKPKWhenPayeeAccountMatchesAndIsType3const520ThenInfoAdded() {
        checker.checkKPK(ntfList, false, true, false, "123", "", "", false);
        List<String> infoList = ntfList.getInfoList();
        assertTrue(infoList.contains("new CBSInfoCodes.KpkControlModeNotRequired(payeeAccountNumber, type3const520Name)"));
    }

    @Test
    public void testCheckKPKWhenPayeeAccountMatchesAndIsType2const497ThenInfoAdded() {
        checker.checkKPK(ntfList, false, false, true, "123", "", "", false);
        List<String> infoList = ntfList.getInfoList();
        assertTrue(infoList.contains("new CBSInfoCodes.KpkControlModeNotRequired(payeeAccountNumber, type2const497Name)"));
    }

    @Test
    public void testCheckKPKWhenPayeeAccountMatchesAndBothIsType3const520AndIsType2const497ThenInfoAdded() {
        checker.checkKPK(ntfList, false, true, true, "123", "", "", false);
        List<String> infoList = ntfList.getInfoList();
        assertTrue(infoList.contains("new CBSInfoCodes.KpkControlModeNotRequiredForBothExtAttributes(payeeAccountNumber, type3const520Name, type2const497Name)"));
    }

    @Test
    public void testCheckKPKWhenPayeeAccountDoesNotMatchThenNoInfoAdded() {
        checker.checkKPK(ntfList, false, false, false, "999", "", "", false);
        List<String> infoList = ntfList.getInfoList();
        assertTrue(infoList.isEmpty());
    }

    @Test
    public void testCheckKPKWhenPayeeAccountMatchesButPayeeAccountNumber2DoesNotThenInfoAdded() {
        checker.checkKPK(ntfList, false, false, false, "123", "999", "3216", false);
        List<String> infoList = ntfList.getInfoList();
        assertEquals(2, infoList.size());
        assertTrue(infoList.contains("new CBSInfoCodes.AccountIsKpk(payeeAccountNumber3)"));
        assertTrue(infoList.contains("new CBSInfoCodes.AccountExcludeFromKpkControl(payeeAccountNumber)"));
    }

    @Test
    public void testCheckKPKWhenIsInnCheckThenErrorAdded() {
        checker.checkKPK(ntfList, false, false, false, "123", "321", "3216", true);
        List<String> errorList = ntfList.getErrorList();
        assertTrue(errorList.contains("new CBSInfoCodes.CorpCardModeViolation()"));
    }
}