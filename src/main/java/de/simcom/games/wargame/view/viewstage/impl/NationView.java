package de.simcom.games.wargame.view.viewstage.impl;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.simcom.games.wargame.controller.NationController;
import de.simcom.games.wargame.controller.impl.NationControllerImpl;
import de.simcom.games.wargame.models.unit.Unit;
import de.simcom.games.wargame.view.viewstage.ViewStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class NationView implements ViewStage {

    private double mousePosX, mousePosY;
    private double mouseOldX, mouseOldY;
    private final Rotate rotateX = new Rotate(-20, Rotate.X_AXIS);
    private final Rotate rotateY = new Rotate(-20, Rotate.Y_AXIS);
    private Stage view;
    NationController nationController = new NationControllerImpl();

    private HBox rangeMonitor(Map<Integer, String> data) {

	HBox charts = getHBox(Pos.CENTER, 0);

	charts.getChildren().add(getChartList(data.get(0), Integer.valueOf((data.get(1))), Integer.valueOf(data.get(2)),
		Integer.valueOf(data.get(3))));
	charts.getChildren().add(getChartList(data.get(4), Integer.valueOf((data.get(5))), Integer.valueOf(data.get(6)),
		Integer.valueOf(data.get(7))));
	charts.getChildren().add(getChartList(data.get(8), Integer.valueOf((data.get(9))),
		Integer.valueOf(data.get(10)), Integer.valueOf(data.get(11))));

	return charts;
    }

    private void armorCalculator(Map<String, Integer> map, SubScene subScene, MouseEvent me, TextArea arD, Box box,
	    PhongMaterial material, Slider slider, Slider slider2, Slider slider3) {
	// ((AP Power - Target Armour Value)/2)+1

	mousePosX = me.getSceneX();
	mousePosY = me.getSceneY();
	rotateX.setAngle(rotateX.getAngle() - (mousePosY - mouseOldY) * 4);
	rotateY.setAngle(rotateY.getAngle() + (mousePosX - mouseOldX) * 4);
	mouseOldX = mousePosX;
	mouseOldY = mousePosY;

	int distance = map.get("distance");
	// int armor = map.get("armor");
	int armor = (int) slider3.getValue();
	String ap = (slider2.getValue() <= 0) ? "0" : Integer.toString((int) slider2.getValue());
	double damageBoni = 0;
	int actualDistance = (int) slider.getValue();

	int counter = 0;
	for (int i = distance; i != actualDistance; i--) {
	    counter++;
	}
	damageBoni = counter / 175;

	double damage = ((((((double) Integer.valueOf(ap) - armor) / 2) + 1 + damageBoni) <= 0.99) ? 0.0
		: ((((double) Integer.valueOf(ap) - armor) / 2) + 1 + damageBoni));

	String castedDamage = (damage <= 0) ? "INEFFICIENT" : String.valueOf((int) (damage));
	if (!(castedDamage.equals("INEFFICIENT"))) {

	    if (damage <= 0) {
		rotateX.setAngle(0);
		material.setDiffuseColor(Color.RED);
		box.setMaterial(material);
	    } else {

		if (damage > 0 && damage <= 3) {
		    material.setDiffuseColor(Color.ORANGE);
		    box.setMaterial(material);
		}
		if (damage >= 4) {
		    material.setDiffuseColor(Color.GREEN);
		    box.setMaterial(material);
		}
	    }
	} else {
	    material.setDiffuseColor(Color.RED);
	    box.setMaterial(material);
	}

	rotateX.setAngle(slider2.getValue());
	rotateY.setAngle(slider.getValue() / 100);

	arD.setText("Armor Piercing Value (AP): " + ap + "\nArmor: " + (int) armor + "\nDamage Value: " + castedDamage);
    }

    private HBox getArmorMonitor(Camera camera) {
	HBox armorMonitor = new HBox();

	TextArea arD = new TextArea();
	arD.setMaxHeight(80);
	arD.setMaxWidth(200);
	arD.setEditable(false);
	TextArea distanceLog = new TextArea();
	distanceLog.setMaxWidth(200);
	distanceLog.setMaxHeight(40);
	distanceLog.setOnMouseClicked(new EventHandler<Event>() {

	    @Override
	    public void handle(Event event) {
		distanceLog.clear();

	    }
	});

	List<Slider> sliders = new ArrayList<Slider>();
	Collections.addAll(sliders, new Slider(), new Slider(), new Slider());

	for (Slider slider : sliders) {
	    switch (sliders.indexOf(slider)) {
	    case 0: {
		slider.setMin(1);
		slider.setMax(2275);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(999);
		break;
	    }
	    case 1: {
		slider.setMin(0);
		slider.setMax(30);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(2);
		slider.setOrientation(Orientation.VERTICAL);
		break;
	    }
	    case 2: {
		slider.setMin(0);
		slider.setMax(50);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(2);
		break;
	    }
	    }

	}

	camera.getTransforms().addAll(rotateX, rotateY, new Translate(0, 0, -20));

	Box box = new Box(1, 1, 1);
	box.setMaterial(new PhongMaterial(Color.GREENYELLOW));
	PhongMaterial material = new PhongMaterial();
	material.setDiffuseColor(Color.ORANGE);
	material.setSpecularColor(Color.BLACK);
	box.setMaterial(material);

	Group root3D = new Group(camera, box);
	SubScene subScene = new SubScene(root3D, 300, 300, true, SceneAntialiasing.BALANCED);
	subScene.setFill(Color.BLACK);
	subScene.setCamera(camera);
	rotateX.setAngle(0);
	rotateY.setAngle(0);

	subScene.setOnMousePressed((MouseEvent me) -> {
	    mouseOldX = me.getSceneX();
	    mouseOldY = me.getSceneY();
	});

	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("distance", 2275);
	map.put("armor", 20);
	subScene.setOnMouseDragged((MouseEvent me) -> {
	    armorCalculator(map, subScene, me, arD, box, material, sliders.get(0), sliders.get(1), sliders.get(2));
	});

	for (Slider slider : sliders) {
	    slider.setOnMouseClicked((MouseEvent me) -> {
		distanceLog.setText("Distance: " + (int) sliders.get(0).getValue());
		armorCalculator(map, subScene, me, arD, box, material, sliders.get(0), sliders.get(1), sliders.get(2));
	    });
	    slider.setOnMouseDragged((MouseEvent me) -> {
		distanceLog.setText("Distance: " + (int) sliders.get(0).getValue());
		armorCalculator(map, subScene, me, arD, box, material, sliders.get(0), sliders.get(1), sliders.get(2));
	    });
	}

	VBox vMain = getVBox(Pos.TOP_LEFT, 0);
	HBox holder = getHBox(Pos.TOP_LEFT, 0);
	VBox subHolder = getVBox(Pos.TOP_LEFT, 0);
	HBox holder2 = getHBox(Pos.TOP_LEFT, 0);
	subHolder.getChildren().addAll(sliders.get(0), sliders.get(2));
	holder.getChildren().addAll(arD, subHolder);

	Button getValue = new Button("Get Value");
	getValue.setOnAction(new EventHandler<ActionEvent>() {

	    @Override
	    public void handle(ActionEvent event) {
		boolean isDigit = distanceLog.getText().matches("-?\\d+(\\.\\d+)?");
		if (isDigit) {
		    Integer customNumber = Integer.valueOf(distanceLog.getText());
		    if (!(customNumber < 1) && !(customNumber > 2275) && !(customNumber == null)) {
			sliders.get(0).setValue(customNumber);

		    }
		} else {
		    distanceLog.setText("Invalid value");
		}
	    }

	});
	holder2.getChildren().addAll(distanceLog, getValue);
	vMain.getChildren().addAll(holder, holder2);
	armorMonitor.getChildren().addAll(sliders.get(1), subScene, vMain);

	return armorMonitor;
    }

    private HBox dynamicContent(Button button, HBox dynamicBox, Object newContent) {

	button.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent e) {
		dynamicBox.getChildren().clear();
		dynamicBox.getChildren().add((Node) newContent);
	    }
	});

	return dynamicBox;

    }

    private Button createButton(String name, int size) {
	Button b = new Button(name);

	b.setMinWidth(size);
	b.setMaxWidth(size);

	return b;
    }

    private LineChart<?, ?> getChartList(String weapon, int maxRangeG, int maxRangeH, int maxRangeP) {
	ObservableList<String> e = FXCollections.observableArrayList();
	e.add("Plane");
	e.add("Helicopter");
	e.add("Ground");

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

	lineChart.setTitle(weapon);
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

	VBox mainOptions = getVBox(Pos.CENTER, 10);

	HBox buttons = getHBox(Pos.CENTER, 10);

	buttons.getChildren().addAll(createButton("Range Monitor", 110), createButton("Armor Monitor", 110));
	mainOptions.getChildren().add(buttons);
	HBox dynamicContent = getHBox(Pos.CENTER, 10);

	mainOptions.getChildren().add(dynamicContent);

	// Test data
	Map<Integer, String> data = new HashMap<Integer, String>();
	data.put(0, "M4");
	data.put(1, "150");
	data.put(2, "2600");
	data.put(3, "0");
	data.put(4, "m16");
	data.put(5, "144");
	data.put(6, "144");
	data.put(7, "144");
	data.put(8, "saw");
	data.put(9, "144");
	data.put(10, "144");
	data.put(11, "144");

	Camera camera = new PerspectiveCamera(true);
	dynamicContent((Button) buttons.getChildren().get(0), dynamicContent, rangeMonitor(data));
	dynamicContent((Button) buttons.getChildren().get(1), dynamicContent, getArmorMonitor(camera));
	// outerVBox.getChildren().add(rangeMonitor(dynamicContent, data));
	outerVBox.getChildren().addAll(mainOptions);
	outerVBox.setAlignment(Pos.TOP_CENTER);
	root.setCenter(outerVBox);

	view.setScene(new Scene(root));

    }

    private HBox getHBox(Pos pos, double spacing) {
	HBox hBox = new HBox();
	hBox.setAlignment(pos);
	hBox.setSpacing(spacing);
	return hBox;
    }

    private VBox getVBox(Pos pos, double spacing) {
	VBox vBox = new VBox();
	vBox.setAlignment(pos);
	vBox.setSpacing(spacing);
	return vBox;
    }

    @Override
    public Stage getViewStage() {
	return view;
    }

}
