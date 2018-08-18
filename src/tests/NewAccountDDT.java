package tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {

    String name;
    String email;
    String phone;
    String gender;
    String password;
    String country;
    boolean weeklyEmail;
    boolean monthlyEmail;
    boolean occasionalEmail;

    //Test method
    @Test
    public void newAccountTest() {
        System.out.println("New record for test: " + name + " " + email + " " + phone + " " + gender + " " + password
                + " " + country);
        //+ " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);

    }

    //Gets data and passes to constructor
    @Parameterized.Parameters
    public static List<String[]> getData() {
        return utilities.CSV.get("C:\\SDET\\Files\\testdata.txt");
    }

    //Constructor that passes to test method
    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
                         String weeklyEmail, String monthlyEmail, String occasionalEmail) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;
//        this.weeklyEmail = weeklyEmail;
//        this.monthlyEmail = monthlyEmail;
//        this.occasionalEmail = occasionalEmail;

    }
}
