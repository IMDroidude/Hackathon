package droidudes.hackathon.models;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class JobPostBO {

    private String name;
    private String workHours;
    private String skills;
    private String ageGroup;

    public JobPostBO(){

    }

    public JobPostBO(String name, String workHours, String skills, String ageGroup) {
        this.name = name;
        this.workHours = workHours;
        this.skills = skills;
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}
