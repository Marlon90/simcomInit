package de.simcom.models.unit.impl;

import de.simcom.models.Type;
import de.simcom.models.unit.Unit;

public class UnitImpl implements Unit {

	private int id;
	private String name;
	private int hp;
	private String size;
	private String optics;
	private String stealth;
	private int groundSpeed;
	private int amphibiousSpeed;
	private int autonomy;
	private int service;
	private int roadSpeed;
	private String armor;
	private int nationId;
	private int points;
	private int cards;
	private int transporterId;
	private String weaponId;
	private String airDetection;
	private int cat;
	private int thematic;
	private String training;
	private Type type;

	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public String getSize() {
		return size;
	}

	@Override
	public String getOptics() {
		return optics;
	}

	@Override
	public String getStealth() {
		return stealth;
	}

	@Override
	public int getGroundSpeed() {
		return groundSpeed;
	}

	@Override
	public int getAmphibiousSpeed() {
		return amphibiousSpeed;
	}

	@Override
	public int getAutonomy() {
		return autonomy;
	}

	@Override
	public int getService() {
		return service;
	}

	@Override
	public int getRoadSpeed() {
		return roadSpeed;
	}

	@Override
	public String getArmor() {
		return armor;
	}

	@Override
	public int getNationId() {
		return nationId;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public int getCards() {
		return cards;
	}

	@Override
	public int getTransporterId() {
		return transporterId;
	}

	@Override
	public String getWeaponId() {
		return weaponId;
	}

	@Override
	public String getAirDetection() {
		return airDetection;
	}

	@Override
	public int getCat() {
		return cat;
	}

	@Override
	public int getThematic() {
		return thematic;
	}

	@Override
	public String getTraining() {
		return training;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setOptics(String optics) {
		this.optics = optics;
	}

	public void setStealth(String stealth) {
		this.stealth = stealth;
	}

	public void setGroundSpeed(int groundSpeed) {
		this.groundSpeed = groundSpeed;
	}

	public void setAmphibiousSpeed(int amphibiousSpeed) {
		this.amphibiousSpeed = amphibiousSpeed;
	}

	public void setAutonomy(int autonomy) {
		this.autonomy = autonomy;
	}

	public void setService(int service) {
		this.service = service;
	}

	public void setRoadSpeed(int roadSpeed) {
		this.roadSpeed = roadSpeed;
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}

	public void setNationId(int nationId) {
		this.nationId = nationId;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setCards(int cards) {
		this.cards = cards;
	}

	public void setTransporterId(int transporterId) {
		this.transporterId = transporterId;
	}

	public void setWeaponId(String weaponId) {
		this.weaponId = weaponId;
	}

	public void setAirDetection(String airDetection) {
		this.airDetection = airDetection;
	}

	public void setCat(int cat) {
		this.cat = cat;
	}

	public void setThematic(int thematic) {
		this.thematic = thematic;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	@Override
	public Type getType() {
		return type;

	}

	@Override
	public void setType(String type) {

		switch (type) {
		case "air": {
			this.type = Type.AIR;
			break;
		}
		case "helicopter": {
			this.type = Type.HELICOPTER;
			break;
		}
		case "infantry": {
			this.type = Type.INFANTRY;
			break;
		}
		case "logistic": {
			this.type = Type.LOGISTIC;
			break;
		}
		case "naval": {
			this.type = Type.NAVAL;
			break;
		}
		case "supports": {
			this.type = Type.SUPPORTS;
			break;
		}
		case "tank": {
			this.type = Type.TANK;
			break;
		}
		case "transport": {
			this.type = Type.TRANSPORT;
			break;
		}
		case "vehicle": {
			this.type = Type.VEHICLE;
			break;
		}
		}

	}
}