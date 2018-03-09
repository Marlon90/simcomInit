package de.simcom.view.games.wargamerd.move.attack;

import de.simcom.view.games.wargamerd.models.unit.Unit;
import de.simcom.view.games.wargamerd.move.Move;

public interface Attack extends Move {

	void setAttacker(Unit element);

	void setTarget(Unit element);

	void attack();
	
	Unit getAttacker();

	Unit getTarget();

}
