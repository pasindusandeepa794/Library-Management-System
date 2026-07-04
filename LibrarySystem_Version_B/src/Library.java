import java.io.*;
import java.util.ArrayList;

public class Library {
    // Paradigm Shift: Upgraded from manual arrays to dynamic ArrayList collection
    private ArrayList<Book> books;
    private final String FILE_PATH = "library_data.txt";

    public Library() {
        books = new ArrayList<>();
        loadFromFile(); // Automatically load database on system initialization
    }

    public void addBook(Book book) {
        books.add(book);
        saveToFile(); // Instantly persist updates
        System.out.println(">>> Success: Book added to catalog smoothly.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println(">>> Notice: The library catalog is currently empty.");
            return;
        }
        System.out.println("\n========= CURRENT LIBRARY CATALOG =========");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Added Option: Advanced Search functionality filtering by Author Name
    public void searchByAuthor(String authorName) {
        boolean found = false;
        System.out.println("\n--------- Search Results for: " + authorName + " ---------");
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName.trim())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println(">>> Alert: No books found matching that author.");
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    saveToFile();
                    System.out.println(">>> Success: You have successfully checked out: " + book.getTitle());
                } else {
                    System.out.println(">>> Error: This book is currently checked out by another borrower.");
                }
                return;
            }
        }
        System.out.println(">>> Error: Book title not found in catalog system.");
    }

    // AI-Injected Feature: Permanent text-file storage architecture
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                writer.println(book.toFileData());
            }
        } catch (IOException e) {
            System.out.println(">>> System Error: Failed to save updates to database file.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Book book = new Book(parts[0], parts[1], parts[2]);
                    book.setAvailable(Boolean.parseBoolean(parts[3]));
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println(">>> System Error: Error reading from stored files.");
        }
    }
}