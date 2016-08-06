/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.dto;

import br.com.poc.navigation.enums.Position;

/**
 *
 * @author desenv
 */
public class Coordinate {

    private int x;

    private int y;

    private int z;

    private Position position;

    public Coordinate() {

    }

    public void increaseX() {
        this.x++;
    }

    public void increaseY() {
        this.y++;
    }

    public void increaseZ() {
        this.z++;
    }

    public void decrementX() {
        this.x--;
    }

    public void decrementY() {
        this.y--;
    }

    public void decrementZ() {
        this.z--;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}