/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.exception;

/**
 *
 * @author wpadua
 */
public class ParseInputCommandException extends RuntimeException {

	private static final long serialVersionUID = 9099746637508560221L;

	public ParseInputCommandException() {

	}

	public ParseInputCommandException(String message, Throwable cause) {
		super(message, cause);
	}

}
