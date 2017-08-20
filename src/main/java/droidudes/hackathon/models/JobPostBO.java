package droidudes.hackathon.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class JobPostBO implements Parcelable {

    /*jobTitleTv,companyNameTv,workLocationTv,skillNeededTv,workHourTv;
    private TextView detailDescTv,salaryTv;*/
    private String jobTitle;
    private String companyName;
    private String workLocation;
    private String skillNeeded;
    private String workHours;
    private String detailDesc;
    private String salary;


    public JobPostBO(String jobTitle, String companyName, String workLocation, String skillNeeded, String workHours, String detailDesc, String salary) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.workLocation = workLocation;
        this.skillNeeded = skillNeeded;
        this.workHours = workHours;
        this.detailDesc = detailDesc;
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getSkillNeeded() {
        return skillNeeded;
    }

    public void setSkillNeeded(String skillNeeded) {
        this.skillNeeded = skillNeeded;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.jobTitle);
        dest.writeString(this.companyName);
        dest.writeString(this.workLocation);
        dest.writeString(this.skillNeeded);
        dest.writeString(this.workHours);
        dest.writeString(this.detailDesc);
        dest.writeString(this.salary);
    }

    protected JobPostBO(Parcel in) {
        this.jobTitle = in.readString();
        this.companyName = in.readString();
        this.workLocation = in.readString();
        this.skillNeeded = in.readString();
        this.workHours = in.readString();
        this.detailDesc = in.readString();
        this.salary = in.readString();
    }

    public static final Parcelable.Creator<JobPostBO> CREATOR = new Parcelable.Creator<JobPostBO>() {
        @Override
        public JobPostBO createFromParcel(Parcel source) {
            return new JobPostBO(source);
        }

        @Override
        public JobPostBO[] newArray(int size) {
            return new JobPostBO[size];
        }
    };
}
