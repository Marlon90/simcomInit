package de.simcom.models.ammo;

import de.simcom.models.Element;

public interface Ammunition extends Element {

	boolean isHeat();
	boolean isAPFSD();
	int getSize();
	int getSplash();
}
