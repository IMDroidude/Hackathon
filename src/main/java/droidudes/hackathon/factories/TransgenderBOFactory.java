package droidudes.hackathon.factories;

import java.util.ArrayList;
import java.util.List;

import droidudes.hackathon.models.TransGenderBO;

/**
 * Created by Zare Ahmed on 20-Aug-17.
 */
public class TransgenderBOFactory {

    public List<TransGenderBO> getTransGenderList(){
        List<TransGenderBO> transList = new ArrayList<>();

        // transList.add(new TransGenderBO(long age, String name, String skills, String pastExperience, String contactNumber));

        transList.add(new TransGenderBO(26, "Bilkees Begam", "Sewing", "Warda", "03xx-xxxxxxx"));

        transList.add(new TransGenderBO(26, "Bilkees Begam", "Sewing", "Warda", "03xx-xxxxxxx"));

        transList.add(new TransGenderBO(24, "Zakia Begam", "Knitting", "Sadia's", "03xx-xxxxxxx"));

        transList.add(new TransGenderBO(30, "Rozi", "Hair Styling", "None", "03xx-xxxxxxx"));

        transList.add(new TransGenderBO(20, "Jugnu", "Sewing", "khaadi", "03xx-xxxxxxx"));

        transList.add(new TransGenderBO(18, "Bobby", "Sewing", "none", "03xx-xxxxxxx"));

        return transList;
    }
}
