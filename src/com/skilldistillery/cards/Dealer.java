package com.skilldistillery.cards;

public class Dealer extends Player {
	protected Deck deck;

	public void setUpGame() {
		getDeck();
		shuffleDeck();
	}
	
	public void getDeck() {
		deck = new Deck();
	}

	public void shuffleDeck() {
		deck.shuffle();
	}

	public void cardToPlayer(Player player) {
		player.addCardToHand(deck.dealCard());
	}

	public void askPlayerHitOrStand() {
		System.out.println("Would you like to (1) hit or (2) stand?");
	}

	public boolean checkIfValueOver21(Player player) {
		boolean over21 = false;
		if(player.hand.getHandValue() > 21) {
			over21 = true;
		}
		return over21;
	}
	
	public boolean checkIfValueIsEqualToOrOver17(Player player) {
		boolean seventeenPlus = false;
		if(player.hand.getHandValue() >= 17) {
			seventeenPlus = true;
		}
		return seventeenPlus;
	}
	
	public boolean hasBlackjack(Player player) {
		boolean hasBlackjack = false;
		if(player.hand.getHandValue() == 21) {
			hasBlackjack = true;
		}
		return hasBlackjack;
	}
	
	public void handBusted21() {
		System.out.println("Bust");
	}

	public void anotherGame() {
		System.out.println("Want to play another game?");
	}

	@Override
	public String toString() {
		return "Dealer [deck=" + deck + "]";
	}

	
	
}
