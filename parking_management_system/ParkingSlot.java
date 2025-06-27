public class ParkingSlot {
    private String slotId;
    private boolean isOccupied;
    private Vehicle vehicle;  

    public ParkingSlot(String slotId) {
        this.slotId = slotId;
        this.isOccupied = false;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean getOccupied() {
        return isOccupied;
    }

    @Override
    public String toString() {
        return " ParkingSlot  : " + slotId +'\n'+
               " Availability : " + (isOccupied?"No":"Yes")+ '\n' +
               vehicle.toString() + '\n';
    }
}
