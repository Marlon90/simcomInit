package de.simcom.games.wargame.models.ammo.shell.vehicleAmmo.impl;

import de.simcom.games.wargame.models.Type;
import de.simcom.games.wargame.models.ammo.shell.vehicleAmmo.VehicleAmmo;

public class M829A1 implements VehicleAmmo {

	private String name;
	private boolean heat;
	private boolean ap;
	private int splash;
	private int size;

	public M829A1() {
		this.name = "M829A1";
		this.ap = true;
		this.heat = false;
		this.splash = 2;
		this.size = 5;
	}

	public boolean isHeat() {
		return heat;
	}

	public boolean isAPFSD() {
		return ap;

	}

	public int getSplash() {
		return splash;
	}

	public int getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return Type.AMMUNITION;
	}

}
