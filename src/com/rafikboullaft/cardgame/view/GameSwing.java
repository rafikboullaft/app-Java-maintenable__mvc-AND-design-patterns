package com.rafikboullaft.cardgame.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.rafikboullaft.cardgame.controller.GameController;
import com.rafikboullaft.cardgame.model.Rank;
import com.rafikboullaft.cardgame.model.suit;



public class GameSwing implements GameView {

    GameController controller;
    JButton btnAddPlayer;
    JButton btnDealCards;
    JButton btnFindWinner;
    JTextArea textArea;
    static char nextPlayerName = 'A';

    public void createAndShowGUI() {

        // cr�er l'affichage principal avec assez d'espace
        JFrame frame = new JFrame("MVC-SOLID-Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        // tous les contr�les vont apparaitre verticalement
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        
        addAddPlayerButton(contentPane);
        addDealCardsButton(contentPane);
        addFindWinnerButton(contentPane);
        addNewWindow(contentPane);
        
        addControllerCommandTracker(contentPane);

        frame.setVisible(true);

    }
    
    private void addNewWindow(Container contentPane) {
    	JButton btnAddWindow = new JButton("New Window");
    	addCenteredComponent (btnAddWindow, contentPane);

    	btnAddWindow.addActionListener(new ActionListener() {
    	    
    	    public void actionPerformed(ActionEvent e) {
    	        GameSwing game = new GameSwing();
    	        
    	        game.createAndShowGUI();
    	        
    	        controller.addViewable(game);
    	    }
    	    
    	});
		
	}



	// au click, dire au contr�leur d'ajouter un joueur avec le nom donn�
    // ceci DEVRAIT afficher une fen�tre de dialogue pour autoriser l'utilisateur � entrer un nom
    // mais c'est hors du champs de ce qu'on doit apprendre ici
    // pour plus de simplicit�, nous allons seulement lui demander d'ajouter "Player A", "Player B", etc.

    private void addAddPlayerButton(Container contentPane) {


        btnAddPlayer = new JButton("Add A Player");
        addCenteredComponent(btnAddPlayer, contentPane);
        btnAddPlayer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                textArea.append("Current players:\n");
                controller.addPlayer("Player " + nextPlayerName++);

            }

        });

    }


    // au click, dire au contr�leur de distribuer les cartes aux joueurs
    
    private void addDealCardsButton(Container contentPane) {

        btnDealCards = new JButton("Deal Cards");
        addCenteredComponent(btnDealCards, contentPane);
        btnDealCards.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                textArea.append("Cards dealt:\n");
                controller.startGame();
            }

        });


    }

    // au click, dire au contr�leur de retourner les cartes et d�terminer qui a gagn�
    
    private void addFindWinnerButton(Container contentPane) {

        btnFindWinner = new JButton("Find Winner");
        addCenteredComponent(btnFindWinner, contentPane);
        btnFindWinner.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                textArea.append("Show your cards:\n");
                controller.flipCards();

            }

        });

    }


    // un endroit pour afficher ce que le contr�leur nous dit
    // tr�s similaire � la version en ligne de commande

    private void addControllerCommandTracker(Container contentPane) {

        textArea = new JTextArea("Game Status\n", 100, 1);
        JScrollPane scrollPane = new JScrollPane(textArea);
        addCenteredComponent(scrollPane, contentPane);
        textArea.setSize(500, 500);

    }


    // on s'assure que chaque fois que quelque chose est ajout� au champ de texte,
    // on scroll down jusqu'en bas pour pouvoir le voir
    // textArea n'a pas d'option d'auto-scroll
    // il faut donc la faire nous-m�me

    private void appendText(String text) {

        textArea.append(text + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
        
    }


    // tous les contr�les sont ajout�s pour �tre centr�s horizontalement dans la zone

    private void addCenteredComponent(JComponent component, Container contentPane) {

        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(component);

    }


    // Impl�mentation de l'interface GameViewable

    public void setController(GameController controller) {

        this.controller = controller;

    }


    // m�me impl�menation que notre CommandLineView
    // juste montrer ce que le contr�leur nous dit
    
    @Override
    public void showPlayerName(int playerIndex, String playerName) {

        appendText("[" + playerIndex + "][" + playerName + "]");
    }


    @Override
    public void showCardforPlayer(int playerIndex, String playerName, Rank cardRank, suit cardSuit) {
        
        appendText("[" + playerName + "][" + cardRank + ":" + cardSuit + "]");

    }


    @Override
    public void showWinner(String winnerName) {

        appendText("Winner!\n" + winnerName);

    }


    @Override
    public void showFaceDownForPlayer(int playerIndex, String name) {
        appendText("[" + name + "][][]");
    }


    @Override
    public void promptForPlayerName() {
        
        System.out.println("Enter Player Name:");

        // on peut ajouter des noms
        btnAddPlayer.setEnabled(true);

        // on peut d�marrer une fois qu'un joueur a �t� ajout�
        btnDealCards.setEnabled(nextPlayerName > 'A');

        // mais on ne peut pas demander de trouver un gagnant
        btnFindWinner.setEnabled(false);
    }


    @Override
    public void promptForFlip() {

        System.out.println("Press enter to reveal cards");

        // on ne peut plus ajouter de noms
        btnAddPlayer.setEnabled(false);

        // ni distribuer des cartes
        btnDealCards.setEnabled(false);

        // mais on peut demander � trouver un gagnant
        btnFindWinner.setEnabled(true);
    }

    @Override
    public void promptForNewGame() {

        System.out.println("Press enter to deal again");
        
        // on ne peut plus ajouter de noms
        btnAddPlayer.setEnabled(false);

        // on peut distribuer des cartes pour la prochaine partie
        btnDealCards.setEnabled(true);

        // on ne peut pas encore trouver un gagnant
        btnFindWinner.setEnabled(false);
    }

}

