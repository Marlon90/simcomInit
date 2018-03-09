package de.simcom.view.games.wargamerd.models.ammo;

import de.simcom.view.games.wargamerd.models.Element;

public interface Ammunition extends Element {

	boolean isHeat();
	boolean isAPFSD();
	int getSize();
	int getSplash();
}
