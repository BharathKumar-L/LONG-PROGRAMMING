public class Bike extends Vehicle {
    private boolean hasCarrier;
    
    public Bike(String ownerName , String licensePlateNumber, boolean hasCarrier) {
        super(ownerName, licensePlateNumber,"Bike");
        this.hasCarrier = hasCarrier;
    }

    public void setHasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }

    public boolean isHasCarrier() {
        return hasCarrier;
    }

    @Override
    public String getDetails(){
        return " Vehicle Type         : " + vehicleType + '\n' +
               " License Plate Number : " + licensePlateNumber + '\n' + 
               " Owner Name           : " + ownerName + '\n' +
               " Has Carrier          : " + (hasCarrier?"Yes":"No") + '\n';
    }

}
