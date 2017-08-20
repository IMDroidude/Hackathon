package droidudes.hackathon.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class TransGenderBO implements Parcelable {

    public long age;
    public String name;
    public String skills;
    public String pastExperience;
    public String contactNumber;

    public TransGenderBO() {

    }
    public TransGenderBO(long age, String name) {
        this.age = age;
        this.name = name;
    }

    public TransGenderBO(long age, String name, String skills, String pastExperience, String contactNumber) {
        this.age = age;
        this.name = name;
        this.skills = skills;
        this.pastExperience = pastExperience;
        this.contactNumber = contactNumber;
    }



    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPastExperience() {
        return pastExperience;
    }

    public void setPastExperience(String pastExperience) {
        this.pastExperience = pastExperience;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.age);
        dest.writeString(this.name);
        dest.writeString(this.skills);
        dest.writeString(this.pastExperience);
        dest.writeString(this.contactNumber);
    }

    protected TransGenderBO(Parcel in) {
        this.age = in.readLong();
        this.name = in.readString();
        this.skills = in.readString();
        this.pastExperience = in.readString();
        this.contactNumber = in.readString();
    }

    public static final Parcelable.Creator<TransGenderBO> CREATOR = new Parcelable.Creator<TransGenderBO>() {
        @Override
        public TransGenderBO createFromParcel(Parcel source) {
            return new TransGenderBO(source);
        }

        @Override
        public TransGenderBO[] newArray(int size) {
            return new TransGenderBO[size];
        }
    };
}
