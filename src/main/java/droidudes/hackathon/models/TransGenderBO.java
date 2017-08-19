package droidudes.hackathon.models;

/**
 * Created by Zare Ahmed on 19-Aug-17.
 */
public class TransGenderBO {

    public long age;
    public String name;

    public TransGenderBO() {

    }
    public TransGenderBO(long age, String name) {
        this.age = age;
        this.name = name;
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
}
