package com.xebia.mowitnow.application.exception;

import com.xebia.mowitnow.application.model.ExitStatus;

/**
 * Exception to terminate the application. 
 * 
 * @author Michel
 * 
 */
public class ApplicationTerminateException extends RuntimeException{

	private static final long serialVersionUID = -1826373198172473180L;

	private ExitStatus exitStatus;
	
	public ApplicationTerminateException(ExitStatus exitStatus) {
		this.exitStatus = exitStatus;
    }
	
	public ApplicationTerminateException() {
        super();
    }
	
	public ExitStatus getExitStatus (){
		return exitStatus;
	}

}
