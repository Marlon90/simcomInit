package de.simcom.view.games.wargamerd.models.weapons;

import de.simcom.view.games.wargamerd.models.Element;
import de.simcom.view.games.wargamerd.models.ammo.Ammunition;

public interface Weapon extends Element {

	Ammunition getAmmo();
	int getRange();
	int getDamage();
}
