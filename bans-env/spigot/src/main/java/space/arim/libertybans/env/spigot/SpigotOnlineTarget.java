/* 
 * LibertyBans-env-spigot
 * Copyright © 2020 Anand Beh <https://www.arim.space>
 * 
 * LibertyBans-env-spigot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * LibertyBans-env-spigot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with LibertyBans-env-spigot. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Affero General Public License.
 */
package space.arim.libertybans.env.spigot;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import space.arim.libertybans.core.env.OnlineTarget;

class SpigotOnlineTarget implements OnlineTarget {

	private final SpigotEnv env;
	private final Player player;

	/*
	 * Construction happens on main thread in SpigotEnv, but calls to interface methods
	 * need to be thread safe. So these values must be cached
	 */
	private final UUID uuid;
	private final byte[] address;
	
	SpigotOnlineTarget(SpigotEnv env, Player player) {
		this.env = env;
		this.player = player;
		uuid = player.getUniqueId();
		address = player.getAddress().getAddress().getAddress();
	}
	
	@Override
	public boolean hasPermission(String permission) {
		return env.hasPermissionSafe(player, permission);
	}

	@Override
	public UUID getUniqueId() {
		return uuid;
	}

	@Override
	public byte[] getAddress() {
		return address;
	}

	@Override
	public void kick(String message) {
		env.core.getFuturesFactory().executeSync(() -> player.kickPlayer(ChatColor.translateAlternateColorCodes('&', message)));
	}

}
