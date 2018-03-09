package de.simcom.games.wargame.models.ammo;

import de.simcom.games.wargame.models.Element;

public interface Ammunition extends Element {

	boolean isHeat();
	boolean isAPFSD();
	int getSize();
	int getSplash();
}
