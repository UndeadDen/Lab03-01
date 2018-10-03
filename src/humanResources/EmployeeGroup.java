package humanResources;

public interface EmployeeGroup {
    void setNameProject(String nameProject);
    String getNameProject();
    boolean remove(Employee employee);
    boolean remove(String secondName,String firstName);
    Employee bestEmployee();
    int employeeQuantity(Project employee);
    String[] employee(Employee employee);
    Employee[] sortedEmployee(Employee sorted);
    String toString();
    boolean equals(Object obj);
    int hashCode();
    int getcountTimeEmployee();
    int getEmployee();
}
