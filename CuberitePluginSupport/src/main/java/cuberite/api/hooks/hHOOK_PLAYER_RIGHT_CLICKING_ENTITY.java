package cuberite.api.hooks;

import java.util.ArrayList;

import org.luaj.vm2.LuaValue;

import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_PLAYER_RIGHT_CLICKING_ENTITY implements Hook {
	INSTANCE;

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	

	private ArrayList<LuaValue> hookList = new ArrayList<LuaValue>();

	public void add(LuaValue function) {
		hookList.add(function);
	}

	public void start() {
		// Setup hook logic

	}

	///////////////////////////////////////
	// hHOOK_PLAYER_RIGHT_CLICKING_ENTITY //
	///////////////////////////////////////
}
