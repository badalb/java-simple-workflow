package com.test.workflow.action;

import com.test.workflow.context.Context;

public class SendEmailAction implements WorkflowAction {

	@Override
	public void doAction(Context context) throws Exception {
		System.out.println("EMAIL sent to user: " + context.getAttribute("user"));

	}

}
