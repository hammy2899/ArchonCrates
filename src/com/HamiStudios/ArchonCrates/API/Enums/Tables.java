package com.HamiStudios.ArchonCrates.API.Enums;

public enum Tables {

	CRATES_DATA ("CREATE TABLE IF NOT EXISTS `crates`" +
			"(ID INTEGER PRIMARY KEY AUTOINCREMENT, CRATE_TYPE TEXT NOT NULL, X INT NOT NULL, Y INT NOT NULL, Z INT NOT NULL, WORLD TEXT NOT NULL, CREATOR TEXT NOT NULL);"),
	PLAYERS_DATA ("CREATE TABLE IF NOT EXISTS `players`" +
			"(ID INTEGER PRIMARY KEY AUTOINCREMENT, UUID TEXT NOT NULL, CURRENT_NAME TEXT NOT NULL);"),
	PLAYERS_NAMES ("CREATE TABLE IF NOT EXISTS `passedNames`" +
			"(ID INTEGER PRIMARY KEY AUTOINCREMENT, UUID TEXT NOT NULL, NAME TEXT NOT NULL);"),
	KEYS_DATA ("CREATE TABLE IF NOT EXISTS `keys`" +
			"(ID INTEGER PRIMARY KEY AUTOINCREMENT, UUID TEXT NOT NULL, KEY_ID TEXT NOT NULL, AMOUNT INT NOT NULL);"),
	WIN_DATA ("CREATE TABLE IF NOT EXISTS `wins`" +
			           "(ID INTEGER PRIMARY KEY AUTOINCREMENT, UUID TEXT NOT NULL, KEY_ID TEXT NOT NULL, CRATE_TYPE TEXT NOT NULL, CHANCE_EQUALIZER TEXT NOT NULL, PRIZE_ID TEXT NOT NULL, WIN_TIME TEXT NOT NULL);");

	private String createStatement;

	Tables(String createStatement) {
		this.createStatement = createStatement;
	}

	// Create statement for the table

	/**
	 * Gets the create statement for the table.
	 *
	 * @return Create statement for the table.
	 */
	public String getCreateStatement() {
		return this.createStatement;
	}

}
