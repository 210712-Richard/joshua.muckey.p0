package com.revature.util;

public class InputDTO implements IDTO<Integer>{

	private Integer data;
	
	public InputDTO(Integer data) {
		this.data = data;
	}
	@Override
	public Integer getData() {
		return data;
	}

}
