/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.comand.impl;

import org.springframework.stereotype.Component;

import br.com.poc.navigation.comand.Command;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.enums.Direction;
import br.com.poc.navigation.exception.InvalidCommandException;

/**
 *
 * @author desenv
 */
@Component
public class MoveCommand extends GenericCommand implements Command {

	public MoveCommand() {

	}

	@Override
	public Coordinate execute(Coordinate coordinate)
			throws InvalidCommandException {

		try {

			super.validateCoordinate(coordinate);

			final Direction direction = coordinate.getDirection();

			switch (direction) {

			case NORTH:

				coordinate.increaseY();

				break;

			case SOUTH:

				coordinate.decrementY();

				break;

			case EAST:

				coordinate.increaseX();

				break;

			case WEST:

				coordinate.decrementX();

				break;

			default:

				throw new InvalidCommandException(
						"Direção de movimento inválida, são permitidos apenas NORTE, SUL, LESTE e OESTE.");

			}

			return coordinate;

		} catch (InvalidCommandException e) {

			throw new InvalidCommandException(
					"Erro na execução do comando [movimento].");

		}

	}

}
