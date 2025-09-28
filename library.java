import java.io.*;
import java.util.*;

// Book class
class Book {
    int id;
    String title;
    String author;
    boolean available = true;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

// Student class
class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// IssuedBook class
class IssuedBook {
    int bookId;
    int studentId;

    public IssuedBook(int bookId, int studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
    }
}

// Main Library class
public class Library 
{
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<IssuedBook> issuedBooks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int choice;
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register Student");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    registerStudent();
                    break;
                case 4:
                    issueBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Book
    static void addBook() {
        System.out.print("Enter book id: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    // View Books
    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }
        System.out.println("\nBooks in library:");
        for (Book b : books) {
            System.out.println(b.id + " - " + b.title + " by " + b.author + 
                               " [" + (b.available ? "Available" : "Issued") + "]");
        }
    }

    // Register Student
    static void registerStudent() {
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student registered successfully!");
    }

    // Issue Book
    static void issueBook() {
        System.out.print("Enter book id: ");
        int bookId = sc.nextInt();
        System.out.print("Enter student id: ");
        int studentId = sc.nextInt();

        for (Book b : books) {
            if (b.id == bookId && b.available) {
                b.available = false;
                issuedBooks.add(new IssuedBook(bookId, studentId));
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    // Return Book
    static void returnBook() {
        System.out.print("Enter book id: ");
        int bookId = sc.nextInt();
        for (Book b : books) {
            if (b.id == bookId && !b.available) {
                b.available = true;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid book id or book was not issued!");
    }
}
