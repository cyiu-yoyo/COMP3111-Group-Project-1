//package comp3111.popnames;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.testfx.assertions.api.Assertions;
//import org.testfx.framework.junit.ApplicationTest;
//
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import javafx.fxml.FXMLLoader;
//
//public class JavaFXTest extends ApplicationTest {
//
//	private Scene s;
//	private TextArea t;
//	
//	@Override
//	public void start(Stage stage) throws Exception {
//    	FXMLLoader loader = new FXMLLoader();
//    	loader.setLocation(getClass().getResource("/ui.fxml"));
//   		VBox root = (VBox) loader.load();
//   		Scene scene =  new Scene(root);
//   		stage.setScene(scene);
//   		stage.setTitle("Popular Names");
//   		stage.show();
//   		s = scene;
//		t = (TextArea)s.lookup("#textAreaConsole");
//	}
//
//    
//	@Test
//	public void testButtonRankTrue() {	
//		//clickOn("#tabTaskZero");
//		clickOn("#buttonRankM");
//		//sleep(1000);
//		String s1 = t.getText();
//		clickOn("#buttonRankM");
//		//sleep(1000);
//		String s2 = t.getText();
//		assertTrue(s1.equals(s2));
//	}
//	
//	
////	@Test
////	public void testButtonRankFalse() {	
////		//clickOn("#tabTaskZero");
////		clickOn("#buttonRankM");
////		//sleep(1000);
////		String s1 = t.getText();
////		clickOn("#buttonRankF");
////		//sleep(1000);
////		String s2 = t.getText();
////		assertFalse(s1.equals(s2));
////	}
//	
//	
//	@Test
//	public void testTextAreaConsole() {	
//		t.setText("David");
//		String s = t.getText();
//		assertTrue(s.equals("David"));
//	}
//		
//}
package comp3111.popnames;

import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class JavaFXTest extends ApplicationTest {

	private Scene s;
	private TextArea t;
	private TextField t1;
	private TextField t2;
	private TextField task1y1;
	private TextField task1y2;
	private TextField task1TopNum;
	
	@Override
	public void start(Stage stage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));
   		VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("Popular Names");
   		stage.show();
   		s = scene;
		t = (TextArea)s.lookup("#textAreaConsole");
		t1 = (TextField)s.lookup("#textfieldNameM");
		t2 = (TextField)s.lookup("#textfieldNameF");
		task1y1 = (TextField)s.lookup("#task1y1");
		task1y2 = (TextField)s.lookup("#task1y2");
		task1TopNum = (TextField)s.lookup("#task1TopNum");
	}

    
	@Test
	public void testButtonRankTrue() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonRankM");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	@Test
	public void testButtonRankTrue2() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankF");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonRankF");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
//	@Test
//	public void testButtonRankM() {	
//		//clickOn("#tabTaskZero");
//		t1.setText("");
//		clickOn("#buttonRankM");
//		//sleep(1000);
//		String s1 = t.getText();
//		String s2 = "The name  (male) has not been ranked in the year 2019.\n";
//		assertTrue(s1.equals(s2));
//	}
//	@Test
//	public void testButtonRankF() {	
//		//clickOn("#tabTaskZero");
//		t2.setText("");
//		clickOn("#buttonRankF");
//		//sleep(1000);
//		String s1 = t.getText();
//		String s2 = "The name  (female) has not been ranked in the year 2019.\n";
//		assertTrue(s1.equals(s2));
//	}
	@Test
	public void testTask1InvalidPeriod() {	
		//clickOn("#tabTaskZero");
		task1y1.setText("1940");
		task1y2.setText("1951");
		task1TopNum.setText("");
		clickOn("#task1male");
		clickOn("#buttonTask1");
		//sleep(1000);
		String s1 = t.getText();
		String s2 = "Something is missed and please ensure you have finished your input!";
		assertEquals(s1,"Something is missed and please ensure you have finished your input!");
	}
	@Test
	public void testTask1withSpace() {	
		//clickOn("#tabTaskZero");
		task1y1.setText("1940");
		task1y2.setText("1951");
		task1TopNum.setText("2 2");
		clickOn("#task1male");
		clickOn("#buttonTask1");
		//sleep(1000);
		String s1 = t.getText();
		String s2 = "There should not be any spaces in your input and please ensure you have typed correctly!";
		assertTrue(s1.equals(s2));
	}
	@Test
	public void testTask1withFloat() {	
		//clickOn("#tabTaskZero");
		task1y1.setText("1940.2");
		task1y2.setText("1951.1");
		task1TopNum.setText("2.2");
		clickOn("#task1male");
		clickOn("#buttonTask1");
		//sleep(1000);
		String s1 = t.getText();
		String s2 = "The parameter Top N is a float which is not allowed! Please type again! \n";
		s2 += "The parameter year1 is a float which is not allowed! Please type again! \n";
		s2 += "The parameter year2 is a float which is not allowed! Please type again! \n";
		assertTrue(s1.equals(s2));
	}
//	@Test
//	public void testButtonRankFalse() {	
//		//clickOn("#tabTaskZero");
//		clickOn("#buttonRankM");
//		//sleep(1000);
//		String s1 = t.getText();
//		clickOn("#buttonRankF");
//		//sleep(1000);
//		String s2 = t.getText();
//		assertFalse(s1.equals(s2));
//	}
	
	
	@Test
	public void testTextAreaConsole() {	
		t.setText("David");
		String s = t.getText();
		assertTrue(s.equals("David"));
	}
		
}
