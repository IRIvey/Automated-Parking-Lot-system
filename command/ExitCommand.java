package command;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Exiting system...");
        System.exit(0);
    }
}
