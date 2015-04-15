package com.test.workflow.context;

import java.util.HashMap;
import java.util.Map;

public class StandardContext implements Context {

	private Map<String, Object> context;

	public StandardContext(Map<String, Object> parameters) {
		if (parameters == null) {
			this.context = new HashMap<String, Object>();
		} else {
			this.context = parameters;
		}
	}

	@Override
	public Object getAttribute(String name) {
		return context.get(name);
	}

	@Override
	public void setAttribute(String name, Object value) {
		context.put(name, value);
	}

}