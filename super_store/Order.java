import java.util.List;

public class Order {

    private static int orderCounter = 0;

    private int orderNumber;
    private int buyerID;
    private List<Item> items;
    private double totalAmount;
    private boolean status;

    public Order(int buyerID, List<Item> items,double totalAmount) {
        this.orderNumber = ++orderCounter;
        this.buyerID = buyerID;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = false;
    }
    
    public boolean getStatus() {
        return status;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderNumber  : " + orderNumber + '\n' +
               "Total Amount : " + totalAmount + '\n';
    }
}
