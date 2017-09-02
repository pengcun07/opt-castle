package my.project.test.opt.castle;

public abstract class BaseHandler implements Handler{
	
	protected OptGame game;
	
	public BaseHandler(OptGame game) {
		this.game = game;
	}
	
	public abstract void doCmd(String cmd);

}
