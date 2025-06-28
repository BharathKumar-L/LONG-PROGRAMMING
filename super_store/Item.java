public class Item {
    private int itemID;
    private String itemName;
    private double itemPrice;
    private int quantity;
    private int sellerID;

    public Item (int itemID, String itemName, double itemPrice, int quantity, int sellerID) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.sellerID = sellerID;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item ID    : " + itemID + '\n' + 
               "Item Name  : " + itemName + '\n' +
               "Item Price : " + itemPrice + '\n' +
               "Quantity   : " + quantity + '\n' +
               "Seller ID  : " + sellerID +'\n';
    }

}
