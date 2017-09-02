package my.project.test.opt.castle;

public class HandlerBye extends BaseHandler implements Handler{
	
	public HandlerBye(OptGame optGame) {
		super(optGame);
	}
	
	@Override
	public void doCmd(String cmd) {
		
	}

	@Override
	public boolean isBye() {
		return true;
	}
	
}
