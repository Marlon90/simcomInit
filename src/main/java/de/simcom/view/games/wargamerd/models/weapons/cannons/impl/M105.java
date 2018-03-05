package de.simcom.view.games.wargamerd.models.weapons.cannons.impl;

import de.simcom.view.games.wargamerd.models.Type;
import de.simcom.view.games.wargamerd.models.ammo.shell.vehicleAmmo.VehicleAmmo;
import de.simcom.view.games.wargamerd.models.ammo.shell.vehicleAmmo.impl.M829A1;
import de.simcom.view.games.wargamerd.models.weapons.cannons.Cannon;

public class M105 implements Cannon {

	private String name;
	private VehicleAmmo ammo;
	private int range;
	private int damage;

	public M105() {
		this.name = "M105";
		this.ammo = new M829A1();
		this.range = 4000;
		this.damage = 10;
	}

	public int getRange() {
		return range;
	}

	public int getDamage() {

		return damage;
	}

	public void loadedHeat() {

	}

	public void loadedAPFSD() {

	}

	public VehicleAmmo getAmmo() {
		return ammo;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return Type.WEAPON;
	}

}
