package humanResources;

public class Department implements EmployeeGroup {
    private Employee[] employees;
    private int size;
    private String departmentName;
    private static final int ARRAY_DEFAULT = 8;
    private static final int SIZE_DEFAULT = 0;
    private static final String NAME_DEFAULT = "";
    private JobTitlesEnum jobTitleEnum;

    public Department(String departmentName) {
        this(SIZE_DEFAULT, departmentName);

    }

    public Department(int size, String departmentName) {
        this.employees = new Employee[size];
        this.size = SIZE_DEFAULT;
        this.departmentName = departmentName;
        this.employees = new Employee[ARRAY_DEFAULT];
    }

    public Department(Employee[] employees) {
        Employee[] empty = new Employee[size];
        System.arraycopy(employees, 0, empty, 0, size);
        this.employees = empty;
        this.size = empty.length;
    }

    public void setNameProject(String nameProject) {
        this.departmentName = nameProject;
    }

    public String getNameProject() {
        return departmentName;
    }

    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            Employee[] newEmployee = new Employee[size * 2];
            System.arraycopy(employees, 0, newEmployee, 0, size);
            employees = newEmployee;
        }
        employees[size++] = employee;
        return true;
    }

    public boolean remove(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(employee)) {
                shift(i);
                size--;
                return true;
            }
        }
        return false;
    }

    private void shift(int index) {
        System.arraycopy(employees, index + 1, employees, index, size - 1);
        employees[size] = null;
    }

    public boolean remove(String firstName, String secondName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getSecondName().equals(secondName) && employees[i].getFirstName().equals(firstName)) {
                shift(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean remove(String JobTitle) {
        for (int i = 0; i <= size; i++) {
            if (employees[i].getJobTitleEnum().equals(JobTitle)) {
                shift(i);
                size--;
                i--;
            }
            if (i == size) return true;
        }
        return false;
    }

    public Employee returnEmployee(String firstName, String secondName) {
        Employee[] worker = new Employee[size];
        for (int i = 0; i < size; i++) {
            if (employees[i].getFirstName().equals(firstName) && employees[i].getSecondName().equals(secondName)) {
                worker[1] = employees[i];
            }
        }
        return worker[1];
    }

    public Employee[] getEmployees() {
        Employee[] employiff = new Employee[size];
        System.arraycopy(employees, 0, employiff, 0, size);
        return employiff;
    }

    public int getSize() {
        return size;
    }

    public Employee[] getEmployees(String jobTitle) {
        Employee[] emply = new Employee[size];
        int jobTite = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getJobTitleEnum().equals(jobTitle)) {
                emply[jobTite] = employees[i];
                jobTite++;
            }
        }
        Employee[] employeesCorrectJobTitle = new Employee[jobTite];
        System.arraycopy(emply, 0, employeesCorrectJobTitle, 0, jobTite);
        return employeesCorrectJobTitle;
    }

    public Employee bestEmployee() {
        Employee BestEmployee = employees[0];
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getsalary() > bestEmployee().getsalary()) {
                    BestEmployee = employees[i];
                }
            }
            return BestEmployee;
        } else return null;
    }

    public int employeeQuantity(Project employee) {
        return size;
    }

    public String[] employee(Employee employee) {
        return new String[0];
    }

    public Employee[] sortedEmployee(Employee sorted) {
        return new Employee[0];
    }

    public int employeeQuantity() {
        int quantity = size;
        return size;
    }

    public int employeesQuantity(String jobTitleEnum) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i].getJobTitleEnum().equals(jobTitleEnum)) {
                j++;
            }
        }
        return j;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("DepartmentManager:/n");
        if (employees != null) {
            output.append(employees.toString()).append("\n");
        }
        output.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            output.append(employees[i].toString()).append("\n");
        }

        return output.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DepartmentManager) {
            return ((Department) obj).departmentName.equals("") && ((Department) obj).employees.equals("");
        }
        return false;
    }

    public int hashCode() {
        int hash = employees.hashCode();
        hash ^= departmentName.hashCode();
        hash ^= size;
        hash ^= employeeQuantity();
        return hash;
    }

    public int getcountTimeEmployee() {
        int quant = 0;
        for (Employee employee : employees) {
            quant += employee.countTimeEmployee();
        }
        return quant;
    }

    public int getEmployee() {
        int quant = getEmployees().length;
        return quant;
    }
}
