import java.time.LocalDateTime;

public class Deadline extends Task {
	protected LocalDateTime by;

	public Deadline(String description, LocalDateTime by) {
		super(description);
		this.by = by;
	}

	@Override
	public String toString() {
		return "[D]" + super.toString() + " (by: " + dateTimeString(by) + ")";
	}

	@Override
	public String getSavedFormat() {
		return String.format("D|%d|%s|%s", isDone ? 1 : 0,
				description, formatSavedDateTime(by));
	};
}
