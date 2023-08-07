/* Group Members
1. Angela Tan - atan2026
2. Brian Xie - bxie12
3. Michelle Yu - myu1105
*/
package InterestCalculator;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;

public class InterestTableGUI extends Application {
	private TextField principal, rate;
	private Slider horizontalSlider;
	private TextArea displayArea;
	
	public void start(Stage primaryStage) {
		int sceneWidth = 500, sceneHeight = 350;
		int paneBorderTop = 20, paneBorderRight = 20;
		int paneBorderBottom = 20, paneBorderLeft = 20;
		//making display
		displayArea = new TextArea();
		displayArea.setEditable(false);
		displayArea.setWrapText(true);
		
		ScrollPane scrollPane = new ScrollPane(displayArea);
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(scrollPane);
		
		BorderPane centerPane = new BorderPane();
		FlowPane fieldsPane = new FlowPane();
		fieldsPane.setHgap(20);
		Label princLabel = new Label("Principal:");
		principal = new TextField();
		fieldsPane.getChildren().addAll(princLabel, principal);
		Label rateLabel = new Label("Rate(Percentage):");
		rate = new TextField();
		fieldsPane.getChildren().addAll(rateLabel, rate);
		centerPane.setTop(fieldsPane);
		horizontalSlider = new Slider();
		horizontalSlider.setMin(1);
		horizontalSlider.setMax(25);
		horizontalSlider.setMajorTickUnit(4);
		horizontalSlider.setShowTickMarks(true);
		horizontalSlider.setShowTickLabels(true);
		Label yearLabel = new Label("Number of Years:");
		centerPane.setCenter(yearLabel);
		centerPane.setBottom(horizontalSlider);
		borderPane.setCenter(centerPane);
		
		Button buttonSimple = new Button("SimpleInterest");
		Button buttonComp = new Button("CompoundInterest");
		Button buttonBoth = new Button("BothInterests");
		FlowPane computePane = new FlowPane();
		computePane.setHgap(20);
		computePane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
			    paneBorderBottom, paneBorderLeft));
		computePane.getChildren().addAll(buttonSimple);
		computePane.getChildren().addAll(buttonComp);
		computePane.getChildren().addAll(buttonBoth);
		borderPane.setBottom(computePane);
		
		buttonSimple.setOnAction(e -> 
			displayArea.setText(new Interest(Integer.parseInt(principal.getText()), Double.parseDouble(rate.getText()), (int)horizontalSlider.getValue()).computeSimple()));
		buttonComp.setOnAction(new ButtonHandler());
		buttonBoth.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String both = new Interest(Integer.parseInt(principal.getText()), Double.parseDouble(rate.getText()), (int)horizontalSlider.getValue()).computeBoth();
				displayArea.setText(both);
			}
		});
		
		Scene scene = new Scene(borderPane, sceneWidth, sceneHeight);
		primaryStage.setTitle("Interest Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			String compound = new Interest(Integer.parseInt(principal.getText()), Double.parseDouble(rate.getText()), (int)horizontalSlider.getValue()).computeCompound();
			displayArea.setText(compound);
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}