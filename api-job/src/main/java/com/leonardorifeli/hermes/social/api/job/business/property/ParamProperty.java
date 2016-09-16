package com.leonardorifeli.hermes.social.api.job.business.property;

import java.util.HashMap;

public class ParamProperty {
	
	private String key;
	
	private String value;

	public ParamProperty(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}
