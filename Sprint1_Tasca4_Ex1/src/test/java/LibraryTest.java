import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();

        library.addBook("Don Quixote");
        library.addBook("1984");
        library.addBook("Hamlet");
    }

    @Test
    void givenLibrary_whenGetAllBooks_thenListIsNotNull() {
        assertNotNull(library.getAllBooks());
    }

    @Test
    void givenLibraryWith3Books_whenCheckSize_thenSizeIs3() {
        assertEquals(3, library.getAllBooks().size());
    }

    @Test
    void givenLibraryWithBooks_whenGetAllBooks_thenBooksAreAlphabeticallyOrdered() {
        assertEquals(List.of("1984", "Don Quixote", "Hamlet"), library.getAllBooks());
    }

    @Test
    void givenLibraryWithBooks_whenGetBookByPosition_thenReturnsCorrectBook() {
        assertEquals("1984", library.getBook(0));
    }

    @Test
    void givenDuplicateBook_whenAddBook_thenThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook("1984"));
    }

    @Test
    void givenLibrary_whenAddBookAtPosition_thenBookIsAdded() {
        library.addBookAtPosition("Anna Karenina", 0);
        assertTrue(library.getAllBooks().contains("Anna Karenina"));
    }

    @Test
    void givenLibraryWithBooks_whenRemoveBook_thenSizeDecreases() {
        library.removeBookByTitle("1984");
        assertEquals(2, library.getAllBooks().size());
    }
}