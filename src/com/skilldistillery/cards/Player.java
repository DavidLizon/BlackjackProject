package com.skilldistillery.cards;

public class Player {
	
	Hand hand = new Hand();
	
	Player() {}

	// add card to hand
	public void addCardToHand(Card card) {
		hand.addCard(card);
	}
	
	// displays hand
	public void showHand() {
		hand.showHand();
	}
	
	// displays hand value
	public void displayTotalHandValue() {
		System.out.print("Total: ");
		System.out.println(hand.getHandValue());
	}
	
}
