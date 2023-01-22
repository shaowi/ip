package seedu.shao;

import seedu.shao.commands.Command;
import seedu.shao.parser.Parser;
import seedu.shao.storage.Storage;
import seedu.shao.tasklist.TaskList;
import seedu.shao.ui.Ui;

public class Shao {

    private Ui ui;
    private Parser parser;
    private Storage storage;
    private TaskList tasklist;

    public static void main(String[] args) {
        new Shao().run(args);
    }

    private void initServices() {
        ui = new Ui();
        parser = new Parser();
        storage = new Storage();
        tasklist = new TaskList();
    }

    public void run(String[] args) {
        initServices();

        storage.getFile(tasklist, parser, ui);

        ui.greetUser();
        boolean isExit = false;
        while (!isExit) {
            ui.printRowDivider();
            String fullCommand = ui.readCommand();
            Command c = parser.parseInput(fullCommand);
            c.execute(ui, parser, storage, tasklist);
            ui.printRowDivider();
            isExit = c.isExit();
        }
        ui.cleanUp();
        // ui.readInput(tasklist, storage, parser);
    }

}
