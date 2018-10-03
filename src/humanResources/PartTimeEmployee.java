package humanResources;

public class PartTimeEmployee {
    private String firstName;
    private String secondName;
    private String jobTitleEnum;
    private int salary;
    private int bonus;
    private static final int BONUS_DEFAULT = 0;
    public static final int SALARY_DEFAULT = 0;
    public static final String FIRST_JOB_TITLE = "NONE";
    public static final String SECOND_DEFAULT = "NONE";
    public static final String FIRST_DEFAULT = "NONE";
    protected  PartTimeEmployee(String firstName, String secondName) {
        this(SALARY_DEFAULT, firstName, secondName, FIRST_JOB_TITLE,BONUS_DEFAULT);
    }

    protected PartTimeEmployee(int salary, String firstName, String secondName, String jobTitleEnum,int bonus) {
        this.salary = salary;
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitleEnum = jobTitleEnum;
        this.bonus = BONUS_DEFAULT;
    }

    public int getSalary() {
        return salary;
    }

    public String getJobTitleEnum() {
        return jobTitleEnum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = 0;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJobTitleEnum(String jobTitleEnum) {
        this.jobTitleEnum = jobTitleEnum;
    }
    public boolean equals(Object obj){
        if (this == obj){
            return true;}
        if (obj.getClass() == Employee.class){
            return ((PartTimeEmployee)obj).secondName.equals(secondName)&&((PartTimeEmployee)obj).firstName.equals(firstName)&&
                    ((PartTimeEmployee)obj).jobTitleEnum.equals(jobTitleEnum)&&((PartTimeEmployee)obj).salary == salary;
        }
        return false;
    }
    public int hashCode() {
        int hash = secondName.hashCode();
        hash ^= salary;
        hash ^= firstName.hashCode();
        hash ^= jobTitleEnum.hashCode();
        return hash;
    }
    public String toString() {
        StringBuilder employeeString = new StringBuilder();
        if (secondName.equals(SECOND_DEFAULT))employeeString.append(secondName).append(" ");
        if (firstName.equals(FIRST_DEFAULT))employeeString.append(firstName).append(", ");
        if (jobTitleEnum.equals(FIRST_JOB_TITLE))employeeString.append(jobTitleEnum).append("(внешний совместитель), ");
        if (salary != SALARY_DEFAULT)employeeString.append(salary).append(":");
        return employeeString.toString();
    }
}
