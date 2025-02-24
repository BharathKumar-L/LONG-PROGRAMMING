import java.time.LocalDate;

class Employee {
    private int empId=0;
    private String empName;
    private String empQualification;
    private String empDescription;
    private LocalDate dob;
    private int age;

    public Employee(String empName, String empQualification, String empDescription, LocalDate dob) {
        this.empId++;
        this.empName = empName;
        this.dob = dob;
        this.empDescription = empDescription;
        this.empQualification = empQualification;
        this.age = LocalDate.now().getYear() - dob.getYear();
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getEmpId() {
        return empId;
    }

    public int getAge() {
        return age;
    }

    public String getEmpDescription() {
        return empDescription;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpQualification() {
        return empQualification;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpQualification(String empQualification) {
        this.empQualification = empQualification;
    }

    public void setEmpDescription(String empDescription) {
        this.empDescription = empDescription;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
        this.age = LocalDate.now().getYear() - dob.getYear();
    }
}
