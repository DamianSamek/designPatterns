package pl.wsiz.rzeszow;

public class JsonErrorResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JsonErrorResponse(String message) {
		super();
		this.message = message;
	}

}
