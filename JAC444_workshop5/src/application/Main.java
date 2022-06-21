/**********************************************
Workshop 5
Course: JAC444 - 2022 Winter
Last Name: Tao
First Name: Henry
ID: 118375203
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature: Henry
Date: Date: 02/27/2022
**********************************************/

package application;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Main extends Application {
	int index = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//title
			primaryStage.setTitle("Address Book");
			
			// gridpane rows
	        GridPane root = new GridPane();
	        GridPane firstNameRow = new GridPane();
	        GridPane lastNameRow = new GridPane();
	        GridPane addressRow = new GridPane();
	        GridPane buttonRow = new GridPane();

	        // label
	        Text first = new Text("First Name:");
	        Text last = new Text("Last Name:");
	        Text city = new Text("City:");
	        Text province = new Text("Province:");
	        Text postal = new Text("Postal Code:");

	        // input fields
	        TextField firstField = new TextField();
	        TextField lastField = new TextField();
	        TextField cityField = new TextField();
	        ChoiceBox<String> provinceField = new ChoiceBox<String>();
	        provinceField.getItems().addAll("AB", "BC", "MB", "NB", "NL", "NT", "NS", "NU", "ON", "PE", "QC", "SK", "YT");
	        TextField postalField = new TextField();

	        // same sized buttons
	        Button addButton = new Button("Add");
	        addButton.setPrefWidth(100);
	        Button firstButton = new Button("First");
	        firstButton.setPrefWidth(100);
	        Button nextButton = new Button("Next");
	        nextButton.setPrefWidth(100);
	        Button previousButton = new Button("Previous");
	        previousButton.setPrefWidth(100);
	        Button lastButton = new Button("Last");
	        lastButton.setPrefWidth(100);
	        Button updateButton = new Button("Update");
	        updateButton.setPrefWidth(100);

	        // Setting the padding around the grid
	        root.setPadding(new Insets(10, 10, 10, 10));
	        firstNameRow.setPadding(new Insets(10, 10, 10, 10));
	        lastNameRow.setPadding(new Insets(10, 10, 10, 10));
	        addressRow.setPadding(new Insets(10, 10, 10, 10));
	        buttonRow.setPadding(new Insets(10, 10, 10, 10));

	        // Setting the gap between cells and alignment
	        firstNameRow.setVgap(5);
	        firstNameRow.setHgap(5);
	        lastNameRow.setVgap(5);
	        lastNameRow.setHgap(5);
	        addressRow.setVgap(5);
	        addressRow.setHgap(5);
	        buttonRow.setVgap(5);
	        buttonRow.setHgap(5);

	        // Arranging all the nodes in the grid
	        firstNameRow.add(first, 1, 1);
	        firstNameRow.add(firstField, 2, 1, 100, 1);
	        
	        root.add(firstNameRow, 1, 1);
	        
	        lastNameRow.add(last, 1, 1);
	        lastNameRow.add(lastField, 2, 1, 100, 1);

	        root.add(lastNameRow, 1, 2);

	        addressRow.add(city, 1, 1);
	        addressRow.add(cityField, 2, 1);
	        addressRow.add(province, 3, 1);
	        addressRow.add(provinceField, 4, 1);
	        addressRow.add(postal, 5, 1);
	        addressRow.add(postalField, 6, 1, 40, 1);

	        root.add(addressRow, 1, 3);

	        buttonRow.add(addButton, 1, 1);
	        buttonRow.add(firstButton, 2, 1);
	        buttonRow.add(nextButton, 3, 1);
	        buttonRow.add(previousButton, 4, 1);
	        buttonRow.add(lastButton, 5, 1);
	        buttonRow.add(updateButton, 6, 1);

	        root.add(buttonRow, 1, 4);

	        Scene scene = new Scene(root, 600, 230);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        addButton.setOnAction( e -> {
	        	try (RandomAccessFile RandomFile = new RandomAccessFile("AddressBook.dat", "rw");) {
	        		System.out.println("adding new address #" + RandomFile.length() / 90);
    				RandomFile.seek(RandomFile.length());
    				RandomFile.write(setLength(firstField.getText().getBytes(), 30));
    				RandomFile.write(setLength(lastField.getText().getBytes(), 30));
    				RandomFile.write(setLength(cityField.getText().getBytes(), 20));
    				RandomFile.write(setLength(provinceField.getValue().getBytes(), 3));
    				RandomFile.write(setLength(postalField.getText().getBytes(), 7));
    			}
    			catch (FileNotFoundException ex) {}
    			catch (IOException ex) {}
    			catch (IndexOutOfBoundsException ex) {}
	        });
	        
	        firstButton.setOnAction(e -> {
	        	try (RandomAccessFile RandomFile = new RandomAccessFile("AddressBook.dat", "rw");) {
    				if (RandomFile.length() > 0) {
    					index = 0;
    					fillField(RandomFile, firstField, lastField, cityField, provinceField, postalField);
    				}
    				else {
    					System.out.println("no address");
    				}
    			}
    			catch (IOException ex) {}
	        });

	        // Event handling for the NEXT button is pressed
	        nextButton.setOnAction(e -> {
	        	try (RandomAccessFile RandomFile = new RandomAccessFile("AddressBook.dat", "rw");) {
    				if ((index + 1) * 90 < RandomFile.length()) {
    					index++;
    					fillField(RandomFile, firstField, lastField, cityField, provinceField, postalField);
    				}
    				else {
    					System.out.println("last one, can't go beyond");
    				}
    			}
    			catch (IOException ex) {}
	        });

	        // Event handling for the PREVIOUS button is pressed
	        previousButton.setOnAction( e -> {
	        	try (RandomAccessFile RandomFile = new RandomAccessFile("AddressBook.dat", "rw");) {
    				if (index > 0) {
    					index--;
    					fillField(RandomFile, firstField, lastField, cityField, provinceField, postalField);
    				}
    				else {
    					System.out.println("first one, can't go beyond");
    				}
    			}
    			catch (IOException ex) {}
	        });

	        // Event handling for the last button is pressed
	        lastButton.setOnAction( e -> {
	        	try (RandomAccessFile RandomFile = new RandomAccessFile("AddressBook.dat", "rw");) {
    				if (RandomFile.length() > 0) {
    					index = (int) ((RandomFile.length()/90) - 1);
    					fillField(RandomFile, firstField, lastField, cityField, provinceField, postalField);
    				}
    				else {
    					System.out.println("no address");
    				}
    			}
    			catch (IOException ex) {}
	        });

	        // Event handling for the update button is pressed
	        updateButton.setOnAction( e -> {
	        	try ( // Create a random access file
	    				RandomAccessFile RandomFile = 
	    					new RandomAccessFile("AddressBook.dat", "rw");
	    			) {
	    			 	RandomFile.seek(index * 90);
	    			 	RandomFile.write(setLength(firstField.getText().getBytes(), 30));
	    				RandomFile.write(setLength(lastField.getText().getBytes(), 30));
	    				RandomFile.write(setLength(cityField.getText().getBytes(), 20));
	    				RandomFile.write(setLength(provinceField.getValue().getBytes(), 3));
	    				RandomFile.write(setLength(postalField.getText().getBytes(), 7));
	    				System.out.println("updated address #" + index);
	    			}
	    			catch (FileNotFoundException ex) {}
	    			catch (IOException ex) {}
	        });
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void fillField(RandomAccessFile RandomFile, TextField firstField, TextField lastField, TextField cityField,
			ChoiceBox<String> provinceField, TextField postalField) throws IOException {
		RandomFile.seek(index * 90);
		
		byte[] firstHolder = new byte[30];	
		RandomFile.read(firstHolder);
		firstField.setText(new String(firstHolder));

		byte[] lastHolder = new byte[30];	
		RandomFile.read(lastHolder);
		lastField.setText(new String(lastHolder));

		byte[] cityHolder = new byte[20];	
		RandomFile.read(cityHolder);
		cityField.setText(new String(cityHolder));

		byte[] provinceHolder = new byte[3];	
		RandomFile.read(provinceHolder);
		provinceField.setValue(new String(provinceHolder));

		byte[] postalHolder = new byte[7];	
		RandomFile.read(postalHolder);
		postalField.setText(new String(postalHolder));
		System.out.println("read address #" + index);
	}

	private byte[] setLength(byte[] target, int length) {
		byte[] result = new byte[length];
		for (int i = 0; i < target.length; i++) {
			result[i] = target[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
