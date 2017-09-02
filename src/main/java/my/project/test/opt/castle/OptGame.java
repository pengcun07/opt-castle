package my.project.test.opt.castle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptGame {
	private OptRoom currentOptRoom;
	private Map<String, Handler> handlers = new HashMap<>();

	public OptGame() {
		handlers.put("help", new HandlerHelp(this));
		handlers.put("bye", new HandlerBye(this));
		handlers.put("go", new HandlerGo(this));
		createOptRooms();
	}

	private void createOptRooms() {
		OptRoom outside, lobby, pub, study, bedOptRoom;

		// 制造房间
		outside = new OptRoom("城堡外");
		lobby = new OptRoom("大堂");
		pub = new OptRoom("小酒吧");
		study = new OptRoom("书房");
		bedOptRoom = new OptRoom("卧室");

		// 初始化房间的出口
		outside.setExit("east", lobby);
		outside.setExit("south", study);
		outside.setExit("west", pub);

		lobby.setExit("west", outside);
		pub.setExit("east", outside);
		study.setExit("north", outside);
		study.setExit("east", bedOptRoom);
		bedOptRoom.setExit("west", study);

		currentOptRoom = outside; // 从城堡门外开始
	}

	private void printWelcome() {
		System.out.println();
		System.out.println("欢迎来到城堡！");
		System.out.println("这是一个超级无聊的游戏。");
		System.out.println("如果需要帮助，请输入 'help' 。");
		System.out.println();
		whereIsYou();
	}

	public void goRoom(String direction) {
		OptRoom nextRoom = currentOptRoom.getExit(direction);
		if (nextRoom == null) {
			System.out.println("那里没有门！");
		} else {
			currentOptRoom = nextRoom;
			whereIsYou();
		}
	}

	private void whereIsYou() {
		System.out.println("现在你在" + currentOptRoom);
		System.out.print("出口有：");
		currentOptRoom.getExitDesc();
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		OptGame game = new OptGame();
		game.printWelcome();

		while (true) {
			String line = in.nextLine();
			String[] words = line.split(" ");

			Handler handler = game.handlers.get(words[0]);

			if (handler == null) {
				System.out.println("没有此命令");
				continue;
			}

			if (handler.isBye())
				break;

			String cmd = null;
			if (words.length > 1) {
				cmd = words[1];
			}
			handler.doCmd(cmd);
		}

		System.out.println("感谢您的光临。再见！");
		in.close();
	}

}
