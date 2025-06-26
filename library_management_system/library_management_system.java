import java.util.HashMap;
import java.util.Map;

public class library_management_system {
    Map<Integer , Book> books;
    Map<Integer , Member> members;

    public library_management_system() {
        books = new HashMap<>();
        members = new HashMap<>();
    }

    public boolean isMemberExists(int member_id){
        return members.containsKey(member_id);
    }

    public boolean validateMember(int member_id,String user_name, String password) {
        Member member = members.get(member_id);
        if (member.getUser_name().equals(user_name) && member.getPassword().equals(password)) {
            return true;
        }
        else{
            System.out.println("Invalid user name or password");
            return false;
        }
    }

    public void add_book(Book book) {
        books.put(book.getBook_id(), book);
    }

    public void register_member(Member member) {
        members.put(member.getMember_id(), member);
    }

    public void borrow_book(int member_id, int book_id) {
        if (books.containsKey(book_id)) {
            Book book = books.get(book_id);
            if(!book.isIs_borrowed()){
                book.setIs_borrowed(true);
                Member member = members.get(member_id);
                member.add_borrowedBooks(book);
                System.out.println("Book borrowed successfully");
            }
            else{
                System.out.println("Book is already borrowed");
            }
        }
        else{
            System.out.println("Book not found");
        }
    }

    public void return_book(int member_id,int book_id) {
        if(books.containsKey(book_id)){
            Book book = books.get(book_id);
            if(book.isIs_borrowed()){
                book.setIs_borrowed(false);
                Member member = members.get(member_id);
                member.remove_borrowedBooks(book);
                System.out.println("Book returned successfully");
            }
            else{
                System.out.println("Book is not borrowed");
            }
        }    
        else{
            System.out.println("Book not found");
        }
    }

    public void viewAllBooks(){
        System.out.println();
        System.out.println("All Books:");
        System.out.println( "--------------------------------------------------------------------------");
        for(Book book : books.values())
            System.out.println(book.toString());
        System.out.println( "--------------------------------------------------------------------------");
    }

    public void viewBooksByAvailability(){
        System.out.println();
        System.out.println( "--------------------------------------------------------------------------");
        System.out.println("Books Available : ");
        System.out.println( "------------------------------------------------");
        for(Book book : books.values())
            if(!book.isIs_borrowed())
                System.out.println(book.toString());
        System.out.println("Books Not Available : ");
        System.out.println( "------------------------------------------------");
        for(Book book : books.values())
            if(book.isIs_borrowed())
                System.out.println(book.toString());
        System.out.println( "--------------------------------------------------------------------------");
    }

    public void viewBooksByGenre(String genre){
        boolean found = false;
        
        for(Book book : books.values()){
            if(book.getGenre().toLowerCase().equals(genre.toLowerCase())){
                if(!found){
                    System.out.println();
                    System.out.println( "--------------------------------------------------------------------------");
                    System.out.println("Books by Genre : "+genre);
                    System.out.println( "------------------------------------------------");
                }
                System.out.println(book.toString());
                found = true;
            }
        }
        if(found)
            System.out.println( "--------------------------------------------------------------------------");
        else
            System.out.println("No books found in this genre : "+genre);
    }

    public void viewAllMembers(){
        System.out.println();
        if(!members.isEmpty()){
            System.out.println("Registered Members : ");
            System.out.println( "--------------------------------------------------------------------------");
            for(Member member : members.values())
                System.out.println(member.toString());
            System.out.println( "--------------------------------------------------------------------------");
        }
        else{
            System.out.println("No registered members");
        }
    }

    public void viewBorrowedBooks(int member_id){
        System.out.println();
        if(members.get(member_id).getBorrowed_books() != null){    
            System.out.println("Books Borrowed by Member : "+member_id);
            System.out.println( "--------------------------------------------------------------------------");
            for(Book book : members.get(member_id).getBorrowed_books())
                System.out.println(book.toString());
            System.out.println( "--------------------------------------------------------------------------");
        }
        else{
            System.out.println("No books borrowed by member : "+member_id);
        }
    }

}
