import java.util.LinkedList;
import java.util.List;

public class Buyer extends User {
    private List<Item> cart;
    public Buyer(String name, String email,String password) {
        super(name, email, password,true,false);
        this.cart = new LinkedList<>();
    }

    @Override
    public String getProfileDetails() {
        return " User ID   : " + userID + '\n'+
               " Name      : " + name + '\n' +
               " Email     : " + email +'\n';        
    }

    public List<Item> getCart() {
        return cart;
    }
}
