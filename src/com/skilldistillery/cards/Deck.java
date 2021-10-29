package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;
	
	public Deck (){
		deck = createDeck();
		}

	private List<Card> createDeck(){

		List<Card> buildDeck = new ArrayList<>(52);

		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				buildDeck.add(new Card(s, r));
			}
		}
		return buildDeck;
	}
	
	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		Card card = deck.remove(0);
		return card;
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}

}

