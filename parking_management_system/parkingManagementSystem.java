import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class parkingManagementSystem {
    Queue<ParkingSlot> parkingLot = new LinkedList<>();
    Map<String , ParkingSlot> parkedSlots = new HashMap<>();
    Map<String , Vehicle> parkedVehicles = new HashMap<>();

    public void addParkingSlot(ParkingSlot slot) {
        if(!parkedSlots.containsKey(slot.getSlotId()) && !containsslot(parkingLot,slot.getSlotId())){
            parkingLot.offer(slot);
            System.out.println(" Parking slot added successfully ");
        }
        else{
            System.out.println(" Parking slot already exists ");
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        if(parkingLot.isEmpty())
            System.out.println(" There are no available parking slots ");
        else{
            ParkingSlot slot = parkingLot.poll();
            parkedSlots.put(slot.getSlotId(),slot);
            parkedVehicles.put(slot.getSlotId(), vehicle);
            System.out.println(" Vehicle parked successfully in slot " + slot.getSlotId());
        }
    }

    public void removeVehicle(String slotId) {
        if(parkedVehicles.containsKey(slotId)) {
            Vehicle vehicle = parkedVehicles.remove(slotId);
            ParkingSlot slot = parkedSlots.remove(slotId);
            parkingLot.offer(slot);
            System.out.println(vehicle.toString());
            System.out.println(" Vehicle removed successfully from slot " + slotId);
        }
        else if (parkingLot.contains(slotId)){
            System.out.println(" There is no vehicle at the slotid -> " + slotId);
        }
        else{
            System.out.println(" There is no slot with the slotid -> " + slotId);
        }
    }

    public void viewParkedVehicles(){
        if( parkedVehicles.isEmpty() ){
            System.out.println(" No vehicles are parked ");
        }
        else{
            System.out.println(" ------------Parked Vehicles---------------- ");
            for(String slotId : parkedVehicles.keySet()){
                System.out.println(" Slot ID : " + slotId);
                System.out.println(parkedVehicles.get(slotId).toString());
            }
            System.out.println(" ------------------------------------------- ");
        }
    }

    public void viewAvailableSlots(){
        if(parkingLot.isEmpty()){
            System.out.println(" All parking slots are occupied ");
        }
        else{
            System.out.println(" ------------Available Slots---------------- ");
            for(ParkingSlot slot : parkingLot)
                System.out.println("=> Slot ID : " + slot.getSlotId());
            System.out.println(" ------------------------------------------- ");
        }
    }

    public String viewSlotById(String slotId){
        if(parkedVehicles.containsKey(slotId)){
            return " -------------------------------------------------- " + '\n' +
                   " Slot ID   : " + slotId + '\n' +
                   " Occupied  : YES" + '\n' + 
                   " Vehicle   : \n" + parkedVehicles.get(slotId).toString() + '\n' +
                   " -------------------------------------------------- " + '\n';
        }
        else if(containsslot(parkingLot,slotId)){
            return " -------------------------------------------------- " + '\n' +
                   " Slot ID   : " + slotId + '\n' +
                   " Occupied  : YES" + '\n' + 
                   " Vehicle   : None ( Slot is currently empty )\n" +
                   " -------------------------------------------------- " + '\n';
        }
        else{
            return " There is no slot with slotID " + slotId ;
        }
    }

    private boolean containsslot(Queue<ParkingSlot> parkingLot2,String slotId) {
        for(ParkingSlot slot : parkingLot2){
            if(slot.getSlotId().equals(slotId)){
                return true;
            }
        }
        return false;
    }

}
