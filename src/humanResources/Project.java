package humanResources;

import java.time.LocalDate;

public class Project implements EmployeeGroup {
    private Node head;
    private Node tail;
    private String nameProject;
    private final int DEFAULT_SIZE = 0;
    private final String NAMEPROJECT_DEFAULT = "";
    private int size;
    Employee employee;
    Department departments;
    BusinessTraveller traveller;
    BusinessTravel[] travel;

    public Project(String nameProject) {
        head = new Node();
    }

    public Project(String nameProject, Employee[] employees){
        head = new Node();
        for (Employee employee : employees) {
            add(employee);
        }
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    private class Node {
        Node next;
        Employee value;

        Node() {
        }

        Node(Employee value) {
            this.value = value;
        }
    }

    public boolean add(Employee employee) {
        Node node = new Node(employee);
        if (size == 0) {
            head = node;
            tail = node;
            head.next = null;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;

    }

    private boolean contains(Employee employee) {
        Node node = head;
        while (node != null) {
            if (employee.equals(node.value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean remove(String firstName, String secondName) {
        Node previous = tail;
        for (Node current = head; current != null; current = current.next) {
            if (previous == null) {
                current = head;
            } else {
                if (current.value.secondName.equals(secondName) && current.value.firstName.equals(firstName)) {
                    previous.next = current.next;
                }
                previous = current;
            }
            size--;
        }
        return true;
    }

    public boolean remove(Employee employ) {
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.value.equals(employ)) {
                curr = null;
            }
            size--;
        }
        return true;
    }

    public boolean removeAll(JobTitlesEnum jobTitleEnum) {
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.value.equals(jobTitleEnum)) {
                curr = null;
            }
            size--;
        }
        return true;
    }

    public int quant(JobTitlesEnum jobTitleEnum) {
        int quant = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.value.equals(jobTitleEnum)) {
                quant++;
            }
        }
        return quant;
    }


    public Employee bestEmployee() {
        Node bestEmp = null;
        int defSalary = 0;
        for (Node salary = head; salary != null; salary = salary.next) {
            if (salary.value.salary > defSalary) {
                defSalary = salary.value.salary;
            } else {
                bestEmp = salary;
            }

        }
        return bestEmp.value;
    }

    public int employeeQuantity(Project employee) {
        int Size = 0;
        for (Node size = head; size != null; size = size.next) {
            Size++;
        }
        return Size;
    }

    public String[] employee(Employee employee) {
        return new String[0];
    }

    public Employee[] employProject() {
        Employee[] empProject = new Employee[size];
        int i = 0;
        for (Node emp = head; emp != null; emp = emp.next, i++) {
            empProject[i] = emp.value;
        }
        return empProject;
    }

    public Employee[] sortedEmployee(Employee sorted) {
        Employee[] empProject1 = employProject();
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (empProject1[j].salary > empProject1[j + 1].salary) {
                    sorted = empProject1[j];
                    empProject1[j] = empProject1[j + 1];
                    empProject1[j + 1] = sorted;
                }
            }
        }
        return empProject1;
    }

    public String toString() {
        Node node = head;
        StringBuilder projectString = new StringBuilder();
        if (nameProject.equals(NAMEPROJECT_DEFAULT)) projectString.append(nameProject).append(" ");
        if (size != DEFAULT_SIZE) projectString.append(size).append(":");
        if (employee != null) {
            projectString.append(employee.toString()).append("\n");
        }
        while (node != null) {
            projectString.append(node.value.toString()).append("\n");
            node = node.next;
        }
        return projectString.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Project) {
            return ((Project) obj).nameProject.equals(nameProject) && ((Project) obj).employee.equals(employee);
        }
        return false;
    }

    public int hashCode() {
        int hash = nameProject.hashCode();
        hash ^= size;
        return hash;
    }

    public int getcountTimeEmployee() {
        int quant = 0;
        for (Node emp = head; emp != null; emp = emp.next) {
            quant = emp.value.countTimeEmployee();

        }
        return quant;
    }

    public int getEmployee() {
        return size;
    }


}
