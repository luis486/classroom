package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
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
    private TableColumn<String, UserAccount> colUserName;

    @FXML
    private TableColumn<String, UserAccount> colGender;

    @FXML
    private TableColumn<String, UserAccount> colCareer;

    @FXML
    private TableColumn<String, UserAccount> colBirthday;

    @FXML
    private TableColumn<String, UserAccount> colBrowser;

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(root);
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
    }

    public void initComboBox(){
        ObservableList<String> comBox = FXCollections.observableArrayList("Mozilla", "Firefox", "Chrome", "Edge", "Chronium");
        comboBox.setValue("Mozilla");
        comboBox.setItems(comBox);
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(root);
        initComboBox();
    }
    
    @FXML
    void save(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().setAll(root);

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

  




}
