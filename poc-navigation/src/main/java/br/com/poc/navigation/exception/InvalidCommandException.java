/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poc.navigation.exception;

/**
 *
 * @author desenv
 */
public class InvalidCommandException extends RuntimeException {

	private static final long serialVersionUID = -2855250326886315120L;

	public InvalidCommandException() {

	}

	public InvalidCommandException(String message) {
		super(message);
	}

	public InvalidCommandException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCommandException(Throwable cause) {
		super(cause);
	}

}
