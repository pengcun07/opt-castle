package my.project.test.opt.castle;

public class HandlerHelp extends BaseHandler implements Handler{

	public HandlerHelp(OptGame optGame) {
		super(optGame);
	}

	@Override
	public void doCmd(String cmd) {
		 System.out.print("迷路了吗？你可以做的命令有：go bye help");
	     System.out.println("如：\tgo east");
	}

}
