package de.simcom.view.games.wargamerd.physics;

import java.util.Map;

import javafx.scene.SubScene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class Calculator {
	private double mousePosX, mousePosY;
	private double mouseOldX, mouseOldY;


	private double calculateAPDamage(double ap, double armor, double damageBoni) {

		return ((((((double) ap - armor) / 2) + 1 + damageBoni) <= 0.99) ? 0.0
				: ((((double) ap - armor) / 2) + 1 + damageBoni));
	}

	public void armorMonitorCalculator(Map<String, Integer> map, SubScene subScene, MouseEvent me, TextArea arD, Box box,
			PhongMaterial material, Slider slider, Slider slider2, Slider slider3, Rotate rotateX, Rotate rotateY) {
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

		/*double damage = ((((((double) Integer.valueOf(ap) - armor) / 2) + 1 + damageBoni) <= 0.99) ? 0.0
				: ((((double) Integer.valueOf(ap) - armor) / 2) + 1 + damageBoni));*/
		double damage = calculateAPDamage(Integer.valueOf(ap), armor, damageBoni);

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
}
