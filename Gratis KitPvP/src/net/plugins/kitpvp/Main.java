
package net.plugins.kitpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.plugins.kitpvp.command.SetSpawnCommand;
import net.plugins.kitpvp.command.SpawnCommand;
import net.plugins.kitpvp.event.GameListener;
import net.plugins.kitpvp.event.MenuListener;
import net.plugins.kitpvp.event.PlayerListener;
import net.plugins.kitpvp.kits.KitPvp;
import net.plugins.kitpvp.kits.Poseidon;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("");
		getServer().getConsoleSender().sendMessage("    §3(KitPvP)");
		getServer().getConsoleSender().sendMessage("     §bAtivando...");
		getServer().getConsoleSender()
				.sendMessage(" §3Criado por KyzeYT e Eduard");
		getServer().getConsoleSender().sendMessage("     §bATIVADO!");
		getServer().getConsoleSender().sendMessage("    §3(KitPvP)");
		getServer().getConsoleSender().sendMessage("");
		Bukkit.getPluginManager().registerEvents(new MenuListener(),
				this);
		Bukkit.getPluginManager()
				.registerEvents(new PlayerListener(), this);

		Bukkit.getPluginManager().registerEvents(new GameListener(),
				this);
		Bukkit.getPluginManager().registerEvents(new KitPvp(),
				this);
		Bukkit.getPluginManager().registerEvents(new Poseidon(),
				this);
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("");
		getServer().getConsoleSender().sendMessage("    §4(KitPvP)");
		getServer().getConsoleSender().sendMessage("     §cDesativando...");
		getServer().getConsoleSender()
				.sendMessage(" §4Criado por KyzeYT e Eduard");
		getServer().getConsoleSender().sendMessage("     §cDESATIVADO!");
		getServer().getConsoleSender().sendMessage("    §4(KitPvP)");
		getServer().getConsoleSender().sendMessage("");
	}

	public static Main getInstance() {
		return JavaPlugin.getPlugin(Main.class);
	}
}
