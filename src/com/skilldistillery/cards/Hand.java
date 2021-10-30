package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand{

	List<Card> inHand;

	public Hand() {
		inHand = new ArrayList<>();
	}

	public void addCard(Card card) {
		inHand.add(card);
	}
	
//	public int getCardValue() {
//		int value = 0;
//		value = inHand.
//		return value;
//	}
	
	public int getHandValue() {
		int totalValue = 0;
		for (Card card : inHand) {
			totalValue += card.getValue();
		}
		return totalValue;
	}
 
	public void showHand() {
		for (Card card : inHand) {
			System.out.print(card + " ");
		}
	}
	
	public void showTopCard() {
		if (inHand.size() == 2) {
			System.out.println(inHand.get(1));
		}
	}
	
	public void clearHand() {
		int handSize = inHand.size();
		System.out.println(handSize);
		if (inHand != null) {
			for (int i = handSize - 1; i >= 0; i--) {
				inHand.remove(i);
			}
		}
	}

	@Override
	public String toString() {
		return "Hand [inHand=" + inHand + "]";
	}
}
