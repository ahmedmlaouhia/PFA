package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ajouterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane addpannel;

    @FXML
    private TextField type;

    @FXML
    private TextField nombre;

    @FXML
    private Button btnClick;

    @FXML
    private Button annuler;

    @FXML
    private Label numError;

    @FXML
    private Label typeError;
    
    @FXML
    private Label success;

    @FXML
    void annuler(ActionEvent event) throws IOException {
    	BorderPane root1 = (BorderPane)FXMLLoader.load(getClass().getResource("supprimer.fxml"));
		Scene scene1 = new Scene(root1,750,450);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene1);
		window.show();
    }

    @FXML
    void valider(ActionEvent event) {
    	boolean v=true;
    	success.setText("");
    	typeError.setText("");
    	numError.setText("");
    	if(type.getText().length()==0) {
    		typeError.setText("le nom ne doit pas être vide");
    		v=false;
    	}else if(!type.getText().matches("[a-zA-Z]+")) {
    		typeError.setText("le nom doit être alphabétique");
    		v=false;
    	}
    	if(nombre.getText().length()==0) {
    		numError.setText("la quantité ne doit pas être vide");
    		v=false;
    	}else if(!nombre.getText().matches("[0-9]+")) {
    		v=false;
    		numError.setText("la quantité doit être numérique");
    	}else if(Integer.parseInt(nombre.getText())<1) {
    		v=false;
    		numError.setText("la quantité doit être < 1");
    	}
    	if(v){
    		DBoutils.ajouter(type.getText(),Integer.parseInt(nombre.getText()));
    		success.setText("ajout avec succès");
    	}
    	v=true;
    }

    @FXML
    void initialize() {
        assert addpannel != null : "fx:id=\"addpannel\" was not injected: check your FXML file 'Sample.fxml'.";
        assert type != null : "fx:id=\"type\" was not injected: check your FXML file 'Sample.fxml'.";
        assert nombre != null : "fx:id=\"nombre\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnClick != null : "fx:id=\"btnClick\" was not injected: check your FXML file 'Sample.fxml'.";
        assert annuler != null : "fx:id=\"annuler\" was not injected: check your FXML file 'Sample.fxml'.";
        assert numError != null : "fx:id=\"numError\" was not injected: check your FXML file 'Sample.fxml'.";
        assert typeError != null : "fx:id=\"typeError\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}

