/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.mapper.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.poc.navigation.comand.impl.CommandFactory;
import br.com.poc.navigation.exception.ParseInputCommandException;
import br.com.poc.navigation.mapper.CommandMapper;

/**
 *
 * @author wpadua
 */
@Component
public class CommandMapperImpl implements CommandMapper {

	public CommandMapperImpl() {

	}

	@Override
	public List<CommandFactory> parse(final String sequentialCommands)
			throws ParseInputCommandException {

		final List<CommandFactory> commands = new ArrayList<>();

		if (sequentialCommands != null) {

			List<String> commandStringList = Arrays.asList(sequentialCommands
					.split(""));

			commandStringList
					.stream()
					.forEach(
							(String commandString) -> {

								try {

									final CommandFactory commandFactory = CommandFactory
											.valueOf(commandString
													.toUpperCase());

									commands.add(commandFactory);

								} catch (IllegalArgumentException exception) {

									final String message = String
											.format("Foi encontrado um comando inválido: \"%s\"",
													commandString);

									throw new ParseInputCommandException(
											message, exception);

								}

							});

		}

		return commands;

	}

}
