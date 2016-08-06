/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.comands;

import br.com.poc.navigation.dto.Coordinate;
import br.com.poc.navigation.exception.InvalidCommandException;

/**
 *
 * @author desenv
 */
public interface Command {

    void execute(Coordinate coordinate) throws InvalidCommandException;

}
