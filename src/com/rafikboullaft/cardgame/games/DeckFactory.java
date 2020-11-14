package com.rafikboullaft.cardgame.games;

import com.rafikboullaft.cardgame.model.Deck;
import com.rafikboullaft.cardgame.model.NormalDeck;
import com.rafikboullaft.cardgame.model.SmallDeck;
import com.rafikboullaft.cardgame.model.TestDeck;

public class DeckFactory {
	public enum DeckType{
		normal,
		small,
		test
	};
	public static Deck makeDeck(DeckType type) {
		switch(type) {
		case normal: return new NormalDeck();
		case small: return new SmallDeck();
		case test:return new TestDeck();
		}
		return new NormalDeck();
	}

}
