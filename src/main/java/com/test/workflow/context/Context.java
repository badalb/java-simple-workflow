package com.test.workflow.context;

public interface Context {

	public void setAttribute(String name, Object value);

	public Object getAttribute(String name);

}