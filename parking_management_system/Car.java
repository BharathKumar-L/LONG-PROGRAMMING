public class Car extends Vehicle {
    private int numberOfDoors;
    private boolean isElectric;

    public Car(String ownerName, String licensePlateNumber, int numberOfDoors, boolean isElectric) {
        super(ownerName, licensePlateNumber, "Car");
        this.numberOfDoors = numberOfDoors;
        this.isElectric = isElectric;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    @Override
    public String getDetails(){
        return " Vehicle Type         : " + vehicleType + '\n' +
               " License Plate Number : " + licensePlateNumber + '\n' + 
               " Owner Name           : " + ownerName + '\n' +
               " No. of Doors         : " + numberOfDoors + '\n' +
               " Is Electric          : " + (isElectric?"Yes":"No") + '\n';
    }
    
}
