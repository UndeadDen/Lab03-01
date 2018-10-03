package humanResources;

public class ProjectManager implements GroupsManager {
    private int size;
    projectNode head;
    projectNode tail;

    public ProjectManager() {
        head = new projectNode();
    }

    public ProjectManager(Project[] projects) {
        head = new projectNode();
        for (Project project : projects) {
            add(project);
        }

    }

    public int employeesQuantity(EmployeeGroup employeeGroup) {
        int quant = 0;
        int i = 0;
        for (projectNode emp = head; emp != null; emp = emp.next, i++) {
            if (emp.value.employee.equals(employeeGroup)) {
                if (emp.value != null) {
                    quant++;
                }
            }
        }
        return quant;
    }

    public int employeesQuantity() {
        int empl = 0;
        for (projectNode emp = head; emp != null; emp = emp.next) {
            if (emp.value.employee == null) {
                empl++;
            }
        }
        return empl;
    }

    public int groupsQuantity() {
        int quant = 0;
        for (projectNode emp = head; emp != null; emp = emp.next) {
            quant++;
        }
        return quant;
    }

    public void add(EmployeeGroup group){
        projectNode node = new projectNode();
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

    private boolean contains(EmployeeGroup group) {
        projectNode node = head;
        while (node != null) {
            if (group.equals(node.value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public EmployeeGroup getEmployeeGroup(String name) {
        EmployeeGroup Group = null;
        for (projectNode emp = head; emp != null; emp = emp.next) {
            if (emp.value.equals(name)) {
                Group = emp.value;
            }
            return Group;
        }
        return Group;
    }

    public int employeesQuantity(JobTitlesEnum jobTitleEnum) {
        int j = 0;
        int i = 0;
        for (projectNode emp = head; emp != null; emp = emp.next, i++) {
            if (emp.value.employee.jobTitleEnum.equals(jobTitleEnum)) {
                j++;
            }
        }
        return j;
    }

    public EmployeeGroup humangroup(String secondName, String firstName) {
        EmployeeGroup Group = null;
        for (projectNode emp = head; emp != null; emp = emp.next) {
            if (emp.value.employee.secondName.equals(secondName) && emp.value.employee.firstName.equals(firstName)) {
                Group = emp.value;
            }
        }
        return Group;
    }

    public Employee mostVoluableEmployee() {
        Employee bestEmploye = null;
        int salar = 0;
        for (projectNode curr = head; curr != null; curr = curr.next) {
            if (curr.value.employee.salary > salar) {
                salar = curr.value.employee.salary;
            } else {
                bestEmploye = curr.value.employee;
            }
        }
        return bestEmploye;
    }

    public String remove(String groupName) {
        for (projectNode curr = head; curr != null; curr = curr.next) {
            if (curr.value.getNameProject().equals(groupName)) {
                curr = null;
            }
            size--;
        }
        return null;
    }

    public int remove(EmployeeGroup group) {
        projectNode previous = tail;
        for (projectNode current = head; current != null; current = current.next) {
            if (previous == null) {
                current = head;
            } else {
                if (current.value.equals(group)) {
                    previous.next = current.next;
                }
                previous = current;
            }
            size--;
        }
        return size;
    }

    public int removeJobTitleAll(JobTitlesEnum jobTitleEnum) {
        projectNode previous = tail;
        int quantity = 0;
        for (projectNode current = head; current != null; current = current.next) {
            if (previous == null) {
                current = head;
            } else {
                current.value.removeAll(jobTitleEnum);
                quantity += current.value.quant(jobTitleEnum);
            }
            previous = current;
            size--;
        }
        return quantity;
    }

    private class projectNode {
        projectNode next;
        Project value;

        projectNode() {
        }

        projectNode(Project value) {
            this.value = value;
        }
    }

}

