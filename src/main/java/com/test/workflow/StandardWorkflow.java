package com.test.workflow;

import java.util.List;
import java.util.Map;

import com.test.workflow.action.WorkflowAction;
import com.test.workflow.context.Context;
import com.test.workflow.context.StandardContext;

public class StandardWorkflow implements Workflow {

	private Map<String, List<WorkflowAction>> workflowActions;

	@Override
	public boolean processWorkflow(String workflowName,
			Map<String, Object> parameters) {

		Context context = new StandardContext(parameters);

		List<WorkflowAction> actions = getWorkflowActions(workflowName);

		for (WorkflowAction action : actions) {

			try {

				action.doAction(context);

			} catch (Exception e) {

				StringBuilder message = new StringBuilder(
						"Failed to complete action:" + action.toString());

				message.append('\n');

				message.append(e.getMessage());

				return false;

			}

		}

		return true;

	}

	private List<WorkflowAction> getWorkflowActions(String actionName) {

		List<WorkflowAction> actions = workflowActions.get(actionName);
		if (actions == null || actions.isEmpty()) {
			throw new IllegalArgumentException(
					"There is no defined action for " + actionName);
		}
		return actions;

	}

	public Map<String, List<WorkflowAction>> getWorkflowActions() {
		return workflowActions;
	}

	public void setWorkflowActions(
			Map<String, List<WorkflowAction>> workflowActions) {
		this.workflowActions = workflowActions;
	}

}