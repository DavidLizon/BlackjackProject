package com.skilldistillery.cards;

public enum Rank {
	TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(10, "J"), QUEEN(10, "Q"), KING(10, "K"), ACE(11, "A");
	
	private final int value;
	private final String face;
	
	private Rank(int value, String face){
		this.value = value;
		this.face = face;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return face;
	}
	
}
