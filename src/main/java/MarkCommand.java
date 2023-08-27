public class MarkCommand extends Command {
    private int index;
    private boolean flag;

    MarkCommand(int index, String type) {
        this.index = index;
        this.flag = type.equals("mark");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        // Check if index is invalid or the task is already marked
        if (tasks.size() <= index || tasks.getTask(index - 1).isCompleted() == flag) {
            throw new DukeException("The task you are trying to mark either doesnt exist, or is already marked");
        }

        if (flag) {
            tasks.mark(index - 1);
            ui.showMark(index, tasks.getTask(index - 1));
        } else {
            tasks.unmark(index - 1);
            ui.showUnmark(index, tasks.getTask(index - 1));
        }

        storage.writeData(tasks.getAllTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}