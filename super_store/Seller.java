import java.util.LinkedList;
import java.util.List;

public class Seller extends User {
    private List<Item> inventory;
    public Seller(String name, String email, String password) {
        super(name, email, password,false,true);
        this.inventory = new LinkedList<>();
    }

    @Override
    public String getProfileDetails() {
        return " User ID   : " + userID + '\n'+
               " Name      : " + name + '\n' +
               " Email     : " + email +'\n';        
    }

    public List<Item> getInventory() {
        return inventory;
    }

}
