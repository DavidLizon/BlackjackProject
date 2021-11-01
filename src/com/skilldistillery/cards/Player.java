package com.skilldistillery.cards;

import java.util.Objects;

public class Player {
	
	protected Hand hand = new Hand();
	
	Player() {}

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}
	
	public void showHand() {
		hand.showHand();
	}
	
	public void displayTotalHandValue() {
		System.out.print(" Total: ");
		System.out.println(hand.getHandValue());
	}

	
	@Override
	public String toString() {
		return "Player: " + hand ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hand);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(hand, other.hand);
	}
	
}
