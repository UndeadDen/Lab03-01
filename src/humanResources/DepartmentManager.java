package humanResources;

public class DepartmentManager implements GroupsManager {
    private String name;
    private Department[] departments;
    private Employee[] employees;
    private int size;
    private String organizationName = "";
    private departmentsNode head;
    private departmentsNode tail;
    private static final int DEFAULT_SIZE_DEP = 2;

    public DepartmentManager() {
        head = new departmentsNode();
    }

    public DepartmentManager(Department[] departments) {
        head = new departmentsNode();
        for (Department department : departments) {
            add(department);
        }
    }
    public Department[] getDepartments() {
        return departments;
    }

    public int size() {
        return size;
    }

    public int employeesQuantity() {
        int Quantity = 0;
        for (Department department : departments) {
            Quantity ++;
        }
        return Quantity;
    }

    public int groupsQuantity() {
        int quant=0;
        for (departmentsNode emp = head; emp != null;emp = emp.next){
            quant++;
        }
        return quant;
    }
    public void add(EmployeeGroup group) {
        departmentsNode node = new departmentsNode();
        if (size == 0) {
            head = node;
            tail = node;
            head.next = null;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public EmployeeGroup getEmployeeGroup(String name) {
        EmployeeGroup Group = null;
        for (departmentsNode emp = head; emp != null;emp = emp.next){
            if(emp.value.equals(name)){
                Group = emp.value;
            }
            return Group;
        }
        return Group;
    }
    public int employeesQuantity(JobTitlesEnum jobTitleEnum) {
        int j = 0;int i =0;
        String jobTitle = jobTitleEnum.name();
        for (departmentsNode emp = head; emp != null; emp = emp.next) {
            j += emp.value.employeesQuantity(jobTitle);
        }
        return j;
    }

    public EmployeeGroup humangroup(String secondName, String firstName) {
        EmployeeGroup Group = null;
        for (departmentsNode emp = head; emp != null; emp = emp.next) {
            if(emp.value.equals(emp.value.returnEmployee(secondName,firstName))){
                Group = emp.value;}else {return null;}
        }
        return Group;
    }

    public Employee mostVoluableEmployee() {
        Employee bestEmploye = null;int salar=0;
        for (departmentsNode curr = head; curr != null; curr = curr.next) {
            if (curr.value.bestEmployee().salary>salar) {
                salar = curr.value.bestEmployee().salary;
            }else{bestEmploye = curr.value.bestEmployee();}
        }
        return bestEmploye;
    }

    public String remove(String groupName) {
        for (departmentsNode curr = head; curr != null; curr = curr.next) {
            if (curr.value.getDepartmentName().equals(groupName)) {
                curr = null;
            }
            size --;
        }
        return null;
    }
    public int remove(EmployeeGroup group) {
        departmentsNode previous = tail;
        for (departmentsNode current = head; current != null; current = current.next) {
            if (previous == null) {
                current = head;
            } else {
                if (current.value.equals(group)) {
                    previous.next = current.next;
                }
                previous = current;
            }
            size --;
        }
        return size;
    }

    public int removeJobTitleAll(JobTitlesEnum jobTitleEnum) {
        departmentsNode previous = tail;
        Employee[] Emply;
        int quantity =0;
        for(departmentsNode current = head ; current !=null;current = current.next){
            current.value.remove(String.valueOf(jobTitleEnum));
            quantity += current.value.getEmployees(String.valueOf(jobTitleEnum)).length;
        }
        return quantity;
    }

    public int employeesQuantity(String jobTitle) {
        int Quantity = 0;
        for (Department department : departments) {
            if (department != null)
                Quantity += department.employeesQuantity(jobTitle);
        }
        return Quantity;
    }

    public Employee bestEmployee() {
        if (size > 0) {
            Employee currentEmployee, bestEmployee = departments[0].bestEmployee();
            for (int i = 0; i < size; i++) {
                currentEmployee = departments[i].bestEmployee();
                if (currentEmployee.getsalary() > bestEmployee.getsalary()) {
                    bestEmployee = currentEmployee;
                }
            }
            return bestEmployee;
        } else return null;
    }

    public Department getEmployeesDepartment(String firstName, String secondName) {
        Department[] departments = new Department[size];
        for (Department department : departments) {
            if (department != null)
                for (Employee employee : department.getEmployees()) {
                    if (employee != null && employee.getFirstName().equals(firstName) && employee.getSecondName().equals(secondName)) {
                        return department;
                    }
                }
        }
        return null;
    }
    private class departmentsNode{
        departmentsNode next;
        Department value;
        departmentsNode(){}
        departmentsNode(Department value){this.value = value;}
    }



}
