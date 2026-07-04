public class Library {

    private final Book[] books = new Book[100];
    private int bookCount = 0;

    public void addBook(String title, String author) {
        if (bookCount < books.length) {
            Book newBook = new Book(title, author);
            books[bookCount] = newBook;
            bookCount++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the library.");
            return;
        }

        for (int i = 0; i < bookCount; i++) {
            String status ;
            if(books[i].isAvailable()){
                status = "Available";
            }else{
                status = "Borrowed";
            }
            System.out.println("Title: " + books[i].getTitle() + " By " + books[i].getAuthor() + " | Status: " + status);
        }
    }

    public void borrowBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                if (books[i].isAvailable()) {
                    books[i].setAvailable(false);
                    System.out.println("You have successfully borrowed the book : " + title);
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}