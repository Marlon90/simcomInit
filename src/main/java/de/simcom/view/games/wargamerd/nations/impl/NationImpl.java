package de.simcom.view.games.wargamerd.nations.impl;

import de.simcom.view.games.wargamerd.nations.Nation;

public class NationImpl implements Nation {

	private String name;
	private int id;

	public NationImpl() {
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {

		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
