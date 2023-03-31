
/**

The BookServiceImpl class is the implementation of the BookServiceInterface which provides the implementation
of the methods to add, show, borrow, and return books in the library.

This class includes methods to interact with the user to take input and validate them using the Validator class.
The class also contains a list of books to store the book objects.

This class includes the following methods:
addBook() - takes input for book details and adds it to the list of books
showAllBooks() - displays all the books present in the library
showAllAvailableBooks() - displays all the books that are available to borrow
borrowBook() - borrows a book if it is available in the library
returnBook() - returns a borrowed book to the library

This class depends on the Validator class to validate user inputs.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookServiceInterface {
    Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();
    List<Book> books = new ArrayList<>();

    @Override
    public void addBook() {

        String bookid = validator.validateId();
        String Author = validator.validateAuthorTitle("Author");
        String Title = validator.validateAuthorTitle("Title");
        String year = validator.validatePublishYear();
        Book book = new Book(bookid, Author, Title, year, "Available");
        books.add(book);
        System.out.println("Book Added Successfully !!!");

    }

    @Override
    public void showAllBooks() {
        boolean flag = false;
        System.out.println(
                "\n----------------------------------------------------------------------------------------------");
        System.out.format("\u001B[36m%s%15s%15s%15s%15s\u001B[0m", "ID", "TITLE", "AUTHOR", "PUBLISH YEAR", "STATUS");
        System.out.println(
                "\n----------------------------------------------------------------------------------------------");

        for (Book book : books) {
            System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(),
                    book.getPublishYear(), book.getStatus());
            System.out.println();
            flag = true;
        }
        System.out.println(
                "\n----------------------------------------------------------------------------------------------");
        if (flag == false)
            System.out.println("\u001B[31mThere are no Books in Library\u001B[0m");
    }

    public void showAllAvailableBooks() {
        boolean flag = false;
        System.out.println(
                "\n----------------------------------------------------------------------------------------------");
        System.out.format("\u001B[36m%s%15s%15s%15s%15s\u001B[0m", "ID", "TITLE", "AUTHOR", "PUBLISH YEAR", "STATUS");
        System.out.println(
                "\n----------------------------------------------------------------------------------------------");

        if (books.size() > 0) {
            for (Book book : books) {
                if (book.getStatus().equals("Available")) {
                    System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getTitle(), book.getAuthor(),
                            book.getPublishYear(), book.getStatus());
                    System.out.println();
                    flag = true;
                }
            }
        } else {
            System.out.println("\u001B[31mNo Books Available in the library\u001B[0m");
        }
        System.out.println(
                "\n----------------------------------------------------------------------------------------------");
        if (flag == false)
            System.out.println("\u001B[31mThere are no books with status Available\u001B[0m");

    }

    public void borrowBook() {
        String bookid = validator.validateId();
        boolean flag = false;
        for (Book book : books) {
            if (book.getId().equals(bookid) && book.getStatus().equals("Available")) {
                flag = true;
                System.out.println("Book Borrowed Successfully !!!");
                book.setStatus("Not Available");
                System.out.println("Borrowed Book Details: " + book);
            }
        }
        if (flag == false)
            System.out.println("[31mThis book is not available to borrow");

    }

    public void returnBook() {
        boolean flag = false;
        String bookid = validator.validateId();
        for (Book book : books) {
            if (book.getId().equals(bookid) && book.getStatus().equals("Not Available")) {
                flag = true;
                System.out.println("Book Returned Successfully !!!");
                book.setStatus("Available");
                System.out.println("Returned Book Details: " + book);
            }

        }
        if (flag == false)
            System.out.println("We can not return this book");

    }

}
