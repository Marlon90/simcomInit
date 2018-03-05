package de.simcom.view.games.wargamerd.models;

public class Distances {

    // AP0, AP1, AP2, AP3, AP4, AP5,AP6,AP7,AP8,AP9,AP10,AP11,AP12;

    public int getDamage(int distance, int maxDistance) {
	if (distance == maxDistance) {
	    return 1;
	}
	if (distance < maxDistance - 175 * 1) {

	}
	int counter = 0;
	for (int i = maxDistance; i != distance; i--) {
	    counter++;
	}
	return (counter / 175);
    }
}
