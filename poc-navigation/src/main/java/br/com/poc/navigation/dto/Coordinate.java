/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.dto;

import br.com.poc.navigation.enums.Direction;

/**
 *
 * @author desenv
 */
public class Coordinate {

	private int x;

	private int y;

	private int z;

	private Direction direction;

	public Coordinate() {

	}

	public Coordinate(int x, int y, int z, Direction direction) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.direction = direction;
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return x + ", " + y + ", " + z + ", " + direction;
	}

}
