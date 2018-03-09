package de.simcom.games.wargame.models.weapons;

import de.simcom.games.wargame.models.Element;
import de.simcom.games.wargame.models.ammo.Ammunition;

public interface Weapon extends Element {

	Ammunition getAmmo();
	int getRange();
	int getDamage();
}
