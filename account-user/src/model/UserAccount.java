package model;

import javafx.scene.image.Image;

public class UserAccount {
    
    private String userName;
    private String password;
    private Image photo;
    private String chooseGender;
    private String chooseCareer;
    private String birthday;
    private String browser;

    public UserAccount() {
    }

    public UserAccount(String userName, String password, Image photo, String chooseGender, String chooseCareer, String birthday, String browser) {
        this.userName = userName;
        this.password = password;
        this.photo = photo;
        this.chooseGender = chooseGender;
        this.chooseCareer = chooseCareer;
        this.birthday = birthday;
        this.browser = browser;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public Image getPhoto() {
        return this.photo;
    }

    public String getChooseGender() {
        return this.chooseGender;
    }

    public String getChooseCareer() {
        return this.chooseCareer;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getBrowser() {
        return this.browser;
    }

}
