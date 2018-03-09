package de.simcom.view;

import de.simcom.view.games.arma.viewStage.RequestView;
import de.simcom.view.games.wargamerd.viewStage.NationView;
import de.simcom.view.viewStage.ViewStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SelectionView implements ViewStage {

	private Stage stage;

	@Override
	public void setViewStage() {
		stage = new Stage();
		BorderPane root = new BorderPane();

		HBox hBox = new HBox();
		Button rd = new Button("Wargame: Red Dragon");

		rd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

			}

		});

		hBox.getChildren().addAll(View.newStageButton("Wargame: Red Dragon", false, new NationView()),
				View.newStageButton("Arma 3", false, new RequestView()));
		hBox.setAlignment(Pos.CENTER);
		root.setCenter(hBox);

		stage.setScene(new Scene(root));

	}

	@Override
	public Stage getViewStage() {
		return stage;
	}

}
