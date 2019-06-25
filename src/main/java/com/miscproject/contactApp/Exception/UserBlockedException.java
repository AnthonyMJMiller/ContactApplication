package com.miscproject.contactApp.Exception;

public class UserBlockedException extends Exception{
    /**
	 * 
	 */
	/**
     * Creates User object without error description.
     */
    public UserBlockedException() {
    }
    /**
     * Creates User object with error description.
     */
    public UserBlockedException(String errDesc) {
        super(errDesc);
    }    
}