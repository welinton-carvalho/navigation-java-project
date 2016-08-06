/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.comand.impl;

import br.com.poc.navigation.comand.Command;

/**
 *
 * @author desenv
 */
public enum CommandFactory {

	D(ImmerseCommand.class), L(TurnLeftCommand.class), R(TurnRightCommand.class), M(
			MoveCommand.class), U(SubmergeCommand.class);

	private final Class<? extends Command> clazz;

	private CommandFactory(Class<? extends Command> clazz) {
		this.clazz = clazz;
	}

	public Command getInstance() throws InstantiationException,
			IllegalAccessException {
		return this.clazz.newInstance();
	}

}
