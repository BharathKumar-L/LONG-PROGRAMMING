import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Portal portal = new Portal();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a Job");
            System.out.println("2. Update a Job");
            System.out.println("3. Remove a Job");
            System.out.println("4. List all Jobs");
            System.out.println("5. Add an Employee");
            System.out.println("6. Update an Employee");
            System.out.println("7. Remove an Employee");
            System.out.println("8. List all Employees");
            System.out.println("9. Apply for a Job");
            System.out.println("10. List all Applications in a Job");
            System.out.println("11. List all Applications");
            System.out.println("12. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Job Details..........");
                    System.out.println("Enter Job Title: ");
                    String jobTitle = sc.nextLine();
                    System.out.println("Enter Job Description: ");
                    String jobDescription = sc.nextLine();
                    System.out.println("Enter Job Location: ");
                    String jobLocation = sc.nextLine();
                    System.out.println("Enter Job Salary: ");
                    double jobSalary = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter Job Type: ");
                    String jobType = sc.nextLine();
                    System.out.println("Enter Job Company: ");
                    String jobCompany = sc.nextLine();
                    System.out.println("Enter Job Vacancies");
                    int jobVacancies = sc.nextInt();
                    sc.nextLine();
                    portal.addJob(new Job(jobTitle, jobDescription, jobType, jobLocation, jobCompany, jobSalary,
                            jobVacancies));
                    System.out.println("Job Added Successfully");
                    break;
                case 2:
                    System.out.println("Enter Job ID: ");
                    int jobID = sc.nextInt();
                    sc.nextLine();
                    if (portal.jobExist(jobID)) {
                        System.out.println("Enter NEW Job Title: ");
                        String jobtitle = sc.nextLine();
                        System.out.println("Enter NEW Job Description: ");
                        String jobdescription = sc.nextLine();
                        System.out.println("Enter NEW Job Location: ");
                        String joblocation = sc.nextLine();
                        System.out.println("Enter NEW Job Salary: ");
                        double jobsalary = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter NEW Job Type: ");
                        String jobtype = sc.nextLine();
                        System.out.println("Enter NEW Job Company: ");
                        String jobcompany = sc.nextLine();
                        System.out.println("Enter NEW Job Vacancy");
                        int jobvacancies = sc.nextInt();
                        sc.nextLine();
                        portal.updateJob(jobID, jobtitle, jobdescription, joblocation, jobsalary, jobtype, jobcompany,
                                jobvacancies);
                        System.out.println("Job updated successfully");
                    } else
                        System.out.println("Job not found");
                    break;
                case 3:
                    System.out.println("Enter Job ID: ");
                    int jobid = sc.nextInt();
                    sc.nextLine();
                    portal.removeJob(jobid);
                    break;
                case 4:
                    portal.listJobs();
                    break;
                case 5:
                    System.out.println("Enter Employee Details..........");
                    System.out.println("Enter Employee Name: ");
                    String employeename = sc.nextLine();
                    System.out.println("Enter Employee Description: ");
                    String employeedescription = sc.nextLine();
                    System.out.println("Enter Employee Qulification: ");
                    String employeequalification = sc.nextLine();
                    LocalDate dob = null;
                    while (dob == null) {
                        System.out.println("Enter Employee DOB(YYYY-MM-DD): ");
                        String employeedob = sc.nextLine().trim();
                        try {
                            dob = LocalDate.parse(employeedob, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use YYYY-MM-DD");
                        }
                    }
                    portal.addEmployee(new Employee(employeename, employeedescription, employeequalification, dob));
                    break;
                case 6:
                    System.out.println("Enter Employee ID: ");
                    int employeeid = sc.nextInt();
                    sc.nextLine();
                    if (portal.employeeExist(employeeid)) {
                        System.out.println("Enter NEW Employee Name: ");
                        String employeeName = sc.nextLine();
                        System.out.println("Enter NEW Employee Description: ");
                        String employeeDescription = sc.nextLine();
                        System.out.println("Enter NEW Employee Qulification: ");
                        String employeeQualification = sc.nextLine();
                        LocalDate Dob = null;
                        while (Dob == null) {
                            System.out.println("Enter NEW Employee DOB(YYYY-MM-DD): ");
                            String employeeDob = sc.nextLine().trim();
                            try {
                                Dob = LocalDate.parse(employeeDob, formatter);
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please use YYYY-MM-DD");
                            }
                        }
                        portal.updateEmployee(employeeid, employeeName, employeeDescription, employeeQualification,
                                Dob);
                        System.out.println("Employee updated successfully");
                    } else
                        System.out.println("Employee not found");
                    break;
                case 7:
                    System.out.println("Enter Employee ID: ");
                    int employeeid1 = sc.nextInt();
                    sc.nextLine();
                    portal.removeEmployee(employeeid1);
                    break;
                case 8:
                    portal.listEmployees();
                    break;
                case 9:
                    System.out.println("Enter Employee ID: ");
                    int employeeid2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Job ID: ");
                    int jobid1 = sc.nextInt();
                    sc.nextLine();
                    portal.applyJob(employeeid2, jobid1);
                    break;
                case 10:
                    System.out.println("Enter Job ID: ");
                    int jobid2 = sc.nextInt();
                    portal.getJob(jobid2).listEmployeesfromJob();
                    break;
                case 11:
                    portal.listApplications();
                    break;
                case 12:
                    System.out.println("Exiting the System........");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
