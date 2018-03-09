package de.simcom.games.wargame.models.weapons.cannons;

import de.simcom.games.wargame.models.weapons.Weapon;

public interface Cannon extends Weapon {

	void loadedHeat();

	void loadedAPFSD();
}
