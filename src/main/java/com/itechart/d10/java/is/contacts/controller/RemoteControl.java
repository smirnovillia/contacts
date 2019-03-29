package com.itechart.d10.java.is.contacts.controller;

import java.util.HashMap;
import java.util.Map;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;

public class RemoteControl {
	
	private Map<String,ICommand> commands = new HashMap<String, ICommand>();
	

	public Map<String, ICommand> getCommands() {
		return commands;
	}

	public void getById(String operation) {
		executeOperation(operation);
	}

	public void getAll(String operation){
		executeOperation(operation);
	}

	public void save(String operation) {
		executeOperation(operation);
	}

	public void delete(String operation) {
		executeOperation(operation);
	}

	public void deleteAll(String operation) {
		executeOperation(operation);
	}

	public void createEntity(String operation) {
		executeOperation(operation);
	}

	public void find(String operation) {
		executeOperation(operation);
	}
	
	private void executeOperation(String operation) {
		ICommand command = commands.get(operation);
		command.execute();
	}

}
