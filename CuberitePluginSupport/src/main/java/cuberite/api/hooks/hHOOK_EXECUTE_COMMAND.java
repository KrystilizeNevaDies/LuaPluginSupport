package cuberite.api.hooks;


import org.luaj.vm2.LuaValue;

import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.client.ClientPlayPacket;

public enum hHOOK_EXECUTE_COMMAND implements Hook {
	INSTANCE;

	private LuaValue[] hookList = {};

	@Override public LuaValue[] getFunctions() {return this.hookList;}

	@Override public void setFunctions(LuaValue[] newFunctions) {this.hookList = newFunctions;}

	public void start() {
		// Setup hook logic

	}

	@Override
	public Boolean packetEvent(ClientPlayPacket packet, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	

	///////////////////////////////////////
	// hHOOK_EXECUTE_COMMAND //
	///////////////////////////////////////
}