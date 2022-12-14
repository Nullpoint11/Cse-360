package application;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Stream;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller{
	
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

	public Order[] orderarr = new Order[100];

	public static String[] reallist;

	public static String[] readytocook;

	static int readytocooksize = 0;
	int i = 0;




	File myObj = new File("orderlist.txt");




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
		    try (Stream<String> stream = Files.lines( Paths.get("C:\\Users\\Anirudh Arvind\\OneDrive\\Desktop\\studentdb.txt"), StandardCharsets.UTF_8))
		    {
		        stream.forEach(s -> contentBuilder.append(s).append("\n"));
		    }
		    catch (IOException e)
		    {
		        e.printStackTrace();
		    }
		    if (contentBuilder.toString().contains(S)) {
				orderarr[i] = new Order(S);
				i++;
				try {
					FileWriter myWriter = new FileWriter("orderlist.txt", true);
					myWriter.write("Student ID: " + orderarr[i-1].getStudentid() + " Order Status: " + orderarr[i-1].getStatus() + "\n");
					myWriter.close();
					System.out.println("Successfully wrote to the file.");
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
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
			File myObj = new File("orderlist.txt");
			Scanner myReader = new Scanner(myObj);
			String[] templist = new String[100];
			int j = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				templist[j] = data;
				j++;

			}

			reallist = new String[j];

			for(int i = 0; i < j; i++){
				reallist[i] = templist[i];
			}


			FXMLLoader loader =  new FXMLLoader(getClass().getResource("ProcessingAgentPortal.fxml"));
			root = loader.load();

			ProcessingAgentController processing = loader.getController();
			processing.orderslist = templist;
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

	public static String[] getList() {
		return reallist;
	}

	public static String[] getprocessedList(){
		return readytocook;
	}

	public static void processElement(String element){

		/*for(int i = 0; i < reallist.length; i++){
			if(element.equals(reallist[i])){

			}
		}*/

		if(readytocook != null){
			String[] temp = new String[readytocooksize];
			temp = readytocook;

			readytocooksize++;
			readytocook =  new String[readytocooksize];

			for(int i = 0; i < readytocooksize-1; i++){
				readytocook[i] = temp[i];
			}

			readytocook[readytocooksize-1] = element;
		}else{
			readytocooksize++;
			readytocook =  new String[readytocooksize];
			readytocook[0] = element;
		}


	}



}
	