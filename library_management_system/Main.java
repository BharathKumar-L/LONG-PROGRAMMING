import java.util.Scanner;

class Main{
    public static boolean isValidPassword(String password){
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }
        
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }
        
        if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must contain at least one lowercase letter.");
            return false;
        }
        
        if (!password.matches(".*\\d.*")) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        library_management_system lms = new library_management_system();
        while(true){
            System.out.println("1. Add Book");
            System.out.println("2. Register a new Member");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. View all Books");
            System.out.println("6. View all Registered Members");
            System.out.println("7. View all Borrowed Books by a member");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Book Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    System.out.println("Enter Book Author(if there is more than one author enter it as comma separated): ");
                    String author = sc.nextLine();
                    System.out.println("Enter Book Genre: ");
                    String genre = sc.nextLine();
                    lms.add_book(new Book(title, author, genre));
                    break;
                case 2:
                    System.out.println("Enter Member Name : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter User Name : ");
                    String username = sc.nextLine();
                    System.out.println("Enter Password : ");
                    String password = sc.nextLine();
                    while(!isValidPassword(password)){
                        System.out.println("Enter New Password : ");
                        password = sc.nextLine();
                    }
                    System.out.println("Enter Age : ");
                    int age = sc.nextInt();
                    lms.register_member(new Member(name, age, username, password));
                    break;
                case 3:
                    System.out.println("Enter Member ID : ");
                    int member_id = sc.nextInt();
                    sc.nextLine();
                    if(!lms.isMemberExists(member_id)){
                        System.out.println("Member does not exist");
                        break;
                    }
                    System.out.println("Enter Username: ");
                    String member_username = sc.nextLine();
                    System.out.println("Enter Password");
                    String member_password = sc.nextLine();
                    if(!lms.validateMember(member_id, member_username, member_password)){
                        System.out.println("Invalid username or password");
                        break;
                    }
                    System.out.println("Enter Book ID : ");
                    int book_id = sc.nextInt();
                    lms.borrow_book(member_id, book_id);
                    break;
                case 4:
                    System.out.println("Enter Member ID : ");
                    int memberid = sc.nextInt();
                    sc.nextLine();
                    if(!lms.isMemberExists(memberid)){
                        System.out.println("Member does not exist");
                        break;
                    }
                    System.out.println("Enter Username: ");
                    String memberusername = sc.nextLine();
                    System.out.println("Enter Password");
                    String memberpassword = sc.nextLine();
                    if(!lms.validateMember(memberid, memberusername, memberpassword)){
                        System.out.println("Invalid username or password");
                        break;
                    }
                    System.out.println("Enter Book ID : ");
                    int bookid = sc.nextInt();
                    lms.return_book(memberid, bookid);
                    break;
                case 5:
                    if (lms.books.isEmpty()) {
                        System.out.println("There are no books in the library.");
                        break;
                    }
                    System.out.println("\t1. View All Books");
                    System.out.println("\t2. View by Filter");
                    int ch = sc.nextInt();
                    sc.nextLine();
                    switch(ch){
                        case 1:
                            lms.viewAllBooks();
                            break;
                        case 2:
                            System.out.println("\t\t1. By Availability");
                            System.out.println("\t\t2. By Genre");
                            int filter_ch = sc.nextInt();
                            sc.nextLine();
                            switch(filter_ch){
                                case 1:
                                    lms.viewBooksByAvailability();
                                    break;
                                case 2:
                                    System.out.println("\t\tEnter Genre : ");
                                    String viewgenre = sc.nextLine();
                                    lms.viewBooksByGenre(viewgenre);
                                    break;
                            }
                            break;
                    }
                    break;
                case 6:
                    lms.viewAllMembers();
                    break;
                case 7:
                    System.out.println("Enter Member ID : ");
                    int member_id1 = sc.nextInt();
                    sc.nextLine();
                    lms.viewBorrowedBooks(member_id1);
                    break;
                case 8:
                    System.out.println("Exiting the system.....");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }    
}