/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.component;

import java.util.logging.Logger;

import org.junit.Test;

import br.com.poc.navigation.component.impl.NavigationComponentImpl;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.enums.Direction;

/**
 *
 * @author desenv
 */
public class NavigationComponentTest {

	public static final Logger LOGGER = Logger.getAnonymousLogger();

	public static final String EXPECTED_EXCEPTION = "Exceção esperada.";

	private final NavigationComponent navigationComponent;

	public NavigationComponentTest() {
		this.navigationComponent = new NavigationComponentImpl();
	}

	@Test
	public void traceRouteTest() {

		Coordinate coordinate = new Coordinate();

		coordinate.setX(0);
		coordinate.setY(0);
		coordinate.setY(0);
		coordinate.setDirection(Direction.SOUTH);

		// navigationComponent.

	}

}
