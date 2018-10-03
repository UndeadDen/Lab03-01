package humanResources;

public class StaffEmployee extends Employee implements BusinessTraveller {
    private int size;
    private List travelList;

    public StaffEmployee(String firstName, String secondName, String jobTitleEnum, int salary, BusinessTravel[] travel) {
        super(firstName, secondName, jobTitleEnum, salary);
        travelList = new List(travel);
        bonus = BONUS_DEFAULT;
        size = travel.length;
    }

    public StaffEmployee(String firstName, String secondName) {
        this(firstName, secondName, JOB_TITLE_DEFAULT, SALARY_DEFAULT, null);
    }

    public StaffEmployee(String firstName, String secondName, String jobTitleEnum, int salary) {
        this(firstName, secondName, jobTitleEnum, salary, null);
    }

    public boolean addTravel(BusinessTravel businessTravel) {
        travelList.addElement(businessTravel);
        return true;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public BusinessTravel[] getTravels() {
        return travelList.getTravelList();
    }

    public String toString() {
        StringBuilder staffEmployee = new StringBuilder();
        if (!secondName.equals(SECOND_DEFAULT)) staffEmployee.append(secondName).append(" ");
        if (!firstName.equals(FIRST_DEFAULT)) staffEmployee.append(firstName).append(", ");
        if (!jobTitleEnum.equals(JOB_TITLE_DEFAULT)) staffEmployee.append(jobTitleEnum).append(", ");
        if (salary != 0) staffEmployee.append(salary).append("р., ");
        if (bonus != 0) staffEmployee.append(bonus).append("р. \n");
        staffEmployee.append("Командировки: ");
        BusinessTravel[] travel = travelList.getTravelList();
        for (int i = 0; i < size; i++) {
            if (!travel[i].toString().equals(null)) staffEmployee.append(travel[i].toString());
        }
        return staffEmployee.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() == Employee.class) {
            return ((Employee) obj).secondName.equals(secondName) && ((Employee) obj).firstName.equals(firstName) && ((Employee) obj).jobTitleEnum.equals(jobTitleEnum)
                    && ((Employee) obj).salary == (salary);
        }
        return false;
    }

    public int hashCode() {
        int hash = secondName.hashCode();
        hash ^= salary;
        hash ^= firstName.hashCode();
        return hash;

    }

    private class List {

        private class ListElement {
            ListElement next;
            BusinessTravel data;
        }

        private ListElement head;
        private ListElement tail;

        public List(BusinessTravel[] travelList){
            addElements(travelList);
        }

        public void addElement(BusinessTravel data) {
            ListElement a = new ListElement();
            a.data = data;
            if (tail == null)
            {
                head = a;
                tail = a;
            } else {
                tail.next = a;
                tail = a;
            }
        }

        public void addElements(BusinessTravel[] travelList) {
            for (int i = 0; i < travelList.length; i++)
                addElement(travelList[i]);
        }

        public BusinessTravel[] getTravelList()
        {
            BusinessTravel[] travelList = new BusinessTravel[size];
            ListElement t = head;
            int k = 0;
            while (t != null)
            {
                travelList[k] = t.data;
                k++;
                t = t.next;
            }
            return travelList;
        }
    }

}
