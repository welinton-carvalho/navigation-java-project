/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.component;

import org.springframework.stereotype.Component;

import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.exception.InvalidCommandException;
import br.com.poc.navigation.exception.ParseInputCommandException;

/**
 *
 * @author desenv
 */
@Component
public interface NavigationComponent {

	public Coordinate traceRoute(String sequentialCommands)
			throws ParseInputCommandException, InvalidCommandException;

	public Coordinate traceRoute(String sequentialCommands,
			Coordinate initialCoordinate) throws ParseInputCommandException,
			InvalidCommandException;

}
