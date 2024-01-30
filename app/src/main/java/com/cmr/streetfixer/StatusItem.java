package com.cmr.streetfixer;

public class StatusItem {

	private final String problem;
	private final String status;

	public StatusItem(String problem, String status) {
		this.problem = problem;
		this.status = status;
	}

	public String getProblem() {
		return problem;
	}

	public String getStatus() {
		return status;
	}
}
