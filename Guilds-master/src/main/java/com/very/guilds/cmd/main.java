package com.very.guilds.cmd;

import com.very.guilds.Guilds;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class main implements CommandExecutor, TabExecutor {

    Guilds plugin;

    public main(Guilds plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§b[§fVerySV§b] §c죄송합니다. 플레이어만 이 명령어를 사용할 수 있습니다.");
            return false;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            plugin.openGuildMenu(player);
        }

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("도움말")) {
                player.sendMessage("§7---------- §3길드 시스템 §7----------");
                player.sendMessage("§6/길드 도움말 §7- 길드시스템의 명령어를 볼려옵니다.");
                player.sendMessage("§6/길드 생성 §7- 서버돈 100만원을 지불하면서 길드를 생성합니다.");
                player.sendMessage("§6/길드 해산 §7- 길드를 해산시킵니다 (길드장만 가능)");
                player.sendMessage("§6/길드 수정 §7- 길드의 MOTD등을 수정합니다 (길드 관리자 이상만 가능)");
                player.sendMessage("§6/길드 설정 §7- 길드원끼리 규칙을 설정하거나 길드관리 메뉴를 오픈합니다. (길드 관리자 이상만 가능)");
            } else if (args[0].equalsIgnoreCase("생성")) {
                if (player.hasPermission("guilds.opengui.createguild")) {

                    //GUI 오픈
                    player.chat("안녕하세요");

                } else {
                    TextComponent msg1 = new TextComponent("§b[§fVerySV§b] §c당신은§9 4등급 §c이상이 아니여서 길드를 생성할수 없습니다. ");
                    TextComponent msg = new TextComponent("§7(/랭크 정보)");
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/랭크 정보"));
                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("이곳을 누르면 명령어가 자동 완성됩니다.")));
                    player.sendMessage(msg1, msg);
                }

            } else player.sendMessage("§b[§fVerySV§b] §c알 수 없는 명령어입니다. '§e/길드 도움말§c'로 명령어를 알아보세요!");

            return false;
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("도움말");
            arguments.add("생성");
            arguments.add("해산");
            arguments.add("수정");
            arguments.add("설정");
            arguments.add("참여");
            arguments.add("탈퇴");
            arguments.add("목록");

            return arguments;

        }/*else if (args.length == 2){
            List<String> playerNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            for (int i = 0; i < players.length; i++){
                playerNames.add(players[i].getName());
            }

            return playerNames;
        }*/
        return null;
    }
}