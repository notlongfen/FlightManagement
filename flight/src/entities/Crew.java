package entities;

import java.util.List;

public class Crew {
    private List<String> crewId;
    private List<String> crewName;
    private List<String> crewType;
    private List<String> crewStatus;
    
    public Crew(List<String> crewId, List<String> crewName, List<String> crewType, List<String> crewStatus) {
        this.crewId = crewId;
        this.crewName = crewName;
        this.crewType = crewType;
        this.crewStatus = crewStatus;
    }

    public List<String> getCrewId() {
        return crewId;
    }

    public List<String> getCrewName() {
        return crewName;
    }

    public List<String> getCrewType() {
        return crewType;
    }

    public List<String> getCrewStatus() {
        return crewStatus;
    }

    public void setCrewId(List<String> crewId) {
        this.crewId = crewId;
    }

    public void setCrewName(List<String> crewName) {
        this.crewName = crewName;
    }

    public void setCrewType(List<String> crewType) {
        this.crewType = crewType;
    }

    public void setCrewStatus(List<String> crewStatus) {
        this.crewStatus = crewStatus;
    }

    @Override
    public String toString() {
        return "Crew [crewId=" + crewId + ", crewName=" + crewName + ", crewStatus=" + crewStatus + ", crewType="
                + crewType + "]";
    }

    
}
