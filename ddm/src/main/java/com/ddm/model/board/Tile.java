package com.ddm.model.board;

import com.ddm.model.entity.Monster;

public class Tile {

    private int x;
    private int y;

    // monstruo que ocupa la casilla
    private Monster occupant;

    // si hay un camino, el id de su dueño
    private Integer pathOwnerId;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOccupied() {
        return occupant != null;
    }

    public Monster getOccupant() {
        return occupant;
    }

    public void setOccupant(Monster occupant) {
        this.occupant = occupant;
    }

    public Integer getPathOwnerId() {
        return pathOwnerId;
    }

    public void setPathOwnerId(Integer pathOwnerId) {
        this.pathOwnerId = pathOwnerId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
