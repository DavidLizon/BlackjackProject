package com.skilldistillery.cards;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp gaming = new BlackJackApp();
		gaming.run();
	}

	private void run() {

		Dealer dealer = new Dealer();
		Player player = new Player();

		dealer.runGame();
		
		
		dealer.cardToPlayer(player);	// player first card
//		System.out.println("PLAYER HAND:");
//		player.showHand();	// player shows card
//		System.out.println();
		dealer.cardToPlayer(dealer);	// dealer first card
//		System.out.print("DEALER HAND: ");
		
		dealer.cardToPlayer(player);	// player second card
		System.out.println("PLAYER HAND:");
		player.showHand();	// player shows both cards
		player.displayTotalHandValue();		// player displays total value of cards
		
		System.out.println();
		dealer.cardToPlayer(dealer);	// dealer second card
		System.out.println("DEALER HAND:");
		dealer.showTopCardDealer();
	}

}
