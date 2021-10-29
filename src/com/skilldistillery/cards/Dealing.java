package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dealing {

	public static void main(String[] args) {
		Dealing d = new Dealing();
		d.deal();
	}

	public void deal() {
		// get deck of cards
		Deck deck = new Deck();

		// shuffle the deck
		deck.shuffle();

		// ask user "how many cards?"
		Scanner kb = new Scanner(System.in);

		System.out.println("How many cards: ");
		int numCards = kb.nextInt();
		kb.nextLine();

		List<Card> userHand = new ArrayList<>();
		int handValue = 0;

		// deal requested number of cards to user, one card at time
		for (int dealtCards = 0; (dealtCards < numCards) && (deck != null) && (deck.checkDeckSize() > 0)
				&& (numCards < 52); dealtCards++) {

			// deal a card
			Card dealt = deck.dealCard();

			// user stuffs the dealt cards into hot little hands
			userHand.add(dealt);

			// user adds up the cards, based on rank
			handValue += dealt.getValue();

		}
		// have user show hand
		System.out.println("Player total of hand: " + handValue);
		for (Card card : userHand) {
			System.out.println(card);
		}
	}
}
