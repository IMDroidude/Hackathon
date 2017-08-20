package droidudes.hackathon.factories;

import java.util.ArrayList;
import java.util.List;

import droidudes.hackathon.models.JobPostBO;

/**
 * Created by Zare Ahmed on 20-Aug-17.
 */
public class JobListFactory {

    public List<JobPostBO> getJobPostBO() {
        List<JobPostBO> JobPostBOList = new ArrayList<>();
//String jobTitle, String companyName, String workLocation, String skillNeeded, String workHours, String detailDesc, String salary

        JobPostBOList.add(new JobPostBO("Karhai worker", "Kaamyaars","Rawalpindi, Sardar","No specifics",
                "8 hrs","","Rs. 20,000"));
        JobPostBOList.add(new JobPostBO("Adda worker", "Kaamyaars","Rawalpindi, Sardar","No specifics",
                "8 hrs","","Rs. 20,000"));
        JobPostBOList.add(new JobPostBO("Chef", "NCA", "Islamabad, Murree road", "None", "6 hrs", "", "Rs. 25,000"));

        JobPostBOList.add(new JobPostBO("Sewing master", "Sadia’s", "Islamabad", "Sewing", "8 hrs", "", "Rs. 30,000"));
        JobPostBOList.add(new JobPostBO("Head knitter", "Khaadi", "Islamabad", "Knitting", "4 hrs", "", "Rs. 4,000 per piece"));
        JobPostBOList.add(new JobPostBO("Karhai worker", "Kaamyaars","Rawalpindi, Sardar","No specifics",
                "8 hrs","","Rs. 20,000"));
        JobPostBOList.add(new JobPostBO("Adda worker", "Kaamyaars","Rawalpindi, Sardar","No specifics",
                "8 hrs","","Rs. 20,000"));
        JobPostBOList.add(new JobPostBO("Chef", "NCA", "Islamabad, Murree road", "None", "6 hrs", "", "Rs. 25,000"));

        JobPostBOList.add(new JobPostBO("Sewing master", "Sadia’s", "Islamabad", "Sewing", "8 hrs", "", "Rs. 30,000"));
        JobPostBOList.add(new JobPostBO("Head knitter", "Khaadi", "Islamabad", "Knitting", "4 hrs", "", "Rs. 4,000 per piece"));
        JobPostBOList.add(new JobPostBO("Karhai worker", "Kaamyaars","Rawalpindi, Sardar","No specifics",
                "8 hrs","","Rs. 20,000"));
        JobPostBOList.add(new JobPostBO("Adda worker", "Kaamyaars","Rawalpindi, Sardar","No specifics",
                "8 hrs","","Rs. 20,000"));
        JobPostBOList.add(new JobPostBO("Chef", "NCA", "Islamabad, Murree road", "None", "6 hrs", "", "Rs. 25,000"));

        JobPostBOList.add(new JobPostBO("Sewing master", "Sadia’s", "Islamabad", "Sewing", "8 hrs", "", "Rs. 30,000"));
        JobPostBOList.add(new JobPostBO("Head knitter", "Khaadi", "Islamabad", "Knitting", "4 hrs", "", "Rs. 4,000 per piece"));
        JobPostBOList.add(new JobPostBO("Karhai worker", "Kaamyaars","Rawalpindi, Sardar","No specifics",
                "8 hrs","","Rs. 20,000"));
        JobPostBOList.add(new JobPostBO("Adda worker", "Kaamyaars","Rawalpindi, Sardar","No specifics",
                "8 hrs","","Rs. 20,000"));
        JobPostBOList.add(new JobPostBO("Chef", "NCA", "Islamabad, Murree road", "None", "6 hrs", "", "Rs. 25,000"));

        JobPostBOList.add(new JobPostBO("Sewing master", "Sadia’s", "Islamabad", "Sewing", "8 hrs", "", "Rs. 30,000"));
        JobPostBOList.add(new JobPostBO("Head knitter", "Khaadi", "Islamabad", "Knitting", "4 hrs", "", "Rs. 4,000 per piece"));

        return JobPostBOList;
    }
}
