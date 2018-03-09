package de.simcom.view.games.wargamerd.models.deck.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.simcom.view.games.wargamerd.models.Type;
import de.simcom.view.games.wargamerd.models.deck.Deck;
import de.simcom.view.games.wargamerd.models.unit.Unit;

public class DeckImpl implements Deck {

	private List<Unit> deck;
	private Map<Type, Boolean> check;
	private List<String> hints;

	public DeckImpl() {
		this.check = new HashMap<Type, Boolean>();
	}

	private void initializeChecker() {
		check = new HashMap<Type, Boolean>();
		check.put(Type.INFAA, false);
		check.put(Type.INFAT, false);
		check.put(Type.INFCO, false);
		check.put(Type.INFSHOCK, false);
		check.put(Type.INFLINE, false);
		check.put(Type.INFMILITIA, false);
		check.put(Type.LOGISTICAPC, false);
		check.put(Type.LOGISTICFOB, false);
		check.put(Type.LOGISTICHEAVYAIR, false);
		check.put(Type.LOGISTICHEAVYGROUND, false);
		check.put(Type.LOGISTICINF, false);
		check.put(Type.LOGISTICLIGHTAIR, false);
		check.put(Type.LOGISTICLIGHTGROUND, false);
		check.put(Type.LOGISTICLIGHTVEHICLE, false);
		check.put(Type.LOGISTICTANK, false);
		check.put(Type.SUPPORTAAGUN, false);
		check.put(Type.SUPPORTAAIR, false);
		check.put(Type.SUPPORTAASAM, false);
		check.put(Type.SUPPORTHEAVYARTY, false);
		check.put(Type.SUPPORTLIGHTARTY, false);
		check.put(Type.SUPPORTMORTAR, false);
		check.put(Type.TANKLIGHT, false);
		check.put(Type.TANKCAVALARY, false);
		check.put(Type.TANKMEDIUM, false);
		check.put(Type.TANKSUPER, false);
		check.put(Type.TANKHEAVY, false);

	}

	public void setDeck(List<Unit> units) {
		this.deck = units;
	}

	private void initializeHints() {
		hints = new ArrayList<String>();
	}

	public List<String> checkDeck(List<Type> intentions) {

		initializeHints();
		initializeChecker();
		for (Unit unit : deck) {
			check.put(unit.getType(), true);
		}

		check.forEach((k, v) -> {
			String[] section = k.toString().split(" ");
			if (v == false && intentions.contains(k))
				hints.add("In section " + section[0] + " " + k.getType() + " is missing.");
		});
		if (hints.size() == 0) {
			hints.clear();
			hints.add(0, "This deck has passed all tests and it will suit your needs");
		}
		return hints;
	}

	@SuppressWarnings("unused")
	private List<String> checkWeakSpot() {

		for (Unit unit : deck) {
			check.put(unit.getType(), true);
		}

		check.forEach((k, v) -> {
			if (v == false) {
				hints.add("Deck is lacking on " + k.getType());
			}
		});

		return hints;
	}
}