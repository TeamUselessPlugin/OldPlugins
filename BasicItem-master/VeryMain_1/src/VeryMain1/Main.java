package VeryMain1;

import Very.Commands.CMD_F1;
import Very.Commands.CMD_NormalBI;
import Very.Commands.CMD_NormalBIOLD;

import java.io.*;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  public void onEnable() {
    com();
    PluginDescriptionFile pdFile = getDescription();
    System.out.println(" ");
    System.out.println("   §aVERY    §b" + pdFile.getName() + " §cv" + pdFile.getVersion());
	System.out.println("   §a Main   §8Running on Bukkit - " + Bukkit.getName() + " " + Bukkit.getBukkitVersion());
    System.out.println(" ");
    
    File theDir = new File("plugins/VeryMain_BasicItem");
    File file = new File("plugins/VeryMain_BasicItem/playerBIgiven.yml");
    String message = "#Made By - FullVery\n";
    FileWriter writer = null;

 // 폴더 생성라인
 if (!theDir.exists()) {
     System.out.println("해당 플러그인 폴더가 없어 자동 생성중입니다: " + theDir.getName());
     boolean result = false;

     try{
         theDir.mkdir();
         writer = new FileWriter(file, true);
         writer.write(message);
         writer.flush();
         
         result = true;
     } 
     catch(SecurityException se){
         //handle it
     } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}        
     if(result) {    
         System.out.println("플러그인 폴더가 자동 생성되었습니다");  
     }
 }

  }
  
  public void onDisable() {}
  
  public void com() {
    getCommand("test@").setExecutor((CommandExecutor)new CMD_F1());
    getCommand("basicitem").setExecutor((CommandExecutor)new CMD_NormalBI());
    getCommand("기본템").setExecutor((CommandExecutor)new CMD_NormalBI());
    getCommand("basicitem-old").setExecutor((CommandExecutor)new CMD_NormalBIOLD());
    getCommand("기본템-old").setExecutor((CommandExecutor)new CMD_NormalBIOLD());
  }
}
