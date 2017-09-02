package my.project.test.opt.castle;

public class HandlerGo extends BaseHandler implements Handler{
	
	public HandlerGo(OptGame optGame) {
		super(optGame);
	}
	@Override
	public void doCmd(String cmd) {
		// TODO Auto-generated method stub
		this.game.goRoom(cmd);
	}

}
