import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        if (books.contains(title)) {
            throw new IllegalArgumentException("Duplicate book not allowed: " + title);
        }
        books.add(title);
        Collections.sort(books);
    }

    public List<String> getAllBooks() {
        return new ArrayList<>(books);
    }

    public String getBook(int position) {
        if (position < 0 || position >= books.size()) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        return books.get(position);
    }

    public void addBookAtPosition(String title, int position) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        if (books.contains(title)) {
            throw new IllegalArgumentException("Duplicate book not allowed: " + title);
        }
        if (position < 0 || position > books.size()) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        books.add(position, title);
        Collections.sort(books);
    }

    public void removeBookByTitle(String title) {
        if (!books.remove(title)) {
            throw new IllegalArgumentException("Book not found: " + title);
        }
        Collections.sort(books);
    }
}