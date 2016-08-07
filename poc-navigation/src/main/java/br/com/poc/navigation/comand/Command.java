/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.comand;

import org.springframework.stereotype.Component;

import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.exception.InvalidCommandException;

/**
 *
 * @author desenv
 */
@Component
public interface Command {

	Coordinate execute(Coordinate coordinate) throws InvalidCommandException;

}
