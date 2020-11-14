package com.rafikboullaft.cardgame.view;

import java.util.Scanner;

import com.rafikboullaft.cardgame.controller.GameController;
import com.rafikboullaft.cardgame.model.Rank;
import com.rafikboullaft.cardgame.model.suit;

public class CommandLineView implements GameView{
	GameController controller;
	Scanner keyboard = new Scanner(System.in);
	
	public void setController(GameController gc) {
		this.controller=gc;
	}
	public void promptForPlayerName() {
		System.out.println("Enter Player Name: ");
		String name=keyboard.nextLine();
		if(name.isEmpty()) {
			controller.startGame();
		}else {
			controller.addPlayer(name);
		}
		
	}
	public void promptForFlip() {
		System.out.println("ENTER to REVEAL cards");
		keyboard.nextLine();
		controller.flipCards();
	}
	public void promptForNewGame() {
		System.out.println("ENTER to START again");
		keyboard.nextLine();
		controller.startGame();
	}
	public void showPlayerName(int size, String playername) {
		System.out.println("["+size+"]["+playername+"]");
	}
	public void showFaceDownForPlayer(int index, String playername) {
		System.out.println("["+index+"]["+playername+"][####][#####]");
	}
	public void showCardforPlayer(int index, String playername, Rank rank, suit suit) {
		System.out.println("["+index+"]["+playername+"]["+rank+"]["+suit+"]");
	}
	public void showWinner(String name) {
		System.out.println("the winner ====================>"+name);
		System.out.println("hard luck to others ;) ");
	}

}
