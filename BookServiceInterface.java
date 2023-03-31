/**
 * 
 * The BookServiceInterface interface defines the operations that can be
 * performed on a book library.
 * 
 * This interface provides methods to add a book to the library, display all
 * books, display available books,
 * 
 * borrow a book, and return a book.
 */
public interface BookServiceInterface {
    void addBook();

    void showAllBooks();

    void showAllAvailableBooks();

    void borrowBook();

    void returnBook();
}
