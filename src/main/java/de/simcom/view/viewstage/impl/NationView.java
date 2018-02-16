package de.simcom.view.viewstage.impl;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.simcom.controller.NationController;
import de.simcom.controller.impl.NationControllerImpl;
import de.simcom.models.unit.Unit;
import de.simcom.view.viewstage.ViewStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class NationView implements ViewStage {

    private Stage view;
    NationController nationController = new NationControllerImpl();

    private LineChart<?, ?> getChartList(String weapon, int maxRangeG, int maxRangeH, int maxRangeP) {
	ObservableList<String> e = FXCollections.observableArrayList();
	e.add("Ground");
	e.add("Helicopter");
	e.add("Plane");
	List<Integer> list = new ArrayList<Integer>();
	Collections.addAll(list, maxRangeG, maxRangeH, maxRangeP);

	int maxRange = 0;
	if (maxRangeG == maxRangeH && maxRangeG == maxRangeP) {
	    maxRange = maxRangeG;
	} else {
	    maxRange = maxRangeG;
	    for (int i : list) {
		if (maxRange < i)
		    maxRange = i;
	    }
	}

	final CategoryAxis yAxis = new CategoryAxis(e);
	final NumberAxis xAxis = new NumberAxis(0.0, maxRange, maxRange / 10);
	final LineChart<Number, String> lineChart = new LineChart<Number, String>(xAxis, yAxis);

	lineChart.setTitle("Range Monitor \n" + weapon);

	xAxis.setLabel("Range");

	XYChart.Series<Number, String> ground = new XYChart.Series<Number, String>();
	ground.getData().add(new XYChart.Data<Number, String>(0, "Ground"));
	ground.getData().add(new XYChart.Data<Number, String>(maxRangeG, "Ground"));
	ground.setName("GR: " + Integer.toString(maxRangeG));

	XYChart.Series<Number, String> helicopter = new XYChart.Series<Number, String>();
	helicopter.getData().add(new XYChart.Data<Number, String>(0, "Helicopter"));
	helicopter.getData().add(new XYChart.Data<Number, String>(maxRangeH, "Helicopter"));
	helicopter.setName("HL: " + Integer.toString(maxRangeH));

	XYChart.Series<Number, String> plane = new XYChart.Series<Number, String>();
	plane.getData().add(new XYChart.Data<Number, String>(0, "Plane"));
	plane.getData().add(new XYChart.Data<Number, String>(maxRangeP, "Plane"));
	plane.setName("PL: " + Integer.toString(maxRangeP));

	lineChart.getData().add(ground);
	lineChart.getData().add(helicopter);
	lineChart.getData().add(plane);

	// lineChart.setLegendVisible(false);

	lineChart.setMinWidth(200);
	lineChart.setMaxWidth(900);
	lineChart.setMinHeight(300);
	lineChart.setMaxHeight(300);

	return lineChart;
    }

    // Create and configure table list //
    private ObservableList<TableColumn<?, ?>> getTableColumnList() {
	ObservableList<TableColumn<?, ?>> list = FXCollections.observableArrayList();

	TableColumn<Unit, Integer> name = new TableColumn<Unit, Integer>("Name");
	name.setMinWidth(100);
	TableColumn<Unit, String> weaponStats = new TableColumn<Unit, String>("Weapons");
	weaponStats.setMinWidth(100);
	TableColumn<Unit, Integer> armor = new TableColumn<Unit, Integer>("Armor");
	armor.setMinWidth(100);

	list.add(name);
	list.add(weaponStats);
	list.add(armor);

	return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setViewStage() {
	view = new Stage();

	BorderPane root = new BorderPane();
	VBox outerVBox = new VBox();
	HBox innerHBoxBlue = new HBox(), innerHBoxRed = new HBox(), innerHBoxTmtic = new HBox();
	innerHBoxBlue.setSpacing(5.0);
	innerHBoxRed.setSpacing(5.0);

	for (int i = 1; i < 22; i++) {

	    URL url = NationView.class.getResource("resources/" + i + ".png");
	    Image img = new Image(url.toString());
	    ImageView iv = new ImageView(img);
	    iv.setId(String.valueOf(i));
	    iv.setOnMouseClicked(new EventHandler<Event>() {

		@Override
		public void handle(Event event) {
		    try {
			System.out.println(nationController.getName(Integer.parseInt(iv.getId())));
		    } catch (NumberFormatException e) {
			e.printStackTrace();
		    } catch (SQLException e) {
			e.printStackTrace();
		    }
		}
	    });
	    if (i > 14) {
		innerHBoxBlue.getChildren().add(iv);
	    } else {
		innerHBoxRed.getChildren().add(iv);
	    }
	}

	innerHBoxBlue.setAlignment(Pos.CENTER);
	innerHBoxRed.setAlignment(Pos.CENTER);

	ObservableList<Button> bList = FXCollections.observableArrayList();
	bList.addAll(new Button("All"), new Button("Logistic"), new Button("Infantry"), new Button("Support"),
		new Button("Tank"), new Button("Recon"), new Button("Vehicle"), new Button("Helicopter"),
		new Button("Plane"), new Button("Navy"));

	for (int j = 0; j < bList.size(); j++) {
	    innerHBoxTmtic.getChildren().add(bList.get(j));
	}
	innerHBoxTmtic.setAlignment(Pos.CENTER);

	TableView<Unit> tv = new TableView<Unit>();
	for (TableColumn<?, ?> object : getTableColumnList()) {
	    tv.getColumns().add((TableColumn<Unit, ?>) object);
	}

	outerVBox.setSpacing(10.0);
	outerVBox.getChildren().add(innerHBoxRed);
	outerVBox.getChildren().add(innerHBoxBlue);
	outerVBox.getChildren().add(innerHBoxTmtic);
	outerVBox.getChildren().add(tv);

	HBox charts = new HBox();
	charts.setAlignment(Pos.CENTER);
	charts.getChildren().add(getChartList("M-16A4", 800, 1200, 1200));
	charts.getChildren().add(getChartList("M-4", 800, 1200, 1200));
	charts.getChildren().add(getChartList("M249 SAW", 800, 1200, 1200));

	outerVBox.getChildren().add(charts);
	
	PhongMaterial material = new PhongMaterial();
	
	material.setDiffuseColor(Color.AQUAMARINE);
	material.setSpecularColor(Color.BLACK);
	

	Sphere sphere = new Sphere(100);
	sphere.setMaterial(material);
	
	outerVBox.getChildren().add(sphere);

	outerVBox.setAlignment(Pos.TOP_CENTER);
	root.setCenter(outerVBox);
	view.setScene(new Scene(root));

    }

    @Override
    public Stage getViewStage() {
	return view;
    }

}
