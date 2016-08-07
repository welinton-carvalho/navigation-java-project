package br.com.poc.navigation.mapper;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import br.com.poc.navigation.comand.impl.CommandFactory;
import br.com.poc.navigation.comand.impl.ImmerseCommand;
import br.com.poc.navigation.comand.impl.MoveCommand;
import br.com.poc.navigation.comand.impl.SubmergeCommand;
import br.com.poc.navigation.comand.impl.TurnLeftCommand;
import br.com.poc.navigation.comand.impl.TurnRightCommand;
import br.com.poc.navigation.mapper.impl.CommandMapperImpl;

public class CommandMapperTest {

	public static final Logger LOGGER = Logger.getAnonymousLogger();

	public static final String EXPECTED_EXCEPTION = "Exceção esperada.";

	private final CommandMapper commandMapper;

	public CommandMapperTest() {
		this.commandMapper = new CommandMapperImpl();
	}

	@Test
	public void sequentialCommandsWithParseSuccessTest()
			throws InstantiationException, IllegalAccessException {

		List<CommandFactory> commands = this.commandMapper.parse("LRDUM");

		assertTrue(commands.get(0).getInstance() instanceof TurnLeftCommand);

		assertTrue(commands.get(1).getInstance() instanceof TurnRightCommand);

		assertTrue(commands.get(2).getInstance() instanceof ImmerseCommand);

		assertTrue(commands.get(3).getInstance() instanceof SubmergeCommand);

		assertTrue(commands.get(4).getInstance() instanceof MoveCommand);

	}

	@Test
	public void sequentialCommandsWithParseErrorTest() {

		try {
			this.commandMapper.parse("F");
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		try {
			this.commandMapper.parse(" ");
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		try {
			this.commandMapper.parse("8");
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		try {
			this.commandMapper.parse("-");
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		try {
			this.commandMapper.parse(",");
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		try {
			this.commandMapper.parse("RMMLMMMDDLL (");
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

	}

}
