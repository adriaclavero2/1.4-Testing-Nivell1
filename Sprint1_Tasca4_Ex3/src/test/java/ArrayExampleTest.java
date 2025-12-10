import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayExampleTest {

    @Test
    void givenArrayOfSize3_whenAccessIndex5_thenThrowsArrayIndexOutOfBoundsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ArrayExample.getElementOutOfBounds());
    }
}