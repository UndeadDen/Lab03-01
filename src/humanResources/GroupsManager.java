package humanResources;

public interface GroupsManager {
    int employeesQuantity();
    int groupsQuantity();
    EmployeeGroup getEmployeeGroup(String name);
    int employeesQuantity(JobTitlesEnum jobTitleEnum);
    EmployeeGroup humangroup(String secondName, String firstName);
    Employee mostVoluableEmployee();
    String remove(String groupName);
    int remove(EmployeeGroup group);
    int removeJobTitleAll(JobTitlesEnum jobTitleEnum);
}
