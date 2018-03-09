package de.simcom.games.wargame.view.viewstage.impl;

import de.simcom.games.wargame.view.viewstage.ViewStage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FighterView implements ViewStage {
	
	private Stage view;

	@Override
	public void setViewStage() {
		view = new Stage();

		BorderPane root = new BorderPane();
		HBox middleBox = new HBox();
		Label options = new Label("Combat");

		middleBox.getChildren().add(options);
		middleBox.setAlignment(Pos.CENTER);

		root.setCenter(middleBox);

		view.setScene(new Scene(root));

	}

	@Override
	public Stage getViewStage() {
		return view;
	}

}
