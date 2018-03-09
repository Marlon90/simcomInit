package de.simcom;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

<<<<<<< HEAD
import de.simcom.games.arma.commandMachine.impl.CommandList;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
=======
import de.simcom.view.View;
import de.simcom.view.games.wargamerd.dao.impl.ElementDaoImpl;
import de.simcom.view.games.wargamerd.models.unit.Unit;
import javafx.application.Application;
>>>>>>> af58353c48547c3fbdf582b9a00fea0128cd8d58

public class App {
	public String test = "test";

<<<<<<< HEAD
    public static void main(String[] args) throws SQLException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
	/*
	 * Tank a1 = new M1Abrams(); Tank a2 = new M1Abrams(); AttackMove attack
	 * = new AttackMove(a1, a2); attack.attack();
	 */
=======
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
>>>>>>> af58353c48547c3fbdf582b9a00fea0128cd8d58

	// Application.launch(View.class, args);
	//Constructor c = new ConstructorImpl();
	//c.doStatement(new DataImpl(ControlStructurType.IF, "alive player", "hint 'test'"));
	
	CommandList cl = new CommandList();
	try {
	    cl.getCommands();
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
}
