package nyla.solutions.gedi.gemfire.gart.exception;

import nyla.solutions.core.exception.fault.FaultException;

public class GartWarningException extends FaultException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1979975081019346666L;
	
	public GartWarningException()
	{
		super.setCategory("ERROR");
	}

	public GartWarningException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GartWarningException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

}
