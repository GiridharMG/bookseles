package com.primaseller.bookseles.exception;

/**
 * This is exception is used to throw when the required resource not found in the runtime
 * string array arguments.
 * 
 * @author taurus
 *
 */
@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String resource) {
		super(resource);
	}
	public ResourceNotFoundException () {
		super("All");
	}
}
