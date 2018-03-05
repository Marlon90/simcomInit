package de.simcom;

import java.sql.SQLException;

import de.simcom.view.View;
import de.simcom.view.games.wargamerd.dao.impl.ElementDaoImpl;
import de.simcom.view.games.wargamerd.models.unit.Unit;
import javafx.application.Application;

public class App {
	public String test = "test";

	public static void main(String[] args) throws SQLException {
		/*
		 * Tank a1 = new M1Abrams(); Tank a2 = new M1Abrams(); AttackMove attack = new
		 * AttackMove(a1, a2); attack.attack();
		 */

		ElementDaoImpl dao = new ElementDaoImpl();

		Unit unit = dao.get("M1 Abrams");
		System.out.println(unit.getName() + " " + unit.getAirDetection() + " " + unit.getArmor() + " "
				+ unit.getAmphibiousSpeed() + " " + unit.getTraining() + " " + unit.getCards());

		Application.launch(View.class, args);

	}
}
