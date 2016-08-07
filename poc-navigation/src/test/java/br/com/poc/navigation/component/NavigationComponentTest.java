/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.poc.navigation.configuration.ApplicationContextNavigation;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.enums.Direction;
import br.com.poc.navigation.exception.InvalidCommandException;
import br.com.poc.navigation.exception.ParseInputCommandException;

/**
 *
 * @author desenv
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextNavigation.class)
public class NavigationComponentTest {

	public static final Logger LOGGER = Logger.getAnonymousLogger();

	public static final String EXPECTED_EXCEPTION = "Exceção esperada.";

	@Autowired
	private NavigationComponent navigationComponent;

	public NavigationComponentTest() {

	}

	@Test
	public void traceRouteSuccessTest() {

		// LMRDDMMUU
		Coordinate coordinate1 = this.navigationComponent
				.traceRoute("LMRDDMMUU");

		// -1 2 0 NORTE
		assertTrue(coordinate1.getX() == -1);
		assertTrue(coordinate1.getY() == 2);
		assertTrue(coordinate1.getZ() == 0);
		assertEquals(coordinate1.getDirection(), Direction.NORTH);

		// RMMLMMMDDLL
		Coordinate coordinate2 = this.navigationComponent
				.traceRoute("RMMLMMMDDLL");

		// 2 3 -2 SUL
		assertTrue(coordinate2.getX() == 2);
		assertTrue(coordinate2.getY() == 3);
		assertTrue(coordinate2.getZ() == -2);
		assertEquals(coordinate2.getDirection(), Direction.SOUTH);

		Coordinate coordinatePreInformed = new Coordinate();

		coordinatePreInformed.setX(-11);
		coordinatePreInformed.setY(8);
		coordinatePreInformed.setY(-5);
		coordinatePreInformed.setDirection(Direction.EAST);

		// 2 3 -2 SUL + RMMLMMMDDLL
		coordinatePreInformed = this.navigationComponent.traceRoute(
				"RMMLMMMDDLL", coordinatePreInformed);

		// -8 -7 -2 OESTE
		assertTrue(coordinatePreInformed.getX() == -8);
		assertTrue(coordinatePreInformed.getY() == -7);
		assertTrue(coordinatePreInformed.getZ() == -2);
		assertEquals(coordinatePreInformed.getDirection(), Direction.WEST);

	}

	@Test
	public void traceRouteErrorTest() {

		try {
			this.navigationComponent.traceRoute("8");
		} catch (ParseInputCommandException e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		try {
			this.navigationComponent.traceRoute("U");
		} catch (InvalidCommandException e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

		try {
			this.navigationComponent.traceRoute("LLU");
		} catch (InvalidCommandException e) {
			LOGGER.info(EXPECTED_EXCEPTION);
		}

	}

}
