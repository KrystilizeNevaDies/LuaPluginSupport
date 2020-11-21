package cuberiteAPI.hooks;

public class HookManager {
	
	public static void registerHooks() {

		hHOOK_BLOCK_SPREAD.INSTANCE.start();
		hHOOK_BLOCK_TO_PICKUPS.INSTANCE.start();
		hHOOK_BREWING_COMPLETED.INSTANCE.start();
		hHOOK_BREWING_COMPLETING.INSTANCE.start();
		hHOOK_CHAT.INSTANCE.start();
		hHOOK_CHUNK_AVAILABLE.INSTANCE.start();
		hHOOK_CHUNK_GENERATED.INSTANCE.start();
		hHOOK_CHUNK_GENERATING.INSTANCE.start();
		hHOOK_CHUNK_UNLOADED.INSTANCE.start();
		hHOOK_CHUNK_UNLOADING.INSTANCE.start();
		hHOOK_COLLECTING_PICKUP.INSTANCE.start();
		hHOOK_CRAFTING_NO_RECIPE.INSTANCE.start();
		hHOOK_DISCONNECT.INSTANCE.start();
		hHOOK_DROPSPENSE.INSTANCE.start();
		hHOOK_ENTITY_ADD_EFFECT.INSTANCE.start();
		hHOOK_ENTITY_CHANGED_WORLD.INSTANCE.start();
		hHOOK_ENTITY_CHANGING_WORLD.INSTANCE.start();
		hHOOK_ENTITY_TELEPORT.INSTANCE.start();
		hHOOK_EXECUTE_COMMAND.INSTANCE.start();
		hHOOK_EXPLODED.INSTANCE.start();
		hHOOK_EXPLODING.INSTANCE.start();
		hHOOK_HANDSHAKE.INSTANCE.start();
		hHOOK_HOPPER_PULLING_ITEM.INSTANCE.start();
		hHOOK_HOPPER_PUSHING_ITEM.INSTANCE.start();
		hHOOK_KILLED.INSTANCE.start();
		hHOOK_KILLING.INSTANCE.start();
		hHOOK_LOGIN.INSTANCE.start();
		hHOOK_LOGIN_FORGE.INSTANCE.start();
		hHOOK_PLAYER_ANIMATION.INSTANCE.start();
		hHOOK_PLAYER_BREAKING_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_BROKEN_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_CROUCHED.INSTANCE.start();
		hHOOK_PLAYER_DESTROYED.INSTANCE.start();
		hHOOK_PLAYER_EATING.INSTANCE.start();
		hHOOK_PLAYER_FISHED.INSTANCE.start();
		hHOOK_PLAYER_FISHING.INSTANCE.start();
		hHOOK_PLAYER_FOOD_LEVEL_CHANGE.INSTANCE.start();
		hHOOK_PLAYER_JOINED.INSTANCE.start();
		hHOOK_PLAYER_LEFT_CLICK.INSTANCE.start();
		hHOOK_PLAYER_MOVING.INSTANCE.start();
		hHOOK_PLAYER_OPENING_WINDOW.INSTANCE.start();
		hHOOK_PLAYER_PLACED_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_PLACING_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_RIGHT_CLICK.INSTANCE.start();
		hHOOK_PLAYER_RIGHT_CLICKING_ENTITY.INSTANCE.start();
		hHOOK_PLAYER_SHOOTING.INSTANCE.start();
		hHOOK_PLAYER_SPAWNED.INSTANCE.start();
		hHOOK_PLAYER_TOSSING_ITEM.INSTANCE.start();
		hHOOK_PLAYER_USED_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_USED_ITEM.INSTANCE.start();
		hHOOK_PLAYER_USING_BLOCK.INSTANCE.start();
		hHOOK_PLAYER_USING_ITEM.INSTANCE.start();
		hHOOK_PLUGINS_LOADED.INSTANCE.start();
		hHOOK_PLUGIN_MESSAGE.INSTANCE.start();
		hHOOK_POST_CRAFTING.INSTANCE.start();
		hHOOK_PRE_CRAFTING.INSTANCE.start();
		hHOOK_PROJECTILE_HIT_BLOCK.INSTANCE.start();
		hHOOK_PROJECTILE_HIT_ENTITY.INSTANCE.start();
		hHOOK_SERVER_PING.INSTANCE.start();
		hHOOK_SPAWNED_ENTITY.INSTANCE.start();
		hHOOK_SPAWNED_MONSTER.INSTANCE.start();
		hHOOK_SPAWNING_ENTITY.INSTANCE.start();
		hHOOK_SPAWNING_MONSTER.INSTANCE.start();
		hHOOK_TAKE_DAMAGE.INSTANCE.start();
		hHOOK_TICK.INSTANCE.start();
		hHOOK_UPDATED_SIGN.INSTANCE.start();
		hHOOK_UPDATING_SIGN.INSTANCE.start();
		hHOOK_WEATHER_CHANGED.INSTANCE.start();
		hHOOK_WEATHER_CHANGING.INSTANCE.start();
		hHOOK_WORLD_STARTED.INSTANCE.start();
		hHOOK_WORLD_TICK.INSTANCE.start();
		
	}
	
}