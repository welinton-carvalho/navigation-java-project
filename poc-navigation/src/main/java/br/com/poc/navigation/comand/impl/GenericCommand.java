/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.comand.impl;

import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.exception.InvalidCommandException;

/**
 *
 * @author wpadua
 */
public class GenericCommand {

	static final int SURFACE_OF_THE_SEA = 0;

	public GenericCommand() {

	}

	public void validateCoordinate(Coordinate coordinate)
			throws InvalidCommandException {

		if (coordinate != null) {

			if (coordinate.getZ() > SURFACE_OF_THE_SEA) {

				final String message = String
						.format("Coordenada inválida para o eixo Z (profundidade de imersão) [%s], o valor do campo Z deve ser menor ou igual a zero.",
								coordinate);

				throw new InvalidCommandException(message);

			}

		} else {

			throw new InvalidCommandException("Parâmetro de coordenada nulo.");

		}

	}

}
