package duke.commands;

import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Represents the DeleteCommand Class.
 * Responsible for handling delete operations.
 *
 * @author Shishir
 */
public class DeleteCommand extends Command {

    /** Index of respective task. */
    private int index;

    /**
     * Constructs the DeleteCommand Object.
     * @param index Index of the respective task.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the required command.
     * @param tasks List of all the tasks.
     * @param ui Ui for interacting with the user.
     * @param storage Storage of the tasks.
     * @throws DukeException Throws DukeException on invalid input.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        // Check if index is invalid or the task exists.
        if (tasks.size() < index) {
            throw new DukeException("The task you are trying to delete either doesnt exist, or is already deleted!");
        }
        ui.showDelete(index, tasks.getTask(index - 1));
        tasks.delete(index - 1);
        storage.writeData(tasks.getAllTasks());
    }

    /**
     * Returns the exit status of the command.
     * @return Exit status of the command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
