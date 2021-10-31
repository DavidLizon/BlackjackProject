package com.skilldistillery.cards;

public class Player {
	
	protected Hand hand = new Hand();
	
	Player() {}

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}
	
	public void showHand() {
		hand.showHand();
	}
	
	public void displayTotalHandValue() {
		System.out.print(" Total: ");
		System.out.println(hand.getHandValue());
	}
	
}
