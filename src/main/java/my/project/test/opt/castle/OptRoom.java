package my.project.test.opt.castle;

import java.util.HashMap;
import java.util.Map;

public class OptRoom {

	private String description;
	private Map<String, OptRoom> rooms = new HashMap<>();

	public OptRoom(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExit(String direct, OptRoom optRoom) {
		rooms.put(direct, optRoom);
	}

	public OptRoom getExit(String direct) {
		return rooms.get(direct);
	}

	public String getExitDesc() {
		StringBuffer buf = new StringBuffer();
		for(String key : rooms.keySet()) {
			buf.append(key).append(" ");
        } 
		return buf.toString();
	}
	
	@Override
	public String toString() {
		return description;
	}
}
