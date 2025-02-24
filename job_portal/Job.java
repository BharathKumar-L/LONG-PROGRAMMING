import java.util.LinkedList;
import java.util.List;

class Job{
    private int jobID=0;
    private String jobName;
    private String jobDescription;
    private String jobCompany;
    private String jobType;
    private String jobLocation;
    private double jobSalary;
    private int jobVacancies;
    private List<Employee> employees;

    public Job(String jobName, String jobDescription, String jobType, String jobLocation,String jobCompany,double jobSalary,int jobVacancies) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobType = jobType;
        this.jobVacancies = jobVacancies;
        this.jobLocation = jobLocation;
        this.jobCompany = jobCompany;
        this.jobSalary = jobSalary;
        this.employees = new LinkedList<>();
        this.jobID++;
    }

    public int getJobID() {
        return jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public double getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(double jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getJobVacancies() {
        return jobVacancies;
    }

    public String getJobCompany() {
        return jobCompany;
    }

    public void setJobCompany(String jobCompany) {
        this.jobCompany = jobCompany;
    }

    public void setJobVacancies(int jobVacancies) {
        this.jobVacancies = jobVacancies;
    }

    public boolean applyJob(Employee employee){
        if(jobVacancies>0){
            jobVacancies--;
            employees.add(employee);
            return true;
        }
        return false;
    }

    public void removeJob(){
        if(!employees.isEmpty()){
            System.out.println("Hey Employees: ");
            int index=1;
            for (Employee e: employees){
                System.out.println("Employee "+index+": "+e.getEmpName());
                index++;
            }
            employees.clear();
            System.out.println("The job posting " + jobName + " has been removed, and there are currently no vacancies for this position.");
        }
    }

    public void listEmployeesfromJob(){
        if(employees.isEmpty())
            System.out.println("There is no jobs to list");
        else{
            System.out.println("------------------------------------------------------");
            for(Employee employee : employees){
                System.out.println(" Employee Name: "+employee.getEmpName());
                System.out.println(" Employee Description: "+employee.getEmpDescription());
                System.out.println(" Employee Qualification: "+employee.getEmpQualification());
                System.out.println(" Employee Age: "+employee.getAge());
                System.out.println("------------------------------------------------------");
            }
        }
    }
}