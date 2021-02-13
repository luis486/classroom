package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Classroom {
    
    
    public List<UserAccount> people;

    public Classroom() {
        people = new ArrayList<>();
    }

    public void addNewUser(String userName, String password, Image photo, String chooseGender, String chooseCareer, String birthday, String browser) {
        people.add(new UserAccount( userName, password, photo, chooseGender, chooseCareer,birthday, browser));
    }
    
    public List<UserAccount> getUsers(){
        return people; 
    }
}


