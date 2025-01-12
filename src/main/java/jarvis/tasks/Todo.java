package jarvis.tasks;

/**
 * Represents the Todo task class.
 *
 * @author Shishir
 */
public class Todo extends Task {
    /**
     * Constructs a new Todo task.
     * @param description The description of the task.
     * @param status The status of completion.
     */
    public Todo(String description, boolean status) {
        super(description, status);
    }

    /**
     * Returns the string representation of the todo task.
     * @return String representation of the todo task.
     */
    @Override
    public String toString() {
        return "\uD83D\uDCDD " + super.toString() + "\n";
    }

    /**
     * Returns the string representation in the file format.
     * @return String representation.
     */
    @Override
    public String toFile() {
        return "T" + super.toFile();
    }

    /**
     * Returns false since todo tasks have no dates/deadlines.
     * @return False.
     */
    public boolean hasPassed() {
        return false;
    }

}
