package de.simcom.view.games.wargamerd.models.unit;

import de.simcom.view.games.wargamerd.models.Element;
import de.simcom.view.games.wargamerd.models.Type;

public interface Unit extends Element {

	int getId();

	String getName();

	int getHp();

	String getSize();

	String getOptics();

	String getStealth();

	int getGroundSpeed();

	int getAmphibiousSpeed();

	int getAutonomy();

	int getService();

	int getRoadSpeed();

	String getArmor();

	int getNationId();

	int getPoints();

	int getCards();

	int getTransporterId();

	String getWeaponId();

	String getAirDetection();

	int getCat();

	int getThematic();

	String getTraining();

	public void setId(int id);

	public void setName(String name);

	public void setHp(int hp);

	public void setSize(String size);

	public void setOptics(String optics);

	public void setStealth(String stealth);

	public void setGroundSpeed(int groundSpeed);

	public void setAmphibiousSpeed(int amphibiousSpeed);

	public void setAutonomy(int autonomy);

	public void setService(int service);

	public void setRoadSpeed(int roadSpeed);

	public void setArmor(String armor);

	public void setNationId(int nationId);

	public void setPoints(int points);

	public void setCards(int cards);

	public void setTransporterId(int transporterId);

	public void setWeaponId(String weaponId);

	public void setAirDetection(String airDetection);

	public void setCat(int cat);

	public void setThematic(int thematic);

	public void setTraining(String training);

	Type getType();

	void setType(String type);
}
