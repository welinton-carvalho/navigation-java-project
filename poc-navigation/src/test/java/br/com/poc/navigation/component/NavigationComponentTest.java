/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.component;

import org.junit.Test;

import br.com.poc.navigation.component.impl.NavigationComponentImpl;
import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.enums.Position;

/**
 *
 * @author desenv
 */
public class NavigationComponentTest {

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
		coordinate.setPosition(Position.SOUTH);

		// navigationComponent.

	}

}
