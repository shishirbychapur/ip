package jarvis;

import jarvis.commands.Command;
import jarvis.exceptions.DukeException;
import jarvis.parser.Parser;
import jarvis.storage.Storage;
import jarvis.tasks.TaskList;
import jarvis.ui.Main;
import jarvis.ui.Ui;
import javafx.application.Application;

/**
 * Represents the Duke Class.
 *
 * @author Shishir
 */
public class Jarvis {

    /** Task List of all tasks. */
    private TaskList tasks;

    /** Storage of all tasks. */
    private Storage storage;

    /** UI for chatting and interacting with the bot. */
    private Ui ui;

    /**
     * Constructs the Duke Object.
     * @param filePath Path of the text file with stored tasks.
     */
    public Jarvis(String filePath) {
        this.storage = new Storage(filePath);
        this.tasks = new TaskList(this.storage.readData());
        this.ui = new Ui();
    }

    /**
     * Constructs the Duke Object with the default file path
     * being data/tasks.txt.
     */
    public Jarvis() {
        this.storage = new Storage("data/tasks.txt");
        this.tasks = new TaskList(this.storage.readData());
        this.ui = new Ui();
    }

    /**
     * Initialises Jarvis
     * @param args Input args.
     */
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    /**
     * Parses the input string, and executes the respective command.
     * @param input Input string.
     * @return Outcome of parsing and executing.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            return command.execute(this.tasks, this.ui, this.storage);
        } catch (DukeException exc) {
            return exc.getMessage();
        }
    }

}
