package com.skilldistillery.cards;

public class Dealer extends Player {
	Deck deck;

	// public void testing diplay cards 0-5
	public void shuffleTest() {
		System.out.println("Deck createDeck size: " + deck.deckSize());
		for (int i = 0; i < 52; i++) {
			System.out.println(deck.dealCard());
		}
		System.out.println("Deck createDeck size: " + deck.deckSize());

	}


//	public void runGame(Dealer dealer, Player player) {
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

//	public void showTopCardDealer() {
//		hand.showTopCard();
//	}

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
	
	// - if player over 21 say bust and end game
	public void handBusted21() {
		System.out.println("Bust");
	}

	// - if under 17 hit until 17 or over

	// compare dealer hand to player hand

	// - declare winner or tie

	// ask to play another hand
	public void anotherGame() {
		System.out.println("Want to play another game?");
	}

	// -

}
