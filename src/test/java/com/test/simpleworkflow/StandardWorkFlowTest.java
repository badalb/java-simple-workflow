package com.test.simpleworkflow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.workflow.StandardWorkflow;
import com.test.workflow.action.SendEmailAction;
import com.test.workflow.action.WorkflowAction;


public class StandardWorkFlowTest {

	public static void main(String[] args){
		
		Map<String, Object> parameters = new HashMap<String,Object>();
		parameters.put("user", "test@test.com");
		
		String workflowName = "test";
		WorkflowAction action =  new SendEmailAction();
		List<WorkflowAction> listActions = new ArrayList<WorkflowAction>();
		listActions.add(action);
		
		Map<String, List<WorkflowAction>> workflowActions = new HashMap<String, List<WorkflowAction>>();
		workflowActions.put(workflowName, listActions);
		
		StandardWorkflow workflow =  new StandardWorkflow();
		workflow.setWorkflowActions(workflowActions);
		workflow.processWorkflow(workflowName, parameters);
	}
	
}
