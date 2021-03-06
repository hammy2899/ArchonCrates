package com.HamiStudios.ArchonCrates.Commands;

import com.HamiStudios.ArchonCrates.API.Enums.Permissions;
import com.HamiStudios.ArchonCrates.API.Libs.Fetcher;
import com.HamiStudios.ArchonCrates.API.Libs.TabCompletionHelper;
import com.HamiStudios.ArchonCrates.API.Objects.ACSender;
import com.HamiStudios.ArchonCrates.API.Objects.Crate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class TabCompleter  implements org.bukkit.command.TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender commandSender, Command cmd, String commandLabel, String[] args) {

		// Create instance of ACSender
		ACSender sender = new ACSender(commandSender);

		// Checks if the command sender has the permission to use ArchonCrate commands
		if(sender.hasPermission(Permissions.COMMAND_USE.value())) {

			// Sender entered /archoncrates
			if(cmd.getName().equalsIgnoreCase("archoncrates")) {

				if(args.length == 0) {

					// No Arguments Provided, give list of commands
					return TabCompletionHelper.getCompletionList(args, new String[]{"help", "create", "key", "crates"}, false);

				} else if(args.length == 1) {
					// 1 Argument Provided

					return TabCompletionHelper.getCompletionList(args, new String[]{"help", "create", "key", "crates"}, false);

				} else if(args.length == 2) {
					// 2 Arguments Provided

					// Switch through all 2 argument length commands
					switch (args[0].toLowerCase()) {
						case "help":
							// Argument 1 is "help" so return a list of commands for the user to get help with
							return TabCompletionHelper.getCompletionList(args, new String[]{"create", "key", "crates"}, false);
						case "key":
							return TabCompletionHelper.getCompletionList(args, new String[]{}, true);
					}

				} else if(args.length == 3) {
					// 3 Arguments Provided

					// Switch through all 3 argument length commands
					switch (args[0].toLowerCase()) {
						case "key":
							return TabCompletionHelper.getCompletionList(args, new String[]{"1", "5", "10"}, false);
					}

				} else if(args.length == 4) {
					// 4 Arguments Provided

					// Switch through all 4 argument length commands
					switch (args[0].toLowerCase()) {
						case "key":
							ArrayList<String> crateIds = new ArrayList<>();
							for (Crate crate : Fetcher.getCrates()) { crateIds.add(crate.getID()); }

							String[] crates = new String[crateIds.size()];
							crates = crateIds.toArray(crates);

							return TabCompletionHelper.getCompletionList(args, crates, false);
					}

				} else if(args.length == 5) {
					// 5 Arguments Provided

					// Switch through all 5 argument length commands
					switch (args[0].toLowerCase()) {
						case "key":
							return TabCompletionHelper.getCompletionList(args, new String[]{"physical", "virtual"}, false);
					}

				}

			}
		}

		return null;
	}
}
