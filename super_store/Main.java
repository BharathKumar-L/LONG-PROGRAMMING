import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static superStore store = new superStore();
    static User curruser ;
    public static void main(String[] args) {
        System.out.println("      ================ SUPER STORE ================ ");
        System.out.println(" ================  WELCOME TO OUR STORE  ================ ");
        while (true) {
            System.out.println("1. REGISTER USER (Buyer/Seller) ");
            System.out.println("2. LOGIN USER (Buyer/Seller) ");
            System.out.println("3. EXIT ");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter your email: ");
                    String email = sc.nextLine();
                    System.out.println("Enter your password: ");
                    String password = sc.nextLine();
                    System.out.println("Are you a (Buyer/Seller) ?");
                    String role = sc.nextLine();
                    if(role.toLowerCase().equals("seller"))
                        store.registerUser(new Seller(name,email,password));
                    else if(role.toLowerCase().equals("buyer"))
                        store.registerUser(new Buyer(name,email,password));
                    else
                        System.out.println("Invalid role");
                    break;
                case 2:
                    System.out.println("Enter your user ID: ");
                    int userID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your password: ");
                    String password1 = sc.nextLine();
                    curruser = store.login(userID, password1);
                    if(curruser != null){
                        System.out.println(" ----------------------------------- ");
                        System.out.println("Welcome " + curruser.getName());
                        System.out.println(" ----------------------------------- ");
                        if(curruser.isBuyer()){
                            buyerMenu();
                        }
                        else if(curruser.isSeller()){
                            sellerMenu();
                        }
                    }
                    break;
                case 3:
                    System.out.println(" Exiting the store... ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice...");
            }
        }
    }

    public static void buyerMenu(){
        System.out.println("               -------BUYER MENU-------");
        while(true){
            System.out.println("1. List the products");
            System.out.println("2. Add items to cart");
            System.out.println("3. Place Order");
            System.out.println("4. Make Payment");
            System.out.println("5. Logout");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    store.listInventory();
                    break;
                case 2:
                    System.out.println("Enter the product ID: ");
                    int productID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    store.addToCart( productID, quantity);
                    break;
                case 3:
                    store.placeOrder();
                    break;
                case 4:
                    store.listOrders(curruser.getUserID());
                    System.out.println("Enter the order ID to make payment: ");
                    int orderID = sc.nextInt();
                    sc.nextLine();
                    store.makePayment(orderID);
                    break;
                case 5:
                    store.logout();
                    return;
            }
        }
    }

    public static void sellerMenu(){
        System.out.println("               -------SELLER MENU-------");
        while(true){
            System.out.println("1. Add Item to the store");
            System.out.println("2. Update the item at the store");
            System.out.println("3. Logout");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter the item ID (number): ");
                    int itemID = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the item name: ");
                    String itemName = sc.nextLine();
                    System.out.println("Enter the price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter the quantity of the item :");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    store.addItem(new Item(itemID, itemName, price, quantity,curruser.getUserID()));
                    break;
                case 2:
                    System.out.println("Enter the item ID (number): ");
                    int itemId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the item name: ");
                    String itemname = sc.nextLine();
                    System.out.println("Enter the price: ");
                    double itemprice = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter the quantity of the item :");
                    int quantity1 = sc.nextInt();
                    sc.nextLine();
                    store.updateItem(itemId, itemname, itemprice, quantity1);
                    break;
                case 3:
                    store.logout();
                    return;
            }
        }
    }
}
