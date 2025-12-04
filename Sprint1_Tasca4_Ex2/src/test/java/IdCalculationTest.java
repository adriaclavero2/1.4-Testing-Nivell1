import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class IdCalculationTest {

    @ParameterizedTest
    @CsvSource({
            "12345678,Z",
            "87654321,X",
            "11111111,H",
            "22222222,J",
            "33333333,P",
            "44444444,A",
            "55555555,K",
            "66666666,Q",
            "77777777,B",
            "88888888,Y"
    })
    void testCorrectLetterCalculation(int dniNumber, char expectedLetter) {
        assertEquals(expectedLetter, IdCalculation.calculateLetter(dniNumber));
    }

    @ParameterizedTest
    @CsvSource({
            "-1", "100000000"
    })
    void testInvalidNumbers(int dniNumber) {
        assertThrows(IllegalArgumentException.class, () -> IdCalculation.calculateLetter(dniNumber));
    }
}