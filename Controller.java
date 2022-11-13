package application;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	private RadioButton veg;
	@FXML
	private RadioButton cheese;
	@FXML
	private RadioButton pep;
	@FXML
	private CheckBox mush;
	@FXML
	private CheckBox onion;
	@FXML
	private CheckBox olive;
	@FXML
	private CheckBox ec;
	private double Total;
	@FXML
	private TextArea textarea;
	@FXML
	private Button ct;
	private ToggleGroup group;
	@FXML
	private TextArea ID;
	@FXML
	private TextArea username1;
	@FXML
	private TextArea password1;
	@FXML
	private TextArea username2;
	@FXML
	private TextArea password2;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	
	public void switchToStudent(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Student.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoCheckoutPage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CheckoutPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void SwitchtoOrderStatus(ActionEvent event) throws IOException {
		 String S = ID.getText();
		  StringBuilder contentBuilder = new StringBuilder();
		    try (Stream<String> stream = Files.lines( Paths.get("C:\\Users\\ponna\\Drive\\studentdb.txt"), StandardCharsets.UTF_8))
		    {
		        stream.forEach(s -> contentBuilder.append(s).append("\n"));
		    }
		    catch (IOException e)
		    {
		        e.printStackTrace();
		    }
		    if (contentBuilder.toString().contains(S)) {
		    	Parent root = FXMLLoader.load(getClass().getResource("OrderStatus.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show(); 
		    }
		    else {
		    	System.out.println(-1);
		    }
	}
	
	public void SwitchtoProcessingAgentLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ProcessingAgentLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void SwitchtoProcessingAgentPortal(ActionEvent event) throws IOException {
		if(username2.getText().equals("processing") && password2.getText().equals("agent")) {
		Parent root = FXMLLoader.load(getClass().getResource("ProcessingAgentPortal.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
	
	public void SwitchtoChefLoginPage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ChefLoginPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void SwitchtoChefLoginPortal(ActionEvent event) throws IOException {
		if(username1.getText().equals("chef") && password1.getText().equals("pizza")) {
		
		Parent root = FXMLLoader.load(getClass().getResource("ChefLoginPortal.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		
	}
	
		public void sat (ActionEvent event) throws IOException {
			
			 ToggleGroup group = new ToggleGroup();
			 cheese.setToggleGroup(group);
			 pep.setToggleGroup(group);
			 veg.setToggleGroup(group);
			
			if(cheese.isSelected()){
				Total = 10.00;
			}
			if(pep.isSelected()){
				Total = 15.00;
			}
			if(veg.isSelected()) {
				Total = 12.00;
			}
			if(ec.isSelected()) {
				Total = Total+ 1.50;
			}
			if(olive.isSelected()) {
				Total = Total+ 1.50;
			}
			if(mush.isSelected()) {
				Total = Total+ 1.50;
			}	
			if(onion.isSelected()) {
				Total = Total+1.50;
			}
		}
	
		@FXML
	    public void handle(ActionEvent event) throws IOException {
	    	textarea.setText("$"+String.valueOf(Total)); 	
	}	
		
		

}
	