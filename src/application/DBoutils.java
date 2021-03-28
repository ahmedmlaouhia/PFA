package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBoutils {
	static Connection connection;
	static Statement statement;
	
	public static int supprimer(String a ,int b) {		
			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PFA","pfa123456789");
				statement= connection.createStatement();
				ResultSet rs=statement.executeQuery("select nombre from outils where type='"+a+"'");
				if(rs.next()){
					int number=rs.getInt(1);
					if(number>=b) {
						statement.executeUpdate("update outils set nombre="+(number-b)+" where type='"+a+"'");
						return 1;
					}else{
						return number;
					}
				}else{
					return 2;
				}
			} catch (SQLException e) {
				P.print("oops : ");
			}
			return 0;
	}
	
	public static void ajouter(String a ,int b) {		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PFA","pfa123456789");
			statement= connection.createStatement();
			ResultSet rs=statement.executeQuery("select nombre from outils where type='"+a+"'");
			if(rs.next()){
				statement.executeUpdate("update outils set nombre="+(rs.getInt(1)+b)+" where type='"+a+"'");
			}else{
				statement.executeUpdate("insert into outils values('"+a+"',"+b+")");
			}
		} catch (Exception e) {
			P.print("oops : ");
		}
	}
/*
	public static void consulterListeOutils(String a ,int b) {		
		public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException
	    {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("PersonView.fxml"));
	        Parent tableViewParent = loader.load();
	        
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //access the controller and call a method
	        PersonViewController controller = loader.getController();
	        controller.initData(tableView.getSelectionModel().getSelectedItem());
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
	    }
	    
	}*/
	
}
