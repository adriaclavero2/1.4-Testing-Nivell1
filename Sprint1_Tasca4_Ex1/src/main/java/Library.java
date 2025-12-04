import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public boolean addBook(String title) {
        if (title == null || books.contains(title)) {
            return false;
        }
        books.add(title);
        Collections.sort(books);
        return true;
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

    public boolean addBookAtPosition(String title, int position) {
        if (title == null || books.contains(title)) {
            return false;
        }
        if (position < 0 || position > books.size()) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        books.add(position, title);
        Collections.sort(books);
        return true;
    }

    public boolean removeBookByTitle(String title) {
        boolean removed = books.remove(title);
        Collections.sort(books);
        return removed;
    }
}