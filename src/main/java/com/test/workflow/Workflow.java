package com.test.workflow;

import java.util.Map;

public interface Workflow {

	public boolean processWorkflow(String workflowName,
			Map<String, Object> parameters);

}