/**********************************************
Workshop 6
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 03/13/2022
**********************************************/

package application;
	
import java.io.BufferedReader;
import java.io.FileReader;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*******************************primary*******************************/
			primaryStage.setTitle("Search Name Ranking Application");
			
			GridPane root = new GridPane();
//			GridPane buttonRow = new GridPane();
			
			Text year = new Text("Enter the Year:");
	        Text gender = new Text("Enter the Gender:");
	        Text name = new Text("Enter the Name:");
	        
	        TextField yearField = new TextField();
	    	TextField genderField = new TextField();
	    	TextField nameField = new TextField();
	    	
	    	Button submitButton = new Button("Submit Query");
	        Button exitButton = new Button("Exit");
	        Button yesButton = new Button("Yes");
	        Button noButton = new Button("No");
	        
	        submitButton.setPrefWidth(100);
	        exitButton.setPrefWidth(100);
	        yesButton.setPrefWidth(100);
	        noButton.setPrefWidth(100);
	        
	        root.add(year, 0, 0);
	        root.add(yearField, 1, 0);
	        root.add(gender, 0, 1);
	        root.add(genderField, 1, 1);
	        root.add(name, 0, 2);
	        root.add(nameField, 1, 2);
	        root.add(submitButton, 0, 3);
	        root.add(exitButton, 1, 3);
//	        root.add(buttonRow, 1, 3);
//	        buttonRow.add(submitButton, 1, 1);
//	        buttonRow.add(exitButton, 2, 1);
	        
	        root.setHgap(10);
	        root.setVgap(10);
	        root.setAlignment(Pos.CENTER);
//	        GridPane.setHalignment(buttonRow, HPos.CENTER);
//	        GridPane.setHalignment(exitButton, HPos.CENTER);
			
			Scene scene = new Scene(root, 400, 250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			submitButton.setOnAction(e -> {
				String rank = ">1000";
		        try (BufferedReader br = new BufferedReader(new FileReader(String.format("babynamesranking" + yearField.getText() + ".txt")))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                if (line.contains(nameField.getText())) {
		                	rank = line.substring(0, 3);
		                    break;
		                }
		            }
		            root.getChildren().remove(yearField);
					root.getChildren().remove(genderField);
					root.getChildren().remove(nameField);
					root.getChildren().remove(submitButton);
					root.getChildren().remove(exitButton);
		            if (genderField.getText().equals("M") || genderField.getText().equals("m")) {
		            	year.setText(String.format("Boy name " + nameField.getText() + " is ranked #" + rank + " in " + yearField.getText() + " year"));
			        } else {
			        	year.setText(String.format("Girl name " + nameField.getText() + " is ranked #" + rank + " in " + yearField.getText() + " year"));
			        }
		            gender.setText(String.format(""));
		            name.setText(String.format("Do you want to Search for another Name:"));
		            root.add(yesButton, 0, 3);
		            root.add(noButton, 1, 3);
		        } catch (Exception er) {
		        	System.out.println("file with year not found");;
		        }
	        });

	        exitButton.setOnAction(e -> {
	            System.exit(0);
	        });
			
			yesButton.setOnAction(e -> {
				root.getChildren().remove(yesButton);
				root.getChildren().remove(noButton);
				year.setText("Enter the Year:");
		        root.add(yearField, 1, 0);
		        gender.setText("Enter the Gender:");
		        root.add(genderField, 1, 1);
		        name.setText("Enter the Name:");
		        root.add(nameField, 1, 2);
		        root.add(submitButton, 0, 3);
		        root.add(exitButton, 1, 3);
	        });

	        noButton.setOnAction(e -> {
	            System.exit(0);
	        });
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
