import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class ReservationSystem {
    private Map<Integer,Train> trains;
    private Map<Integer,Ticket> tickets;
    private int ticketCounter;
    private final String passString = "!@#$%^&*";
    
        public ReservationSystem() {
            trains = new HashMap<>();
            tickets = new HashMap<>();
            ticketCounter = 1;
        }
    
        public void addTrain(Train train) {
            trains.put(train.getTrainNumber(), train);
        }
    
        public Train getTrain(int trainNumber) {
            return trains.get(trainNumber);
        }
    
        public Ticket booTicket(int trainNumber,Passenger passenger, LocalDate travelDate){
            Train train = getTrain(trainNumber);
            if(train!=null){
                Ticket ticket = new Ticket(ticketCounter++,train,passenger,travelDate);
                tickets.put(ticket.getTid(),ticket);
                if(train.bookTicket(ticket));
                    return ticket;
            }
            return null;
        }
    
        public boolean cancelTicket(int tid) {
            Ticket ticket = tickets.get(tid);
            if (ticket!=null) {
                Train train = ticket.getTrain(tid);
                train.cancelTicket(ticket);
                tickets.remove(tid);
                return true;
            }
            return false;
        }
    
        public boolean checkUser(String passString){
            return this.passString.equals(passString);
    }

    public void showAvailableTrains(){
        if (trains.isEmpty()) {
            System.out.println("No trains are available.....");
            return;
        }
        for(Train train : trains.values()){
            System.out.println("Train Number : "+train.getTrainNumber());
            System.out.println("Train Name : "+train.getTrainName());
            System.out.println("Train Source : "+train.getSource());
            System.out.println("Train Destination : "+train.getDestination());
            System.out.println("----------------------------------------");
        }
    }

    public void showAvailableTicketsfromTrains(int trainNumber){
        Train train = getTrain(trainNumber);
        if(train== null){
            System.out.println("No train with trainNumber "+trainNumber +" is available.....");
            return;
        }
        train.showTickets(trainNumber);
    }
}
