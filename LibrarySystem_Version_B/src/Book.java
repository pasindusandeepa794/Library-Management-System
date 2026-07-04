public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Upgraded Constructor initializing all properties safely
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // Default to available
    }

    // Getters and Setters (Encapsulation preserved)
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }

    // AI-generated utility method to format file data strings easily
    public String toFileData() {
        return title + "," + author + "," + isbn + "," + isAvailable;
    }

    // Overridden toString for enhanced console presentation
    @Override
    public String toString() {
        return String.format("Title: %-20s | Author: %-15s | ISBN: %-10s | Status: %s",
                title, author, isbn, (isAvailable ? "Available" : "Borrowed"));
    }
}