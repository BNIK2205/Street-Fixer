package com.cmr.streetfixer;

public class Reports {
	String issue, description, suggestions, location;

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Reports(String issue, String description, String suggestions, String location) {
		this.issue = issue;
		this.description = description;
		this.suggestions = suggestions;
		this.location = location;
	}
}
