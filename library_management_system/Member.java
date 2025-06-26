import java.util.ArrayList;
import java.util.List;

public class Member {
    private int member_id;
    private String name;
    private String user_name;
    private String password;
    private int age;
    List<Book> borrowed_books = new ArrayList<>();
    public Member(String name,int age,String user_name,String password) {
        this.name = name;
        this.age = age;
        this.user_name = user_name;
        this.password = password;
        this.member_id++;
    }

    public int getMember_id() {
        return this.member_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBorrowed_books() {
        return this.borrowed_books;
    }

    public void add_borrowedBooks(Book book) {
        borrowed_books.add(book);
    }

    public void remove_borrowedBooks(Book book) {
        borrowed_books.remove(book);
    }

    @Override
    public String toString(){
        return "Member Id   :" + member_id + "\n" +
               "Name        :" + name + "\n" +
               "UserName    :" + user_name + "\n"+
               "Age         :" + age + "\n";
    }
}
