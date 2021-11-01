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
		boolean keepPlaying = true;
		boolean gotValidInput = false;
		boolean blackJackWin;
		boolean dealerBust;
		boolean playerBust;
		boolean doubleAceBust;

		System.out.println("Welcome to the House of Spades.\nLet's play some blackjack!\n");

		do {
			dealer.setUpGame();
			gotValidInput = false;
			playerBust = false;
			dealerBust = false;
			doubleAceBust = false;
			blackJackWin = false;

			int i = 0;
			while (i < 2) {
				dealer.cardToPlayer(player); // card to player
				dealer.cardToPlayer(dealer); // card to dealer
				i++;
			}

			showHandAndTotalValue(player);
			System.out.print("Dealer Hand:  ");
			System.out.print("\u2B1C ");
			dealer.hand.showTopCard();

			blackJackWin = checkBlackJack(player, dealer, blackJackWin);

			if (!blackJackWin) {
				if (dealer.checkIfValueOver21(player) && dealer.checkIfValueOver21(dealer)) {
					doubleAceBust = true;
					System.out.println("\nPush");
					winnerPrintDisplay(player, dealer);
				} else if (dealer.checkIfValueOver21(player)) {
					playerBust = true;
					doubleAceBust = true;
					System.out.println("\nDealer wins");
					winnerPrintDisplay(player, dealer);
				} else if (dealer.checkIfValueOver21(dealer)) {
					dealerBust = true;
					doubleAceBust = true;
					System.out.println("\nPlayer wins");
					winnerPrintDisplay(player, dealer);
				}
			}

			// loops through and asks player to hit/stand. Checks if players hand is over 21
			// if player hand is over 21 print bust and ask if wants to play again.
			if (blackJackWin == true || doubleAceBust == true) {
			} else {
				do {
					while (!gotValidInput) {
						try {
							dealer.askPlayerHitOrStand();
							userChoice = kb.nextInt();
							kb.nextLine();
							
							// hit condition
							if (userChoice == 1) {
								dealer.cardToPlayer(player); 
								showHandAndTotalValue(player);
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
								System.out.println("That input was incorrect.\nPlease press 1 to hit or 2 to stand.");
								showHandAndTotalValue(player);
								System.out.println();
							}
						} catch (InputMismatchException e) {
							System.out.println("That input was incorrect.\nPlease press 1 to hit or 2 to stand.");
							showHandAndTotalValue(player);
							kb.nextLine();
							System.out.println();
						}
					}
					gotValidInput = true;
				} while (correctChoice == true && userChoice != 2);

				// auto-deal to dealer if under 17 and player did not bust
				if (!playerBust) {
					showHandAndTotalValue(dealer);
					boolean equalOrOver17 = false;
					equalOrOver17 = dealer.checkIfValueIsEqualToOrOver17(dealer);
					while (!equalOrOver17) {
						dealer.cardToPlayer(dealer);
						showHandAndTotalValue(dealer);
						if (dealer.checkIfValueOver21(dealer) == true) {
							System.out.println("Dealer busted.");
							dealerBust = true;
							break;
						}
						if (dealer.checkIfValueIsEqualToOrOver17(dealer) == true) {
							break;
						}
					}
				}

				// compare totals and declare tie or winner
				if (player.hand.getHandValue() > dealer.hand.getHandValue() && playerBust != true
						|| (dealerBust == true && playerBust != true)) {
					System.out.println("\nPlayer wins");
					winnerPrintDisplay(player, dealer);
				} else if (player.hand.getHandValue() == dealer.hand.getHandValue()
						|| (dealerBust == true && playerBust == true)) {
					System.out.println("\nPush");
					winnerPrintDisplay(player, dealer);
				} else {
					System.out.println("\nDealer wins");
					winnerPrintDisplay(player, dealer);
				}
			}

			keepPlaying = playAgain(kb, keepPlaying);

			player.hand.clearHand();
			dealer.hand.clearHand();

		} while (keepPlaying);

		System.out.println("\nThanks for playing at the House of Spades!");
		kb.close();
	}

	private boolean playAgain(Scanner kb, boolean keepPlaying) {
		System.out.println("\nPlay again, yes or no?");
		String userAnswer = kb.nextLine();
		if (userAnswer.equalsIgnoreCase("no")) {
			keepPlaying = false;
		} else if (userAnswer.equalsIgnoreCase("yes")) {
			keepPlaying = true;
		}
		return keepPlaying;
	}

	private void winnerPrintDisplay(Player player, Dealer dealer) {
		showHandAndTotalValue(player);
		showHandAndTotalValue(dealer);
	}

	private void showHandAndTotalValue(Player player) {
		if (player instanceof Dealer) {
			System.out.print("Dealer Hand:  ");
		} else {
			System.out.print("Player Hand:  ");
		}
		player.showHand();
		player.displayTotalHandValue();
	}

	private boolean checkBlackJack(Player player, Dealer dealer, boolean blackJackWin) {
		if (dealer.hasBlackjack(player) == true && dealer.hasBlackjack(dealer)) {
			System.out.println("\nPush");
			blackJackWin = true;
		} else if (dealer.hasBlackjack(player)) {
			System.out.println("\n*********  Blackjack. Player wins.  *********");
			blackJackWin = true;
		} else if (dealer.hasBlackjack(dealer)) {
			System.out.println("\n*********  Blackjack. Dealer wins.  *********");
			blackJackWin = true;
		}
		
		if(blackJackWin) {
		showHandAndTotalValue(player);
		showHandAndTotalValue(dealer);
		System.out.println();
		}
		
		return blackJackWin;
	}

	@Override
	public String toString() {
		return "BlackJackApp: Runs blackjack program";
	}

}
