public class IdCalculation {

    private static final char[] LETTERS = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
            'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
    };

    public static char calculateLetter(int dniNumber) {
        if (dniNumber < 0 || dniNumber > 99999999) {
            throw new IllegalArgumentException("Invalid DNI number");
        }
        int remainder = dniNumber % 23;
        return LETTERS[remainder];
    }
}