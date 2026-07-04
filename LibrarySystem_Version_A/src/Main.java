import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library myLibrary = new Library();
        boolean running = true;

        System.out.println("=== Welcome to the Library Management System ===");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = sc.nextLine();
                    myLibrary.addBook(title, author);
                    break;

                case 2:
                    System.out.println("\n--- Current Catalog ---");
                    myLibrary.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = sc.nextLine();
                    myLibrary.borrowBook(borrowTitle);
                    break;

                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 4.");
                    break;
            }
        }
        sc.close();
    }
}