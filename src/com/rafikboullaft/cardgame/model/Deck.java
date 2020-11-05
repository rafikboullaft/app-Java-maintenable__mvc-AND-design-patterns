package com.rafikboullaft.cardgame.model;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;

public class Deck {
	ArrayList<PlayingCard> cards;
	public Deck() {
		for (Rank rank:Rank.values()) {
			for (suit suit:suit.values()) {
				cards.add(new PlayingCard(rank,suit));
				System.out.print("card :("+rank+","+suit+")");
			}
		}
		shuffle();
	}
	public void shuffle() {
		Random random = new Random();
		for (int i=0;i<cards.size();i++) {
			Collections.swap(cards,i,random.nextInt(cards.size()));
		}
	}
	public PlayingCard rempveTopCard() {
		return cards.remove(0);
	}
	public void returnCardToDeck(PlayingCard card) {
		cards.add(card);
	}
	
	

}
