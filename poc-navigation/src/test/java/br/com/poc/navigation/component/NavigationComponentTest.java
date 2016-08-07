/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.component;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.poc.navigation.configuration.ApplicationContextNavigation;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.enums.Direction;

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
	public void traceRouteTest() {

		Coordinate coordinate = new Coordinate();

		coordinate.setX(0);
		coordinate.setY(0);
		coordinate.setY(0);
		coordinate.setDirection(Direction.SOUTH);

		// navigationComponent.

	}

}
