package de.simcom.move.attack;

import de.simcom.models.unit.Unit;
import de.simcom.move.Move;

public interface Attack extends Move {

	void setAttacker(Unit element);

	void setTarget(Unit element);

	void attack();
	
	Unit getAttacker();

	Unit getTarget();

}
