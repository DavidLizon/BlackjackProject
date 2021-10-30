package com.skilldistillery.cards;

import java.util.Scanner;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp gaming = new BlackJackApp();
		gaming.run();
	}

	private void run() {
		Scanner kb = new Scanner(System.in);
		Dealer dealer = new Dealer();
		Player player = new Player();

		int userChoice;
		boolean correctChoice = false;
		boolean keepPlaying = false;
		
		System.out.println("Welcome to the House of Spades.\nLet's play some blackjack!");

		
		do {
		dealer.setUpGame();

		int i = 0;
		while (i < 2) {
			dealer.cardToPlayer(player); // card to player
			dealer.cardToPlayer(dealer); // card to dealer
			System.out.println("PLAYER HAND:");
			player.showHand(); // player: shows hand
			System.out.println();
			i++;
		}
		
		player.displayTotalHandValue(); // player displays total value of cards
		System.out.println("DEALER HAND:");
		dealer.hand.showTopCard();

		dealer.askPlayerHitOrStand();
		userChoice = kb.nextInt();
		kb.nextLine();
		do  {
			if (userChoice == 1) {		//hit
				dealer.cardToPlayer(player); // card to player
				player.showHand(); // player: shows hand
				player.displayTotalHandValue();
				if(dealer.checkIfValueOver21(player) == true){
					dealer.handBusted21();
					break;
				}
				
				correctChoice = true;
			} else if (userChoice == 2) {	// stand

				correctChoice = true;
			} else {
				System.out.println("Please press 1 to hit or 2 to stand.");
			}
		} while (correctChoice != true && userChoice != 2 );
		
		
		keepPlaying = playAgain(kb, keepPlaying);

		player.hand.clearHand();
		dealer.hand.clearHand();
		
		}while (keepPlaying);

		// CODE WORKS FOR DEALING TWO CARDS TO PLAYER AND DEALER
//		dealer.cardToPlayer(player);	// player first card
//		dealer.cardToPlayer(dealer);	// dealer first card
//		
//		dealer.cardToPlayer(player);	// player second card
//		System.out.println("PLAYER HAND:");
//		player.showHand();	// player shows both cards
//		player.displayTotalHandValue();		// player displays total value of cards
//		
//		System.out.println();
//		dealer.cardToPlayer(dealer);	// dealer second card
//		System.out.println("DEALER HAND:");
//		dealer.showTopCardDealer();
		System.out.println("PROGRAM ENDED");
	}
	
	public boolean playAgain(Scanner kb, boolean keepPlaying) {
		System.out.println("\n\nPlay again, yes or no?");
		String userAnswer = kb.nextLine();
		if(userAnswer.equalsIgnoreCase("no")) {
			keepPlaying = false;
		} else if (userAnswer.equalsIgnoreCase("yes")) {
			keepPlaying = true;
		} 
		return keepPlaying;
	}
}
