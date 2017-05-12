package com.HamiStudios.ArchonCrates.API.libs;

import com.HamiStudios.ArchonCrates.API.Enums.Files;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileHandler {

	// Instance of the Files Enum
	private Files file;
	
	
	// FileHandler constructor
	public FileHandler(Files file) {
		// Creates the Files instance
		this.file = file;
	}
	
	// Get File instance
	public File getFile() {
		return new File(this.file.getFilePath());
	}

	// Get FileConfiguration instance
	public FileConfiguration getFileConfiguration() {
		return YamlConfiguration.loadConfiguration(new File(this.file.getFilePath() + this.file.getFileName()));
	}
	
}
