package nyla.solutions.gedi.gemfire.gart.exception;

import nyla.solutions.core.exception.fault.FaultException;

public class GartErrorException extends FaultException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1979975081019346666L;
	
	public GartErrorException()
	{
		super.setCategory("WARNING");
	}

	public GartErrorException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GartErrorException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
