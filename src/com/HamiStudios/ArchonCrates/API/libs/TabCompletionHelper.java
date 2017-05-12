package com.HamiStudios.ArchonCrates.API.libs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompletionHelper {

	// Get a completion list for commands/players from a String[] list
	public static List<String> getCompletionList(String[] args, String[] strings, boolean returnPlayers) {
		// Get the current argument
		String arg = args[args.length-1];

		// Create an empty completion list
		ArrayList<String> completionList = new ArrayList<>();

		// If returnPlayers is true add only players to the list
		if(returnPlayers) {
			// For each player online
			for (Player p : Bukkit.getOnlinePlayers()) {
				// If the player name starts with the currently typed argument
				if(p.getName().startsWith(arg)) {
					// Add it to the list
					completionList.add(p.getName());
				}
			}
		} else { // If returnPlayers is false return passable commands or command arguments
			// For each command/argument given
			for (String s : strings) {
				// If the current argument starts with the command/argument given
				if(s.startsWith(arg)) {
					// Add it to the list
					completionList.add(s);
				}
			}
		}

		// Return the completion list
		return completionList;
	}

	public static List<String> getCompletionList(String[] args, ArrayList<String> strings, boolean returnPlayers) {
		// Get the current argument
		String arg = args[args.length-1];

		// Create an empty completion list
		ArrayList<String> completionList = new ArrayList<>();

		// If returnPlayers is true add only players to the list
		if(returnPlayers) {
			// For each player online
			for (Player p : Bukkit.getOnlinePlayers()) {
				// If the player name starts with the currently typed argument
				if(p.getName().startsWith(arg)) {
					// Add it to the list
					completionList.add(p.getName());
				}
			}
		} else { // If returnPlayers is false return passable commands or command arguments
			// For each command/argument given
			for (String s : strings) {
				// If the current argument starts with the command/argument given
				if(s.startsWith(arg)) {
					// Add it to the list
					completionList.add(s);
				}
			}
		}

		// Return the completion list
		return completionList;
	}

}
