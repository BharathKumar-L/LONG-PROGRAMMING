import java.time.LocalDate;

class Ticket{
    private int tid;
    private Train train;
    private Passenger passenger;
    private LocalDate travDate;
    public Ticket(int tid, Train train, Passenger passenger, LocalDate travDate) {
        this.tid = tid;
        this.train = train;
        this.passenger = passenger;
        this.travDate = travDate;
    }

    public int getTid() {
        return tid;
    }

    public Train getTrain(int tid) {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getTravelDate() {
        return travDate.toString();
    }
}