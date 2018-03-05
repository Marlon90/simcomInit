package de.simcom.view.games.wargamerd.models;

public class Accuracy {

	private double morale;
	private int accuracy;
	private int rank;

	public Accuracy() {

	}

	public Accuracy(int morale, int accuracy, int rank) {
		super();
		this.morale = morale;
		this.accuracy = accuracy;
		this.rank = rank;
	}

	public void getAccuracy(int rof, int accuracy, int rank, double morale ) {
		this.morale = morale;
		this.accuracy = accuracy;
		this.rank = rank;
		
		System.out.println(accuracy + rank);
		//System.out.println(((accuracy * rank) + accuracy)  );
		
		//System.out.println((((accuracy * rank / 100) + accuracy) - (morale)));
		// System.out.println(range / accuracy / rank / morale);

	}
}
