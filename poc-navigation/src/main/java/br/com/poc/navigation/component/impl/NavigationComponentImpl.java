/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.poc.navigation.comand.impl.CommandFactory;
import br.com.poc.navigation.component.NavigationComponent;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.enums.Direction;
import br.com.poc.navigation.exception.InvalidCommandException;
import br.com.poc.navigation.exception.ParseInputCommandException;
import br.com.poc.navigation.mapper.CommandMapper;

/**
 *
 * @author wpadua
 */
@Component
public class NavigationComponentImpl implements NavigationComponent {

	@Autowired
	private CommandMapper commandMapper;

	public NavigationComponentImpl() {

	}

	@Override
	public Coordinate traceRoute(String sequentialCommands)
			throws ParseInputCommandException, InvalidCommandException {

		Coordinate initialCoordinate = new Coordinate(0, 0, 0, Direction.NORTH);

		return this.traceRoute(sequentialCommands, initialCoordinate);

	}

	@Override
	public Coordinate traceRoute(String sequentialCommands,
			Coordinate initialCoordinate) throws ParseInputCommandException,
			InvalidCommandException {

		Coordinate coordinate = initialCoordinate;

		try {

			final List<CommandFactory> commands = this.commandMapper
					.parse(sequentialCommands);

			commands.stream().forEach(
					(CommandFactory commandFactory) -> {

						try {

							commandFactory.getInstance().execute(coordinate);

						} catch (InstantiationException
								| IllegalAccessException exception) {

							throw new ParseInputCommandException(
									"Erro ao instanciar classe de comando.",
									exception);

						}

					});

		} catch (ParseInputCommandException exception) {

			throw exception;

		} catch (InvalidCommandException exception) {

			throw new InvalidCommandException(
					"Ocorreu um erro ao processar os commandos informados.",
					exception);

		}

		return coordinate;

	}

}
