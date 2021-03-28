package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class supprimerController {

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
    private Button supprimer;

    @FXML
    private Button annuler;

    @FXML
    private Label numError;

    @FXML
    private Label typeError;

    @FXML
    private Label success;

    @FXML
    void annuler(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {
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
    		numError.setText("la quantité doit être > 1");
    	}
    	if(v){
    		int x= DBoutils.supprimer(type.getText(),Integer.parseInt(nombre.getText()));
    		if(x==1) {
    			success.setText(nombre.getText()+" "+type.getText()+" supprimé avec succès");
    		}else if(x==2) {
    			success.setText("il n y a pas de "+type.getText());
    		}else 
    			success.setText("il n y a que "+x+" "+type.getText());
    	}
    	v=true;
    }

    @FXML
    void initialize() {
        assert addpannel != null : "fx:id=\"addpannel\" was not injected: check your FXML file 'Supprimer.fxml'.";
        assert type != null : "fx:id=\"type\" was not injected: check your FXML file 'Supprimer.fxml'.";
        assert nombre != null : "fx:id=\"nombre\" was not injected: check your FXML file 'Supprimer.fxml'.";
        assert supprimer != null : "fx:id=\"supprimer\" was not injected: check your FXML file 'Supprimer.fxml'.";
        assert annuler != null : "fx:id=\"annuler\" was not injected: check your FXML file 'Supprimer.fxml'.";
        assert numError != null : "fx:id=\"numError\" was not injected: check your FXML file 'Supprimer.fxml'.";
        assert typeError != null : "fx:id=\"typeError\" was not injected: check your FXML file 'Supprimer.fxml'.";
        assert success != null : "fx:id=\"success\" was not injected: check your FXML file 'Supprimer.fxml'.";

    }
}
