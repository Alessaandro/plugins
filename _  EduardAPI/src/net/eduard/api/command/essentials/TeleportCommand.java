
package net.eduard.api.command.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.API;
import net.eduard.api.manager.CommandManager;
import net.eduard.api.setup.Mine;

public class TeleportCommand extends CommandManager {
	public TeleportCommand() {
		super("teleport");
	}
	public String message = "�6Voce se teleportou ate o �e$target";
	public String messageTarget = "�6O jogador �a$player �6foi teleportado ate o �e$target";
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			return false;
		}
		if (args.length == 1) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (API.existsPlayer(sender, args[0])) {
					Player target = Mine.getPlayer(args[0]);
					System.out.println(target == null);
					API.chat(p,message.replace("$target",
							target.getDisplayName()));
					p.teleport(target);
				}

			} else {
				return false;
			}
		} else {
			if (API.existsPlayer(sender, args[0])) {
				if (API.existsPlayer(sender, args[1])) {
					Player player = Mine.getPlayer(args[0]);
					Player target = Mine.getPlayer(args[1]);
					player.teleport(target);
					API.chat(player,message.replace("$target",
							target.getDisplayName()));
					API.chat(sender,messageTarget
							.replace("$player", player.getDisplayName())
							.replace("$target", target.getDisplayName()));
				}
			}

		}

		return true;
	}
}
