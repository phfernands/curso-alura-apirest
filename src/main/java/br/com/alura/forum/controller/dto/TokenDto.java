package br.com.alura.forum.controller.dto;

public class TokenDto {
	
	private String token;
	private String tipo;

	public TokenDto(String token, String string) {
		this.token = token;
		this.tipo = string;
	}

	public String getToken() {
		return token;
	}

	public String getString() {
		return tipo;
	}



}

	
