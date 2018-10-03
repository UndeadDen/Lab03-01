package humanResources;

public class BusinessTravel {
    private int dayCount;
    private int compensation;
    private String destination;
    private String description;
    public static final int COMPENSATION_DEFAULT = 0;
    public static final int DAYCOUNT_DEFAULT = 0;
    public static final String DESTINATION_DEFAULT = "NONE";
    public static final String DESCRIPRION_DEFAULT = "NONE";

    public BusinessTravel(int dayCount, int compensation, String destination, String description) {
        this.dayCount = dayCount;
        this.compensation = compensation;
        this.destination = destination;
        this.description = description;
    }

    public int getDayCount() {
        return dayCount;
    }

    public String getDescription() {
        return description;
    }

    public String getDestination() {
        return destination;
    }

    public int getCompensation() {
        return compensation;
    }

    public String toString() {
        StringBuilder businessTravel = new StringBuilder();
        if (!destination.equals(DESTINATION_DEFAULT)) businessTravel.append(destination).append(" ");
        if (dayCount != DAYCOUNT_DEFAULT) businessTravel.append(dayCount).append(", ");
        if (compensation != COMPENSATION_DEFAULT) businessTravel.append("(").append(compensation).append("). ");
        if (!description.equals(DESCRIPRION_DEFAULT)) businessTravel.append(description).append(", ");
        return businessTravel.toString();
    }

    public int hashCode() {
        int hash = destination.hashCode();
        hash ^= dayCount;
        hash ^= compensation;
        hash ^= description.hashCode();
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BusinessTravel) {
            return ((BusinessTravel) obj).destination.equals(destination) && ((BusinessTravel) obj).description.equals(description) && ((BusinessTravel) obj).dayCount == dayCount;
        }
        return false;
    }
}
