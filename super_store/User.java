public abstract class User {
    private static int userIDCounter = 0;

    protected int userID;
    protected String name;
    protected String password;
    protected String email;
    protected boolean Buyer;
    protected boolean Seller;

    public User(String name, String email, String password,boolean isBuyer, boolean isSeller) {
        this.userID = ++userIDCounter;
        this.name = name;
        this.password = password;
        this.email = email;
        this.Buyer = isBuyer;
        this.Seller = isSeller;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isBuyer() {
        return Buyer;
    }

    public boolean isSeller() {
        return Seller;
    }
    
    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    abstract public String getProfileDetails();
}
