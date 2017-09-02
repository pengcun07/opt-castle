package my.project.test.opt.castle;

public interface Handler {
	
	public void doCmd(String cmd);

	default boolean isBye() {
		return false;
	}
}
