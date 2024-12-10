import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiniteAutomatonTest {

    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, F",
            "abcTES, S3",
            "TTESTT, F",
            "TEST, F",
            "T, S1",
            "TST, S3",
            "TEEST, S2",
            "TEESTT, S1",
            "TESET, S0"
    })
    void testFiniteAutomaton(String input, FiniteAutomaton.State expectedState) {
        FiniteAutomaton fa = new FiniteAutomaton();
        assertEquals(expectedState, fa.recognize(input));
    }
}
