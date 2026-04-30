package com.ddm.model.game;

import com.ddm.model.player.Player;

public class Game {

    private Player player1;
    private Player player2;

    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }
    
    public void nextTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
