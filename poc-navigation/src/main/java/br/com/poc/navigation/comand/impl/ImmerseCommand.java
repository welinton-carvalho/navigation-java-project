/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.comand.impl;

import org.springframework.stereotype.Component;

import br.com.poc.navigation.comand.Command;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.exception.InvalidCommandException;

/**
 *
 * @author desenv
 */
@Component
public class ImmerseCommand extends GenericCommand implements Command {

	public ImmerseCommand() {

	}

	@Override
	public Coordinate execute(Coordinate coordinate)
			throws InvalidCommandException {

		try {

			super.validateCoordinate(coordinate);

			coordinate.decrementZ();

			return coordinate;

		} catch (InvalidCommandException e) {

			throw new InvalidCommandException(
					"Erro na execução do comando [imergir].");

		}

	}

}
