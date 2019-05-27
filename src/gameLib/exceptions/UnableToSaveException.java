package gameLib.exceptions;

public class UnableToSaveException extends Exception {

	private static final long serialVersionUID = 5836802479464410440L;

	private Exception raisedBy;

	public UnableToSaveException(String errorMessage, Exception e) {
		super(errorMessage + "\n" + "Exception induced by: " + e.toString() + "\n" + e.getLocalizedMessage());
		setRaisedBy(e);
	}

	public UnableToSaveException(Exception e) {
		super("Exception induced by: " + e.toString() + "\n" + e.getLocalizedMessage());
		setRaisedBy(e);
	}

	public Exception getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Exception raisedBy) {
		this.raisedBy = raisedBy;
	}

}
