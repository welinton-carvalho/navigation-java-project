/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.enums;

/**
 *
 * @author desenv
 */
public enum Direction {

	NORTH("NORTE"), EAST("LESTE"), WEST("OESTE"), SOUTH("SUL");

	private String description;

	private Direction(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.description;
	}

}
