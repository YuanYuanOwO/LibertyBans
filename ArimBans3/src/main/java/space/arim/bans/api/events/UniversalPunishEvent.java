/*
 * ArimBans, a punishment plugin for minecraft servers
 * Copyright © 2019 Anand Beh <https://www.arim.space>
 * 
 * ArimBans is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ArimBans is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ArimBans. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU General Public License.
 */
package space.arim.bans.api.events;

public interface UniversalPunishEvent {
	/**
	 * Using {@link space.arim.bans.internal.backend.punishment.PunishmentsMaster#addPunishments(Punishment...)},
	 * it is possible for API calls to add punishments whose date is in the past
	 * 
	 * <br><br>Such retrogade punishments are added to punishment history but not to active punishments.
	 * Hence, they aren't enforced, since they're already expired.
	 * 
	 * @return boolean - whether this PunishEvent concerns a retro punishment
	 */
	boolean isRetrogade();
}
