package com.br.pipa.rest.scoreGame.exception;

public class ScoreGameException extends RuntimeException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1870651219949407337L;

	public ScoreGameException() {
		    super();
	 }
	
	 public ScoreGameException(String exception, Throwable cause) {
		    super(exception, cause);
	 }
	
	 public ScoreGameException(String exception) {
		    super(exception);
	 }
	 
	 public ScoreGameException(Throwable cause) {
		    super(cause);
	 }

}
