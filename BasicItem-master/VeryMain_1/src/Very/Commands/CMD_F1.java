package Very.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_F1 implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      System.out.println("§c버킷에서는 사용할수 없습니다!");
      return false;
    }
    Player player = (Player)sender;
    if(player.hasPermission("VMBasicItem.Admin.test")) {


    if (args.length > 0) {
      if (args[0].equalsIgnoreCase("low")) {
        player.sendMessage("§aLow 설정됨.");
      } else if (args[0].equalsIgnoreCase("middle")) {
        player.sendMessage("§eMiddle 설정됨.");
      } else if (args[0].equalsIgnoreCase("high")) {
        player.sendMessage("§cHigh 설정됨.");
      } 
      return true;
    } 
    player.sendMessage(ChatColor.RED + "오류: 사용방법) /test <low/middle/high>");
    }
    else player.sendMessage("§c당신은 §f'§8VMBasicItem.Admin.test§f'§c에 대한 권한이 잆습니다.");
	return true;
}
}
