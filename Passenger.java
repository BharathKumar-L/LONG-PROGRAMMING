import java.time.LocalDate;

class Passenger{
    private String passengerName;
    private LocalDate dob;
    private String gender;
    private int age;

    public Passenger(String passengerName, LocalDate dob, String gender) {
        this.passengerName = passengerName;
        this.dob = dob;
        this.gender = gender;
        this.age = LocalDate.now().getYear() - dob.getYear();
    }

    public String getDob(){
        return dob.toString();
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}