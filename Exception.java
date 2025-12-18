// User-defined exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class Library {

    private int availableCopies;

    public Library(int copies) {
        this.availableCopies = copies;
    }

    public void issueBook() throws BookNotAvailableException {
        if (availableCopies <= 0) {
            throw new BookNotAvailableException("Book is not available");
        }
        availableCopies--;
        System.out.println("Book issued successfully");
    }
}

public class Main {
    public static void main(String[] args) {

        Library lib = new Library(1);

        try {
            lib.issueBook();   // issued
            lib.issueBook();   // exception thrown
        }
        catch (BookNotAvailableException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
