import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testListIsNotNull() {
        assertNotNull(library.getAllBooks());
    }

    @Test
    void testExpectedSizeAfterAdding() {
        library.addBook("Don Quixote");
        library.addBook("1984");
        library.addBook("Hamlet");
        assertEquals(3, library.getAllBooks().size());
    }

    @Test
    void testBookAtCorrectPosition() {
        library.addBook("Don Quixote");
        library.addBook("1984");
        library.addBook("Hamlet");
        List<String> books = library.getAllBooks();
        assertEquals("1984", books.get(0));
    }

    @Test
    void testNoDuplicates() {
        assertTrue(library.addBook("1984"));
        assertFalse(library.addBook("1984")); 
        assertEquals(1, library.getAllBooks().size());
    }

    @Test
    void testRetrieveByPosition() {
        library.addBook("Don Quixote");
        library.addBook("1984");
        assertEquals("1984", library.getBook(0));
    }

    @Test
    void testAddAtPosition() {
        library.addBook("Don Quixote");
        library.addBookAtPosition("Hamlet", 0);
        assertTrue(library.getAllBooks().contains("Hamlet"));
    }

    @Test
    void testRemoveDecreasesSize() {
        library.addBook("Don Quixote");
        library.addBook("1984");
        library.removeBookByTitle("1984");
        assertEquals(1, library.getAllBooks().size());
    }

    @Test
    void testAlphabeticalOrder() {
        library.addBook("Zorro");
        library.addBook("Anna Karenina");
        library.addBook("Hamlet");
        List<String> books = library.getAllBooks();
        assertEquals(List.of("Anna Karenina", "Hamlet", "Zorro"), books);
    }

}
