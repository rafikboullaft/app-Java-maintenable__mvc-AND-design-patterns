package com.rafikboullaft.cardgame.allgames;

import java.util.ArrayList;

import com.rafikboullaft.cardgame.model.IPlayer;
import com.rafikboullaft.cardgame.model.PlayingCard;

public class HighCardGameEvaluator implements GameEvaluator{

	public IPlayer evaluateWinner(ArrayList<IPlayer> players) {
		IPlayer bestPlayer=null;
		int bestRank = -1;
		int bestSuit = -1;
		
		for(IPlayer player:players) {
			boolean newBestPlayer=false;
			if(bestPlayer==null) {
				newBestPlayer=true;
			}
			else {
			PlayingCard pl=player.getCard(0);
			int currentRank = pl.getRank().value();
			if (currentRank >= bestRank) {
				if(currentRank>bestRank) {
					newBestPlayer=true;
				}
				else {
					if(pl.getSuit().value()>bestSuit) {
						newBestPlayer=true;
					}
				}
			}
			}
			if(newBestPlayer) {
				bestPlayer=player;
				bestRank=player.getCard(0).getRank().value();
				bestSuit=player.getCard(0).getSuit().value();
			}
			
			
		}
		return bestPlayer;
	}


}
