import java.util.*;

class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int availableSeats;
    private ArrayList<Ticket> bookedTickets;
    private Queue<Ticket> waitingTickets;

    private static final int MAX_WAITING_LIST = 3;

    public Train(int trainNumber, String trainName, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.availableSeats = totalSeats;
        this.bookedTickets = new ArrayList<>();
        this.waitingTickets = new LinkedList<>();
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public ArrayList<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public Queue<Ticket> getWaitingTickets() {
        return waitingTickets;
    }

    public boolean bookTicket(Ticket ticket) {
        if (availableSeats > 0) {
            bookedTickets.add(ticket);
            return true;
        } else if (waitingTickets.size() < MAX_WAITING_LIST) {
            waitingTickets.add(ticket);
            return true;
        }
        return false;
    }

    public boolean cancelTicket(Ticket ticket){
        if(!bookedTickets.isEmpty()){
            bookedTickets.remove(ticket);
            availableSeats++;
            if(!waitingTickets.isEmpty()){
                Ticket waitingTicket = waitingTickets.poll();
                bookedTickets.add(waitingTicket);
                System.out.println();
            }
            return true;
        }
        return false;
    }

    public void showTickets(int trainNumber) {
        System.out.println("Train Name: " + trainName);
        System.out.println("----------------------------");
        if (bookedTickets.isEmpty()) {
            System.out.println("No tickets booked");
        } else {
            System.out.println("Booked Tickets: ");
            System.out.println("----------------------------");
            for (Ticket ticket : bookedTickets) {
                System.out.println("Ticket Id : " + ticket.getTid());
                System.out.println("Passenger Name : " + ticket.getPassenger().getPassengerName());
                System.out.println("Travel Date : " + ticket.getTravelDate());
            }
        }
        if (waitingTickets.isEmpty()) {
            System.out.println("No tickets in waiting list");
        } else {
            System.out.println("Waiting Tickets: ");
            System.out.println("----------------------------");
            for (Ticket ticket : waitingTickets) {
                System.out.println("Ticket Id : " + ticket.getTid());
                System.out.println("Passenger Name : " + ticket.getPassenger().getPassengerName());
                System.out.println("Travel Date : " + ticket.getTravelDate());
            }
        }
        System.out.println("----------------------------");
    }

}