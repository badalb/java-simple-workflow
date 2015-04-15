package com.test.workflow.action;

import com.test.workflow.context.Context;

public interface WorkflowAction {

	public void doAction(Context context) throws Exception;

}