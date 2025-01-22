public class BookController {

    private BookRepository bookRepository;
    private BookService bookService;

    public BookController() {
        bookRepository = new BookRepository();
        bookService = new BookService(bookRepository);
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Add Book");
            System.out.println("2. Get info about Book");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Print all books");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Add Book");
                    addBook(scanner);
                    break;
                case 2:
                    System.out.println("Get info about Book");
                    break;
                case 3:
                    System.out.println("Update Book");
                    break;
                case 4:
                    System.out.println("Delete Book");
                    break;
                case 5:
                    System.out.println("Print all books");
                    printAllBooks();
                    break;
                case 6:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook(Scanner scanner) {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();

        System.out.println("Enter book author: ");
        String author = scanner.nextLine();

        System.out.println("Enter book year: ");
        int year = scanner.nextInt();

        System.out.println("Enter book price: ");
        double price = scanner.nextDouble();

        // Add book from data
        Book book = new Book(title, author, year, price);
        bookService.addBook(book);
    }

    private void printAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();

        if (!allBooks.isEmpty()) {
            for (Book book : allBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found.");
        }
    }


}
