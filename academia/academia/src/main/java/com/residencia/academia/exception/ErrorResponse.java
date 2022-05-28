package com.residencia.academia.exception;

import com.fasterxml.jackson.annotation.JsonInclude;



	@JsonInclude(JsonInclude.Include.NON_NULL)
	public class ErrorResponse {
		private final int status;
		private final String message;

		public ErrorResponse(int status, String message) {
			super();
			this.status = status;
			this.message = message;
		}

		public int getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}
}

