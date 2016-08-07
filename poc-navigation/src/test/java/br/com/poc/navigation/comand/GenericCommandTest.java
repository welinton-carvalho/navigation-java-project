package br.com.poc.navigation.comand;

import java.util.logging.Logger;

import org.junit.Test;

import br.com.poc.navigation.comand.impl.GenericCommand;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.enums.Direction;

/**
 *
 * @author wpadua
 */
public class GenericCommandTest {

	public static final Logger LOGGER = Logger.getAnonymousLogger();

	public static final String EXPECTED_EXCEPTION = "Exceção esperada.";

	private final GenericCommand genericCommand;

	public GenericCommandTest() {
		this.genericCommand = new GenericCommand();
	}

	@Test
	public void validateCoordinateSuccessTest() {

		Coordinate coordinate = new Coordinate(0, 0, 0, Direction.NORTH);

		this.genericCommand.validateCoordinate(coordinate);

		coordinate = new Coordinate(999, -999, -999, Direction.SOUTH);

		this.genericCommand.validateCoordinate(coordinate);

	}

	@Test
	public void validateCoordinateInvalidZValueTest() {

		try {
			this.genericCommand.validateCoordinate(null);
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		Coordinate coordinate = new Coordinate(0, 0, 1, Direction.NORTH);

		try {
			this.genericCommand.validateCoordinate(coordinate);
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		coordinate = new Coordinate(999, -999, 10, Direction.SOUTH);

		try {
			this.genericCommand.validateCoordinate(coordinate);
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

	}

}
