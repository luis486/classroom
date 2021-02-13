package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    
    
    public List<UserAccount> people;

    public Classroom() {
        people = new ArrayList<>();
    }

    public void addNewUser(String userName, String password, String photo, Gender chooseGender, String chooseCareer, String birthday, Browser browser) {
        people.add(new UserAccount( userName, password, photo, chooseGender, chooseCareer,birthday, browser));
    }
    
    public List<UserAccount> getUsers(){
        return people; 
    }
}


