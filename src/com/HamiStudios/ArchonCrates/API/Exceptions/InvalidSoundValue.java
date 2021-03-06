package com.HamiStudios.ArchonCrates.API.Exceptions;

import com.HamiStudios.ArchonCrates.API.Enums.Files;
import com.HamiStudios.ArchonCrates.API.Libs.Console;
import org.bukkit.Bukkit;

public class InvalidSoundValue extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Thrown when a sound can not be parsed into a Minecraft sound.
	 *
	 * @param ID of the file element the sound is related to.
	 * @param soundUsed which its trying to parse.
	 * @param file of which the Exception occurred.
	 */
	public InvalidSoundValue(String ID, String soundUsed, Files file) {
		// Log to the server console to make the administrator aware of the error
		Console console = new Console(Bukkit.getConsoleSender());
		console.space();
		console.error("&cThere was an error trying to parse '" + soundUsed + "' into a Minecraft sound.");
		console.log("                      &7File: " + file.getFileName(), false);

		if(file == Files.CRATES) {
			console.log("                      &7Error Element: " + ID, false);
		}

		console.space();
	}
	
}
