package de.simcom.models.weapons;

import de.simcom.models.Element;
import de.simcom.models.ammo.Ammunition;

public interface Weapon extends Element {

	Ammunition getAmmo();
	int getRange();
	int getDamage();
}
