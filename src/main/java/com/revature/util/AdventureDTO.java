package com.revature.util;

public class AdventureDTO implements IDTO<String> {

	private final String data;

	public AdventureDTO(String data) {
		this.data = data;
	}

	@Override
	public String getData() {

		return data;
	}

}
