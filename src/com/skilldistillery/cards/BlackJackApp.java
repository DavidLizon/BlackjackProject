package com.skilldistillery.cards;

import java.util.InputMismatchException;
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

		int userChoice = 0;
		boolean correctChoice = false;
		boolean keepPlaying = false;
		boolean gotValidInput = false;
		boolean dealerBust = false;
		boolean playerBust = false;

		System.out.println("Welcome to the House of Spades.\nLet's play some blackjack!");

		do {
			dealer.setUpGame();
			gotValidInput = false;

			int i = 0;
			while (i < 2) {
				dealer.cardToPlayer(player); // card to player
				dealer.cardToPlayer(dealer); // card to dealer
				i++;
			}

			System.out.print("Player Hand:  ");
			player.showHand(); // player: shows hand
			player.displayTotalHandValue(); // player displays total value of cards
			System.out.print("Dealer Hand:  ");
			System.out.print("\u2B1C ");
			dealer.hand.showTopCard();

			if (dealer.hasBlackjack(player) == true && dealer.hasBlackjack(dealer)) {
				System.out.println("Push");
			} else if (dealer.hasBlackjack(player)) {
				System.out.println("Blackjack. Player wins.");
				dealer.showHand();
				System.out.println();
			} else if (dealer.hasBlackjack(dealer)) {
				System.out.println("Blackjack. dealer wins.");
			}

			// loops through and asks player to hit/stand. Checks if players hand is over 21
			// if player hand is over 21 print bust and ask if wants to play again.
			if (dealer.hasBlackjack(player) == true || dealer.hasBlackjack(dealer) == true) {
			} else {
				do {
					while (!gotValidInput) {
						try {
							dealer.askPlayerHitOrStand();
							userChoice = kb.nextInt();
							kb.nextLine();
							// hit condition
							if (userChoice == 1) {
								dealer.cardToPlayer(player); // card to player
								player.showHand(); // player: shows hand
								player.displayTotalHandValue();
								if (dealer.checkIfValueOver21(player) == true) {
									dealer.handBusted21();
									playerBust = true;
									userChoice = 2;
									break;
								}
								correctChoice = true;
								// stand condition
							} else if (userChoice == 2) {
								correctChoice = true;
								gotValidInput = true;
							} else {
								System.out.println("Please press 1 to hit or 2 to stand.");
							}
						} catch (InputMismatchException e) {
							System.out.println("That input was incorrect.");
							player.showHand();
							kb.nextLine();
							System.out.println();
						}
					}
					gotValidInput = true;
				} while (correctChoice == true && userChoice != 2);

				// auto-deal to dealer if under 17 and player did not bust
				if (!playerBust) {
					System.out.println("Dealer Hand");
					dealer.showHand();
					dealer.displayTotalHandValue();
					boolean equalOrOver17 = false;
					equalOrOver17 = dealer.checkIfValueIsEqualToOrOver17(dealer);
					while (!equalOrOver17) {
						dealer.cardToPlayer(dealer); // card to dealer
//						System.out.println("\nDealer Hand:");
						dealer.showHand();
						dealer.displayTotalHandValue();
						if (dealer.checkIfValueIsEqualToOrOver17(dealer) == true) {
							break;
						}
						if (dealer.checkIfValueOver21(dealer) == true) {
							System.out.println("Dealer busted.");
							dealerBust = true;
							break;
						}
					}
				}

				// compare totals and declare tie or winner
				if (player.hand.getHandValue() > dealer.hand.getHandValue() && playerBust != true || dealerBust == true) {
					System.out.println("\nPlayer wins\n");
				} else if (player.hand.getHandValue() == dealer.hand.getHandValue()) {
					System.out.println("\nPush\n");
				} else {
					System.out.println("\nDealer wins\n");
				}

				keepPlaying = playAgain(kb, keepPlaying);
				
//				USED FOR TESTING DELETE FROM FINAL SUBMISSION ====================================================================
//				keepPlaying = true;

			}
			player.hand.clearHand();
			dealer.hand.clearHand();
		} while (keepPlaying);

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
		System.out.println("Play again, yes or no?");
		String userAnswer = kb.nextLine();
		if (userAnswer.equalsIgnoreCase("no")) {
			keepPlaying = false;
		} else if (userAnswer.equalsIgnoreCase("yes")) {
			keepPlaying = true;
		}
		return keepPlaying;
	}
}
