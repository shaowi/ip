package commands;

import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

public class DeleteCommand extends Command {

	public DeleteCommand(String[] messageArray) {
		super(messageArray);
	}

	@Override
	public void execute(Object... args) {
		Ui ui = (Ui) args[0];
		Storage storage = (Storage) args[2];
		TaskList tasklist = (TaskList) args[3];
		String[] inputArr = getMessageArray();
		if (inputArr.length < 2) {
			ui.printError("Oops! The item number cannot be empty.");
			return;
		}
		try {
			tasklist.deleteTask(inputArr[1], storage, ui);
		} catch (NumberFormatException ex) {
			ui.printError("Oops! An item number must be provided.");
		}
	}

}