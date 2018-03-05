package de.simcom.view.games.arma.viewStage;

import de.simcom.view.viewStage.ViewStage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RequestView implements ViewStage {

	private Stage stage;

	@Override
	public void setViewStage() {
		stage = new Stage();
		BorderPane root = new BorderPane();
		HBox box = new HBox();
		TextArea ta = new TextArea();
		ta.setMaxHeight(20);
		ta.setMaxWidth(150);

		box.getChildren().add(ta);
		box.setAlignment(Pos.CENTER);
		root.setCenter(ta);
		stage.setScene(new Scene(root));

	}

	@Override
	public Stage getViewStage() {
		return stage;
	}

}
