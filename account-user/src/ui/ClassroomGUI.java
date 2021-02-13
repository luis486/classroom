package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.Classroom;
import model.UserAccount;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

public class ClassroomGUI {

    @FXML
    private TextField txtUsername;

    @FXML
    private RadioButton rbGender1;

    @FXML
    private ToggleGroup chooseGender;

    @FXML
    private RadioButton rbGender2;

    @FXML
    private RadioButton rbGender3;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField textUsername;

    @FXML
    private PasswordField textPasswrord;

    @FXML
    private TextField txtPathPhoto;

    @FXML
    private DatePicker txtBirthday;

    @FXML
    private ChoiceBox<String> comboBox;

    @FXML
    private CheckBox cbTelematic;

    @FXML
    private CheckBox cbSoftware;

    @FXML
    private CheckBox cbIndustrial;

    @FXML
    private TableView<UserAccount> accountList;

    @FXML
    private TableColumn<UserAccount, String> colUserName;

    @FXML
    private TableColumn<UserAccount, String> colGender;

    @FXML
    private TableColumn<UserAccount, String> colCareer;

    @FXML
    private TableColumn<UserAccount, String> colBirthday;

    @FXML
    private TableColumn<UserAccount, String> colBrowser;

    @FXML
    private ImageView imageView;

    @FXML
    private Label lblName;
    
    @FXML
    private Pane mainPane;


    public Classroom classRoom;

    public ClassroomGUI(Classroom classRoom){
        this.classRoom = classRoom;
    }

    public void showLogIn() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(root);
    }

    
    @FXML
    void logIn(ActionEvent event) throws IOException {
        if (loginVerification(txtUsername.getText(), txtPassword.getText()) != null) {
            UserAccount user = loginVerification(txtUsername.getText(), txtPassword.getText());
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("account-list.fxml"));
            fxmlloader.setController(this);
            Parent root = fxmlloader.load();
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(root);
            txtUsername.setText("");
			txtPassword.setText("");
			initializableTableView();			
			this.lblName.setText(user.getUserName());
            this.imageView.setImage(user.getPhoto());
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Name of users and/or password invalid");
            alert.showAndWait();
        }
    }

    public UserAccount loginVerification(String userName, String password) {
        UserAccount exists = null;
        String user = userName;
        String pass = password;
        boolean found = false;
        for (int i = 0; i < classRoom.getUsers().size() && !found; i++) {
            if (classRoom.getUsers().get(i).getUserName().equals(user)
                    && classRoom.getUsers().get(i).getPassword().equals(pass)) {
			exists = classRoom.getUsers().get(i);
			found = true;
			}
		}
		return exists;
	}

    @FXML
    void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(root);
    }
    
    @FXML
    void signIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(root);
    }

    public UserAccount userVerification (String userName) {
		UserAccount exists = null;
		String user = userName;	
		boolean found = false;
		for (int i=0; i<classRoom.getUsers().size() && !found;i++) {
			if (classRoom.getUsers().get(i).getUserName().equals(user)) {
			exists = classRoom.getUsers().get(i);
			found = true;
			}
		}
		return exists;
	}
    
    @FXML
    void createanAccount(ActionEvent event) throws IOException {
        String career="";
		var gender1= "";
		if(cbSoftware.isSelected()) {
			career="Software Engineering";
		}else if(cbTelematic.isSelected()) {
			career="Telematic Engineering";
		}else if(cbSoftware.isSelected()) {
			career="Industrial Engineering";
		}
		if(rbGender1.isSelected()) {
			gender1="Male";
		}else if(rbGender2.isSelected()) {
			gender1="Female";
		}else if(rbGender3.isSelected()) {
			gender1="Other";
		}
		if (userVerification(txtUsername.getText())==null) { 
			File f = new File(txtPathPhoto.getText());
			Image img = new Image(f.toURI().toString());
			this.classRoom.addNewUser(
				txtUsername.getText(), 
				txtPassword.getText(), 
				img, 
				gender1, 
				career,
				txtBirthday.getValue().toString(),
				comboBox.getSelectionModel().getSelectedItem().toString());
				showLogIn();
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Error");
			alert.setContentText("The name of the user cant be used");
			alert.showAndWait();
		}
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(root);
    }

    @FXML
    void fileChooser(ActionEvent event) {
        FileChooser fc = new FileChooser();		
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images","*.jpg","*.png","*.jpeg"));
		File selectedFile = fc.showOpenDialog(null);
        Image image = null;
		if (selectedFile != null) {
			txtPathPhoto.setText(selectedFile.getPath());
            image = new Image(selectedFile.toURI().toString());
		}else {
			txtPathPhoto.setText("Invalid path");
		}

        imageView.setImage(image);
    }

    public void initializableTableView() throws IOException{
		ObservableList<UserAccount> listAccounts = FXCollections.observableArrayList(classRoom.getUsers());
		colUserName.setCellValueFactory(new PropertyValueFactory <UserAccount,String>("username"));
		colGender.setCellValueFactory(new PropertyValueFactory <UserAccount,String>("gender"));
		colCareer.setCellValueFactory(new PropertyValueFactory <UserAccount,String>("career"));	
		colBirthday.setCellValueFactory(new PropertyValueFactory <UserAccount,String>("birthday"));
		colBrowser.setCellValueFactory(new PropertyValueFactory <UserAccount,String>("browser"));
		accountList.setItems(listAccounts); 
	}

  




}
