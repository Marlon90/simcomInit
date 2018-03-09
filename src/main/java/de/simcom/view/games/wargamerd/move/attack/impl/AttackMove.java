package de.simcom.view.games.wargamerd.move.attack.impl;

import de.simcom.view.games.wargamerd.models.unit.Unit;
import de.simcom.view.games.wargamerd.move.attack.Attack;

public class AttackMove implements Attack {

	private Unit attacker;
	private Unit target;

	public AttackMove() {

	}

	public AttackMove(Unit attacker, Unit target) {
		this.attacker = attacker;
		this.target = target;
	}

	@Override
	public void setAttacker(Unit unit) {
		this.attacker = unit;
	}

	@Override
	public void setTarget(Unit unit) {
		this.target = unit;

	}

	@Override
	public Unit getAttacker() {
		return attacker;
	}

	@Override
	public Unit getTarget() {
		return target;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void attack() {
		double random = Math.random() * 10;
		int chance = (int) random;
		if (chance < attacker.getAccuracy()) {
			System.out.println(target.getName() + " has been destroyed");
		}
		target.setDestroyed(true);

	}*/

}
