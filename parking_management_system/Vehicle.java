public abstract class Vehicle {
    protected int vehicleId = 0;
    protected String ownerName;
    protected String licensePlateNumber;
    protected String vehicleType;

    public Vehicle(String ownerName, String licensePlateNumber, String vehicleType) {
        this.ownerName = ownerName;
        this.licensePlateNumber = licensePlateNumber;
        this.vehicleType = vehicleType;
        vehicleId++;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return " Vehicle Type         : " + vehicleType + '\n' +
               " License Plate Number : " + licensePlateNumber + '\n' + 
               " Owner Name           : " + ownerName + '\n' ;
    }

    abstract String getDetails();
}
