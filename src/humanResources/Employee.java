package humanResources;

public abstract class  Employee{
    protected String secondName;
    protected String firstName;
    protected String jobTitleEnum;
    protected int salary;
    protected PartTimeEmployee[] timeEmployee;
    protected int bonus;
    public static final int BONUS_DEFAULT = 0;
    public static final int SALARY_DEFAULT = 0;
    public static final String JOB_TITLE_DEFAULT = "NONE";
    public static final String SECOND_DEFAULT = "NONE";
    public static final String FIRST_DEFAULT = "NONE";

    protected Employee(String firstName, String secondName, String jobTitleEnum,int salary) {
        this.salary = salary;
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitleEnum = jobTitleEnum;
        this.bonus = BONUS_DEFAULT;
    }

    protected  Employee(String firstName, String secondName) {
        this(firstName, secondName, JOB_TITLE_DEFAULT, SALARY_DEFAULT);
    }

    protected Employee() {
        this(FIRST_DEFAULT, SECOND_DEFAULT, JOB_TITLE_DEFAULT, SALARY_DEFAULT);
    }

    public String  getFirstName() {
        return firstName;
    }

    public int getsalary() {
        return salary;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String Firstname) {
        this.firstName = Firstname;
    }

    public void setCost(int salary) {
        this.salary = salary;
    }

    public void setSecondName(String Secondname) {
        this.secondName = Secondname;
    }

    public String getJobTitleEnum() {
        return jobTitleEnum;
    }

    public void setJobTitleEnum() {
        this.jobTitleEnum = jobTitleEnum;
    }
    public void setSalary(){
        this.salary = salary;
    }

    public abstract void setBonus(int bonus);
    public abstract int getBonus();
    public String toString() {
        StringBuilder employeeString = new StringBuilder();
        if(secondName.equals(SECOND_DEFAULT))employeeString.append(secondName).append(" ");
        if (firstName.equals(FIRST_DEFAULT))employeeString.append(firstName).append(", ");
        if (jobTitleEnum.equals(JOB_TITLE_DEFAULT))employeeString.append(jobTitleEnum).append(", ");
        if (salary != SALARY_DEFAULT)employeeString.append(salary).append(":");
        return employeeString.toString();
    }
    public boolean equals(Object obj){
        if (this == obj){
            return true;}
        if (obj instanceof Employee){
            return ((Employee)obj).secondName.equals(secondName)&&((Employee)obj).firstName.equals(firstName)&&
                    ((Employee)obj).jobTitleEnum.equals(jobTitleEnum)&&((Employee)obj).salary == salary;
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
    public int countTimeEmployee() {
        int count = 0;count = timeEmployee.length;
        return count;
    }
}
