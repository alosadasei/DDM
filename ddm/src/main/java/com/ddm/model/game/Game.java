package com.ddm.model.game;

import java.util.Map;

import com.ddm.model.board.Board;
import com.ddm.model.entity.DungeonMaster;
import com.ddm.model.game.Dice.DiceRollResult;
import com.ddm.model.player.Player;

public class Game {

    private Board board;

    private Player player1;
    private Player player2;

    private Player currentPlayer;

    private int turnNumber;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        initializeDungeonMasters();
        this.currentPlayer = player1;
        this.turnNumber = 1;
    }

    private void initializeDungeonMasters() {
        DungeonMaster dm1 = new DungeonMaster(player1, 4, 0);
        DungeonMaster dm2 = new DungeonMaster(player2, 4, 11);

        player1.setDungeonMaster(dm1);
        player2.setDungeonMaster(dm2);
    }

    public void nextTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        turnNumber++;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getCurrentPlayerName() {
        return currentPlayer.getName();
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public Board getBoard() {
        return board;
    }

    public boolean canSummon(DiceRollResult result) {
        Map<Integer, Long> invocations = result.getInvocationByLevel();

        // solo un nivel presente
        if (invocations.size() != 1) {
            return false;
        }

        // al menos 2 del mismo nivel
        return invocations.values().iterator().next() >= 2;
    }
}
