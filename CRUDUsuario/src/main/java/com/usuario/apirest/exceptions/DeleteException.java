package com.usuario.apirest.exceptions;

public class DeleteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DeleteException(String msg) {
		super(msg);
	}
}
