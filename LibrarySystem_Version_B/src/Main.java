import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in); // [!code ++]
        int choice = -1;

        System.out.println("=================================================");
        System.out.println("   WELCOME TO THE AI-UPGRADED LIBRARY SYSTEM   ");
        System.out.println("=================================================");

        do {
            System.out.println("\nMAIN MENU SELECTIONS:");
            System.out.println("1. Register a New Book Asset");
            System.out.println("2. Display Complete Catalog Collections");
            System.out.println("3. Process Book Check Out / Borrow");
            System.out.println("4. Filter / Search Books by Author Name");
            System.out.println("5. Exit System Shell");
            System.out.print("Please enter your numeric selection: ");

            // Injected Exception Handling to protect execution flows from crashes
            try {
                String inputStr = scanner.nextLine().trim();
                if (inputStr.isEmpty()) {
                    System.out.println(">>> Error: Prompt entry cannot be blank.");
                    continue;
                }
                choice = Integer.parseInt(inputStr);

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine().trim();
                        System.out.print("Enter Book Author: ");
                        String author = scanner.nextLine().trim();
                        System.out.print("Enter Book ISBN: ");
                        String isbn = scanner.nextLine().trim();

                        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                            System.out.println(">>> Form Error: Fields cannot be left empty.");
                        } else {
                            library.addBook(new Book(title, author, isbn));
                        }
                        break;

                    case 2:
                        library.displayBooks();
                        break;

                    case 3:
                        System.out.print("Enter exact book title to borrow: ");
                        String borrowTitle = scanner.nextLine();
                        library.borrowBook(borrowTitle);
                        break;

                    case 4:
                        System.out.print("Enter author name to find: ");
                        String searchAuthor = scanner.nextLine();
                        library.searchByAuthor(searchAuthor);
                        break;

                    case 5:
                        System.out.println(">>> System Terminating. Data preserved safely. Goodbye.");
                        break;

                    default:
                        System.out.println(">>> Warning: Invalid entry. Input an option between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Threat Intercepted: Input must be a valid integer code.");
            }
        } while (choice != 5);
    }
}