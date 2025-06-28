import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class superStore {
    Buyer currentBuyer = null;
    Seller currentSeller = null;
    Map<Integer,User> users;
    Map<Integer,Item> items;
    Map<Integer,Order> orders;
    Map<Integer,List<Order>> buyerorders;

    public superStore(){
        users = new HashMap<>();
        items = new HashMap<>();
        orders = new HashMap<>();
        buyerorders = new HashMap<>();
    }

    public void registerUser(User user){
        if(!users.containsKey(user.getUserID())){
            users.put(user.getUserID(), user);
            System.out.println("User registered successfully with the USERID --> "+user.getUserID());
        }
        else{
            System.out.println("User already exists");
        }
    }

    public User login(int userID, String password){
        if(users.containsKey(userID)){
            User user = users.get(userID);
            if(user.isBuyer() && user.getPassword().equals(password)){
                currentBuyer = (Buyer) user;
                System.out.println("Buyer logged in successfully");
                return currentBuyer;
            }
            else if(user.isSeller() && user.getPassword().equals(password)){
                currentSeller = (Seller) user;
                System.out.println("Seller logged in successfully");
                return currentSeller;
            }
            else{
                System.out.println("Invalid password");
                return null;
            }
        }
        else{
            System.out.println("User does not exist! Please register first....");
            return null;
        }
    }

    public void logout(){
        currentBuyer = null;
        currentSeller = null;
    }

    public void addItem(Item item){
        if(!items.containsKey(item.getItemID())){
            items.put(item.getItemID(), item);
        }
        else{
            System.out.println(" Item already exists! Please update the item instead...");
        }
    }

    public void updateItem(int itemID, String itemName, double itemPrice,int quantity){
        if(items.containsKey(itemID)){
            Item item = items.get(itemID);
            item.setItemName(itemName);
            item.setItemPrice(itemPrice);
            item.setQuantity(quantity);
        }
        else{
            System.out.println("Item does not exist!");
        }
    }

    public void listInventory(){
        if(items.isEmpty()){
            System.out.println("No items in the inventory");
        }
        else{
            System.out.println(" ---------------------------------------------------- ");
            for(Item item : items.values()){
                System.out.println(item.toString());
                System.out.println(" ------------------------------ ");
            }
            System.out.println(" ---------------------------------------------------- ");
        }
    }

    public boolean isLoggedin(){
        return currentBuyer != null || currentSeller != null;
    }

    public void addToCart(int itemID, int quantity){
        if(currentBuyer != null){
            if(items.containsKey(itemID)){
                Item item = items.get(itemID);
                currentBuyer.getCart().add(new Item(itemID, item.getItemName(), item.getItemPrice(), quantity,item.getSellerID()));
            }
            else{
                System.out.println("Item does not exist!");
            }
        }
        else{
            System.out.println("You are not logged in as a buyer!");
        }
    }

    public String placeOrder(){
        StringBuffer insufficient;
        if(currentBuyer==null){
            System.out.println(" You are not logged in as a buyer!");
        }
        else{
            List<Item> cartItems = currentBuyer.getCart();
            if(cartItems.isEmpty()){
                System.out.println(" Your cart is empty!");
            }
            else{
                insufficient = new StringBuffer();
                double total = 0;
                for(Item item : cartItems){
                    Item itemInDB = items.get(item.getItemID());
                    if(itemInDB.getQuantity() >= item.getQuantity()){
                        total += item.getItemPrice() * item.getQuantity();
                        itemInDB.setQuantity(itemInDB.getQuantity()-item.getQuantity());
                    }
                    else{
                        cartItems.remove(item);
                        insufficient.append(item.getItemID()+",");
                    }
                }
                Order order = new Order(currentBuyer.getUserID(), cartItems, total);
                orders.put(order.getOrderNumber(),order);
                List<Order> list = buyerorders.getOrDefault(currentBuyer.getUserID(), new ArrayList<>());
                list.add(order);
                buyerorders.put(currentBuyer.getUserID(), list);
                return insufficient.toString();
            }
        }
        return "";
    }        
    
    public void makePayment(int orderNumber){
        if(currentBuyer!=null){
            if(orders.containsKey(orderNumber)){
                Order order = orders.get(orderNumber);
                order.setStatus(true);
            }
            else{
                System.out.println("Order does not exist!");
            }
        }
    }

    public void listOrders(int userID){
        List<Order> list = buyerorders.getOrDefault(userID, new ArrayList<>());
        if(list.isEmpty())
            System.out.println(" No orders found! ");
        else{
            System.out.println(" ---------------------------------------------------- ");
            for(Order order : list){
                System.out.println(order.toString());
                System.out.println(" ---------------------------");
            }
            System.out.println(" ---------------------------------------------------- ");
        }
    }
}