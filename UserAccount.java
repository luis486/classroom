package model;

public class UserAccount {
    
    private String userName;
    private String password;
    private String photo;
    private Gender chooseGender;
    private String chooseCareer;
    private String birthday;
    private Browser browser;

    public UserAccount() {
    }

    public UserAccount(String userName, String password, String photo, Gender chooseGender, String chooseCareer, String birthday, Browser browser) {
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

    public String getPhoto() {
        return this.photo;
    }

    public Gender getChooseGender() {
        return this.chooseGender;
    }

    public String getChooseCareer() {
        return this.chooseCareer;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public Browser getBrowser() {
        return this.browser;
    }

}
