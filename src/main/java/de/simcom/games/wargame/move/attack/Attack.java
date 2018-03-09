package de.simcom.games.wargame.move.attack;

import de.simcom.games.wargame.models.unit.Unit;
import de.simcom.games.wargame.move.Move;

public interface Attack extends Move {

	void setAttacker(Unit element);

	void setTarget(Unit element);

	void attack();
	
	Unit getAttacker();

	Unit getTarget();

}
