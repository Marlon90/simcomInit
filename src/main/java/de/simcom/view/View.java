package de.simcom.view;

import de.simcom.view.games.wargamerd.viewStage.NationView;
import de.simcom.view.viewStage.ViewStage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class View extends Application {

	public static Button newStageButton(String name, boolean close, ViewStage viewStage) {
		Button start = new Button(name);
		start.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!close) {
					Stage primaryStage = (Stage) start.getScene().getWindow();
					primaryStage.close();
					viewStage.setViewStage();
					Stage view = viewStage.getViewStage();

					// view.setOnHidden(e -> primaryStage.show());
					view.setMaximized(true);
					view.show();

				} else {
					Stage primaryStage = (Stage) start.getScene().getWindow();
					primaryStage.close();
				}

			}
		});
		return start;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		HBox middleBox = new HBox();

		middleBox.getChildren().add(newStageButton("Start", false, new SelectionView()));
		middleBox.getChildren().add(newStageButton("Options", false, new OptionView()));
		middleBox.getChildren().add(newStageButton("Exit", true, null));

		middleBox.setAlignment(Pos.CENTER);
		root.setCenter(middleBox);

		primaryStage.setMaximized(true);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

}
