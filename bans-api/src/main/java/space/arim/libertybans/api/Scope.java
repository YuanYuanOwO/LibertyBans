/* 
 * LibertyBans-api
 * Copyright © 2020 Anand Beh <https://www.arim.space>
 * 
 * LibertyBans-api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * LibertyBans-api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with LibertyBans-api. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Affero General Public License.
 */
package space.arim.libertybans.api;

/**
 * The server-specific scope of a punishment. To get a scope, see {@link ScopeManager}
 * 
 * @author A248
 *
 */
public interface Scope {
	
	/**
	 * Whether this scope applies to a server
	 * 
	 * @param server the server name
	 * @return true if applicable, false otherwise
	 */
	boolean appliesTo(String server);
	
	/**
	 * Determines equality with a given object. The contract of the {@code equals} method for {@code Scope}
	 * is that the other object must be an instance of the same implementation type, and it must apply to the
	 * same possible server strings as described in {@link #appliesTo(String)}
	 * 
	 * @param object the object to determine equality with
	 * @return true if equal, false otherwise
	 */
	@Override
	boolean equals(Object object);
	
}
