import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train t1 = new Train(101, "Vaigai Express", "Madurai", "Chennai",10);
        Train t2 = new Train(102, "Nellai Express", "Nellai", "Chennai",20);
        ReservationSystem rs = new ReservationSystem();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        rs.addTrain(t1);
        rs.addTrain(t2);
        while (true) {
            System.out.println("1. Show Available Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Show All the tickets from a train");
            System.out.println("5. Add trains to the system");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    rs.showAvailableTrains();
                    break;
                case 2:
                    System.out.println("Enter Train Number: ");
                    int trainNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println( "Enter Passenger Name: ");
                    String passengerName = sc.nextLine();
                    System.out.println( "Enter Passenger DOB(YYYY-MM-DD): ");
                    String passengerDOB = sc.nextLine();
                    System.out.println("Enter Passenger Gender: ");
                    String passengerGender = sc.nextLine();
                    System.out.println("Enter Travel Date(YYYY-MM-DD): ");
                    String travelDate = sc.nextLine();
                    Passenger passenger = new Passenger(passengerName, LocalDate.parse(passengerDOB,formatter), passengerGender);
                    Ticket ticket = rs.booTicket(trainNumber, passenger, LocalDate.parse(travelDate,formatter));
                    if(ticket!=null){
                        ArrayList<Ticket> bt = ticket.getTrain(ticket.getTid()).getBookedTickets();
                        if(bt.contains(ticket))
                            System.out.println("Ticket Booked Successfully");
                        else
                            System.out.println("Ticket added to Waiting List : "+ticket.getPassenger().getPassengerName());
                    }
                    else
                        System.out.println("Ticket Booking Failed");
                    break;
                case 3:
                    System.out.println("Enter Ticket ID: ");
                    int ticketId = sc.nextInt();
                    sc.nextLine();
                    if(rs.cancelTicket(ticketId))
                        System.out.println("Ticket Cancelled");
                    else
                        System.out.println("No ticket is available with the id : "+ticketId);
                    break;
                case 4:
                    System.out.println("Enter Train Number: ");
                    int trainNumber1 = sc.nextInt();
                    sc.nextLine();
                    rs.showAvailableTicketsfromTrains(trainNumber1);
                    break;
                case 5:
                    System.out.println("Enter password to add trains to the System......");
                    String password = sc.nextLine();
                    if(rs.checkUser(password))
                    {
                        System.out.println("Enter Train Number: ");
                        int trainNumber2 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Train Name: ");
                        String trainName = sc.nextLine();
                        System.out.println("Enter Train Source: ");
                        String trainSource = sc.nextLine();
                        System.out.println("Enter Train Destination: ");
                        String trainDestination = sc.nextLine();
                        System.out.println("Enter total seats of the Train: ");
                        int totalSeats = sc.nextInt();
                        sc.nextLine();
                        rs.addTrain(new Train(trainNumber2, trainName, trainSource, trainDestination, totalSeats));
                    }
                    else{
                        System.out.println("Invalid Password!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the System...........");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!!....\nKindly enter a valid choice");
            }
                    
        }
    }
}
