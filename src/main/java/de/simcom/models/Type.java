package de.simcom.models;

public enum Type {
	
	WEAPON("Weapon"),
	AMMO("Ammo"),
	INFAA("Infantry Anti-Air"),
	INFAT("Infantry Anti-Tank"),
	INFLINE("Infantry Regular"),
	INFMILITIA("Infantry Militia"),
	INFCO("Infantry Elite"),
	INFSHOCK("Infantry Shock"),
	LOGISTICLIGHTGROUND("Logistic Light(Ground)"),
	LOGISTICHEAVYGROUND("Logistic Heavy (Ground"),
	LOGISTICLIGHTAIR("Logistic Light(Air)"),
	LOGISTICHEAVYAIR("Logistic Heavy (Air)"),
	LOGISTICLIGHTVEHICLE("Command Unit (Light Vehicle)"),
	LOGISTICAPC("Command Unit (Armored Transport Vehicle)"),
	LOGISTICTANK("Command Unit (Tank)"),
	LOGISTICINF("Command Unit (Infantry)"),
	LOGISTICFOB("FORWARD SUPPORT BASE"),
	SUPPORTAAGUN("Support Anti-Air (Gun)"),
	SUPPORTAASAM("Support Anti-Air (SAM"),
	SUPPORTAAIR("Support Anti-Air (IR)"),
	SUPPORTMORTAR("Support Mortar"),
	SUPPORTHEAVYARTY("Support Heavy Artillery"),
	SUPPORTLIGHTARTY("Support Light Artillery"),
	TANKCAVALARY("Tank (Cavalary)"),
	TANKLIGHT ("Tank (Light)"),
	TANKMEDIUM("Tank (Medium)"),
	TANKHEAVY("Tank (Heavy)"),
	TANKSUPER ("Tank (Super)"),
	;
	private String type;
	
	Type (String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
