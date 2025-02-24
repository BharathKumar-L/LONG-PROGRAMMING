import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Portal {
    Map<Integer, Job> jobs;
    Map<Integer, Employee> employees;
    Map<Job, Employee> applications;

    public Portal() {
        jobs = new HashMap<>();
        employees = new HashMap<>();
        applications = new HashMap<>();
    }

    public void addJob(Job job) {
        jobs.put(job.getJobID(), job);
    }

    public Job getJob(int jobID) {
        return jobs.get(jobID);
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getEmpId(), employee);
    }

    public boolean employeeExist(int empId) {
        return employees.containsKey(empId);
    }

    public boolean jobExist(int jobID) {
        return jobs.containsKey(jobID);
    }

    public void removeJob(int jobID) {
        if (jobs.get(jobID) != null) {
            jobs.get(jobID).removeJob();
            jobs.remove(jobID);
            System.out.println("Job with ID " + jobID + " removed successfully.");
        } else {
            System.out.println("Job with ID " + jobID + " does not exist.");
        }
    }

    public void removeEmployee(int empId) {
        if (employees.get(empId) != null) {
            employees.remove(empId);
            System.out.println("Employee with ID " + empId + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + empId + " does not exist.");
        }
    }

    public boolean applyJob(int empId, int jobID) {
        Employee employee = employees.get(empId);
        Job job = jobs.get(jobID);
        if (employee != null) {
            if (job != null) {
                job.applyJob(employee);
                applications.put(job, employee);
                System.out.println("Application submitted successfully.");
                return true;
            } else {
                System.out.println("Job not found");
                return false;
            }
        } else {
            System.out.println("Employee not found..Register as an employee to apply for a job");
            return false;
        }
    }

    public void updateJob(int jobID, String jobName, String jobDescription, String jobLocation, double salary,
            String jobType, String jobCompany, int jobVacancy) {
        Job job = jobs.get(jobID);
        job.setJobName(jobName);
        job.setJobDescription(jobDescription);
        job.setJobLocation(jobLocation);
        job.setJobSalary(salary);
        job.setJobType(jobType);
        job.setJobCompany(jobCompany);
        job.setJobVacancies(jobVacancy);
    }

    public void updateEmployee(int empId, String empName, String empDescription, String empQualification,
            LocalDate dob) {
        Employee employee = employees.get(empId);
        employee.setEmpName(empName);
        employee.setEmpDescription(empDescription);
        employee.setEmpQualification(empQualification);
        employee.setDob(dob);
    }

    public void listJobs() {
        if (jobs.isEmpty()) {
            System.out.println("There are no jobs..........");
        } else {
            System.out.println("------------------------------------------------------");
            for (Job job : jobs.values()) {
                System.out.println("Job ID: " + job.getJobID());
                System.out.println("Job Name : " + job.getJobName());
                System.out.println("Job Description : " + job.getJobDescription());
                System.out.println("Job Company : " + job.getJobCompany());
                System.out.println("Job Type :" + job.getJobType());
                System.out.println("Job Salary : " + job.getJobSalary());
                System.out.println("------------------------------------------------------");
            }
        }
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("There are no employees..........");
        } else {
            System.out.println("------------------------------------------------------");
            for (Employee employee : employees.values()) {
                System.out.println("Employee ID: " + employee.getEmpId());
                System.out.println("Employee Name : " + employee.getEmpName());
                System.out.println("Employee Description : " + employee.getEmpDescription());
                System.out.println("Emplyee Qualification : " + employee.getEmpQualification());
                System.out.println("Employee Age : " + employee.getAge());
                System.out.println("------------------------------------------------------");
            }
        }
    }

    public void listApplications() {
        if (applications.isEmpty()) {
            System.out.println("There are no applications..........");
        } else {
            System.out.println("------------------------------------------------------");
            for (Map.Entry<Job, Employee> application : applications.entrySet()) {
                Job job = application.getKey();
                Employee employee = application.getValue();
                System.out.println("Job Name : " + job.getJobName());
                System.out.println("Job Description : " + job.getJobDescription());
                System.out.println("Job Company : " + job.getJobCompany());
                System.out.println();
                System.out.println("Employee Name : " + employee.getEmpName());
                System.out.println("Employee Description : " + employee.getEmpDescription());
                System.out.println("Emplyee Qualification : " + employee.getEmpQualification());
                System.out.println("------------------------------------------------------");
            }
        }
    }
}
