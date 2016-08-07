package br.com.poc.navigation.comand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.poc.navigation.configuration.ApplicationContextNavigation;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.enums.Direction;

/**
 *
 * @author wpadua
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextNavigation.class)
public class AllCommandsTest {

	public static final Logger LOGGER = Logger.getAnonymousLogger();

	public static final String EXPECTED_EXCEPTION = "Exceção esperada.";

	@Autowired
	@Qualifier("immerseCommand")
	private Command immerseCommand;

	@Autowired
	@Qualifier("submergeCommand")
	private Command submergeCommand;

	@Autowired
	@Qualifier("turnLeftCommand")
	private Command turnLeftCommand;

	@Autowired
	@Qualifier("turnRightCommand")
	private Command turnRightCommand;

	@Autowired
	@Qualifier("moveCommand")
	private Command moveCommand;

	public AllCommandsTest() {

	}

	@Test
	public void immerseCommandTest() {

		Coordinate coordinate = new Coordinate(0, 0, 0, Direction.NORTH);

		this.immerseCommand.execute(coordinate);

		assertTrue(coordinate.getZ() == -1);

		this.immerseCommand.execute(coordinate);

		this.immerseCommand.execute(coordinate);

		this.immerseCommand.execute(coordinate);

		assertTrue(coordinate.getZ() == -4);

	}

	@Test
	public void submergeCommandTest() {

		Coordinate coordinate = new Coordinate(-3, 7, -1, Direction.NORTH);

		this.submergeCommand.execute(coordinate);

		assertTrue(coordinate.getZ() == 0);

		try {
			this.submergeCommand.execute(coordinate);
		} catch (Exception e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		coordinate = new Coordinate(-3, 7, -4, Direction.WEST);

		this.submergeCommand.execute(coordinate);

		this.submergeCommand.execute(coordinate);

		this.submergeCommand.execute(coordinate);

		assertTrue(coordinate.getZ() == -1);

	}

	@Test
	public void turnRightCommandTest() {

		Coordinate coordinate = new Coordinate(0, 0, 0, Direction.NORTH);

		this.turnRightCommand.execute(coordinate);

		assertEquals(coordinate.getDirection(), Direction.EAST);

		this.turnRightCommand.execute(coordinate);

		assertEquals(coordinate.getDirection(), Direction.SOUTH);

		this.turnRightCommand.execute(coordinate);

		assertEquals(coordinate.getDirection(), Direction.WEST);

		this.turnRightCommand.execute(coordinate);

		assertEquals(coordinate.getDirection(), Direction.NORTH);

	}

	@Test
	public void turnLeftCommandTest() {

		Coordinate coordinate = new Coordinate(0, 0, 0, Direction.NORTH);

		this.turnLeftCommand.execute(coordinate);

		assertEquals(coordinate.getDirection(), Direction.WEST);

		this.turnLeftCommand.execute(coordinate);

		assertEquals(coordinate.getDirection(), Direction.SOUTH);

		this.turnLeftCommand.execute(coordinate);

		assertEquals(coordinate.getDirection(), Direction.EAST);

		this.turnLeftCommand.execute(coordinate);

		assertEquals(coordinate.getDirection(), Direction.NORTH);

	}

	@Test
	public void moveCommandTest() {

		Coordinate coordinate = new Coordinate(0, 0, 0, Direction.NORTH);
		this.moveCommand.execute(coordinate);
		assertTrue(coordinate.getY() == 1);

		coordinate.setDirection(Direction.EAST);
		this.moveCommand.execute(coordinate);
		assertTrue(coordinate.getX() == 1);

		coordinate.setDirection(Direction.SOUTH);
		this.moveCommand.execute(coordinate);
		assertTrue(coordinate.getY() == 0);

		coordinate.setDirection(Direction.WEST);
		this.moveCommand.execute(coordinate);
		assertTrue(coordinate.getX() == 0);

		coordinate.setDirection(Direction.NORTH);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		assertTrue(coordinate.getY() == 3);

		coordinate.setDirection(Direction.EAST);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		assertTrue(coordinate.getX() == 2);

		coordinate.setDirection(Direction.SOUTH);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		assertTrue(coordinate.getY() == -1);

		coordinate.setDirection(Direction.WEST);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		assertTrue(coordinate.getX() == -2);

		coordinate.setDirection(Direction.WEST);
		this.moveCommand.execute(coordinate);

		coordinate.setDirection(Direction.NORTH);
		this.moveCommand.execute(coordinate);

		coordinate.setDirection(Direction.EAST);
		this.moveCommand.execute(coordinate);

		coordinate.setDirection(Direction.SOUTH);
		this.moveCommand.execute(coordinate);

		assertTrue(coordinate.getX() == -2);
		assertTrue(coordinate.getY() == -1);
		assertTrue(coordinate.getZ() == 0);

	}

	@Test
	public void sequentialsCommandsTest() {

		// LMRDDMMUU
		Coordinate coordinate = new Coordinate(0, 0, 0, Direction.NORTH);
		this.turnLeftCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.turnRightCommand.execute(coordinate);
		this.immerseCommand.execute(coordinate);
		this.immerseCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.submergeCommand.execute(coordinate);
		this.submergeCommand.execute(coordinate);

		// -1 2 0 NORTE
		assertTrue(coordinate.getX() == -1);
		assertTrue(coordinate.getY() == 2);
		assertTrue(coordinate.getZ() == 0);
		assertEquals(coordinate.getDirection(), Direction.NORTH);

		// RMMLMMMDDLL
		coordinate = new Coordinate(0, 0, 0, Direction.NORTH);
		this.turnRightCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.turnLeftCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.moveCommand.execute(coordinate);
		this.immerseCommand.execute(coordinate);
		this.immerseCommand.execute(coordinate);
		this.turnLeftCommand.execute(coordinate);
		this.turnLeftCommand.execute(coordinate);

		// 2 3 -2 SUL
		assertTrue(coordinate.getX() == 2);
		assertTrue(coordinate.getY() == 3);
		assertTrue(coordinate.getZ() == -2);
		assertEquals(coordinate.getDirection(), Direction.SOUTH);

	}

}
