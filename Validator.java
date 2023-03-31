
/**
 This code defines a class called Validator which provides methods for input validation.

The class has three static Pattern objects for validating book ID, author/title, and publish year.

The Validator class has a Scanner object to read input from the user.

The validateId() method prompts the user to enter a book ID and checks if it matches the ID_PATTERN using a while loop.

The validateAuthorTitle() method takes an input parameter to specify whether it is validating the author or the title. It then prompts the user to enter the author or title and checks if it matches the AuthorTitle_Pattern using a while loop.

The validatePublishYear() method prompts the user to enter the publish year of the book and checks if it matches the PublishYear_Pattern using a while loop
  
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern AuthorTitle_Pattern = Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern PublishYear_Pattern = Pattern.compile("^\\d{4}$");
    Scanner sc = new Scanner(System.in);

    public String validateId() {
        String bookid;
        while (true) {
            System.out.println("Enter Book ID ");
            bookid = sc.nextLine();
            if (!ID_PATTERN.matcher(bookid).matches()) {
                System.out.println(RED + "SORRY ! PLEASE ENTER VALID BOOK ID " + RESET);
            } else {
                break;
            }
        }
        return bookid;
    }

    public String validateAuthorTitle(String input) {
        String result;
        while (true) {
            if (input == "Title") {
                System.out.println("Enter Title");
            } else {
                System.out.println("Enter Author");
            }
            result = sc.nextLine();
            if (!AuthorTitle_Pattern.matcher(result).matches()) {
                System.out.println(RED + "Please Enter Valid " + input + RESET);
            } else {
                break;
            }

        }
        return result;
    }

    public String validatePublishYear() {
        String year;
        while (true) {
            System.out.println("Enter Publish Year of Book ");
            year = sc.nextLine();
            if (!PublishYear_Pattern.matcher(year).matches()) {
                System.out.println(RED + "Enter valid Publish Year" + RESET);
            } else {
                break;
            }
        }
        return year;
    }

}
