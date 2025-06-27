import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        parkingManagementSystem pms = new parkingManagementSystem();
        System.out.println(" ==================Parking Management System================== ");
        while(true){
            System.out.println("1. Add Parking Slot");
            System.out.println("2. Park Vehicle");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. View Parked Vehicles");
            System.out.println("5. View Available Slots");
            System.out.println("6. View Slot Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(" Enter Slot ID : ");
                    String slotId = scanner.nextLine();
                    pms.addParkingSlot(new ParkingSlot(slotId));
                    break;
                case 2:
                    System.out.println(" Enter Vehicle Type : ");
                    String vehicleType = scanner.nextLine();
                    System.out.println(" Enter License Plate Number : ");
                    String licensePlateNumber = scanner.nextLine();
                    System.out.println(" Enter Owner Name : ");
                    String ownerName = scanner.nextLine();
                    if(vehicleType.toLowerCase().equals("car")){
                        System.out.println(" Enter Number of Doors : ");
                        int noOfDoors = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(" Is Electric (true/false) : ");
                        boolean isElectric = scanner.nextBoolean();
                        scanner.nextLine();
                        pms.parkVehicle(new Car(ownerName, licensePlateNumber, noOfDoors , isElectric));
                    }
                    else if(vehicleType.toLowerCase().equals("bike")){
                        System.out.println(" Has Carrier (true/false) : ");
                        boolean hasCarrier = scanner.nextBoolean();
                        scanner.nextLine();
                        pms.parkVehicle(new Bike(ownerName, licensePlateNumber, hasCarrier));
                    }
                    else{
                        System.out.println(" Invalid Vehicle Type ");
                    }
                    break;
                case 3:
                    System.out.println(" Enter SlotID to remove Vehicle : ");
                    String slotIdToRemove = scanner.nextLine();
                    pms.removeVehicle(slotIdToRemove);
                    break;
                case 4:
                    pms.viewParkedVehicles();
                    break;
                case 5:
                    pms.viewAvailableSlots();
                    break;
                case 6:
                    System.out.println(" Enter Slot ID : ");
                    String slotIdDetails = scanner.nextLine();
                    System.out.println(pms.viewSlotById(slotIdDetails)); 
                    break;
                case 7:
                    System.out.println(" Exiting the system....... ");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Invalid choice ");
                    break;
            }
        }
    }
}
