package com.skilldistillery.cards;

public class Dealer extends Player {
	protected Deck deck;

	// public void testing diplay cards 0-5
	public void shuffleTest() {
		System.out.println("Deck createDeck size: " + deck.deckSize());
		for (int i = 0; i < 52; i++) {
			System.out.println(deck.dealCard());
		}
		System.out.println("Deck createDeck size: " + deck.deckSize());

	}

	public void setUpGame() {
		getDeck();
		shuffleDeck();
//		NESTED REMOVE TEST TO SEE IF REMVOVES CARD AT ELEMENT 0
		// deck.getDeck().remove(0);
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

	// asks player to hit or stand
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
//		if(player.hand.getHandValue() >= 17 && player.hand.inHand.size() >= 2) {
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

}
