package Very.Commands;

import java.io.*;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CMD_NormalBI implements CommandExecutor {
	//private FileConfiguration config;
    File file = new File("plugins/VeryMain_BasicItem/playerBIgiven.yml");
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	  //버킷 사용금지
    if (!(sender instanceof Player)) {
      System.out.println("§c버킷에서는 사용할수 없습니다!");
      return false;
    } 
    Player player = (Player)sender;
    //권한 요청
    if(player.hasPermission("VMBasicItem.User.GiveNormal")) {
    	//if(config.get("plugin/VeryMain_Basicitem/playerBIgiven.yml") != player.getUniqueId() + ".used"){

    	//철검
        ItemStack ISA = new ItemStack(Material.IRON_SWORD);
        ItemMeta IS = ISA.getItemMeta();
        IS.setDisplayName("§e[VERYSV] §b§n§l기본 칼");
        ISA.setItemMeta(IS);
        ISA.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        ISA.addEnchantment(Enchantment.DURABILITY, 3);
        player.getInventory().addItem(new ItemStack[] { ISA });
        //곡괭이
        ItemStack ISB = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta IS1 = ISB.getItemMeta();
        IS1.setDisplayName("§e[VERYSV] §b§n§l기본 곡괭이");
        ISB.setItemMeta(IS1);
        ISB.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
        ISB.addEnchantment(Enchantment.DURABILITY, 3);
        ISB.addEnchantment(Enchantment.DIG_SPEED, 3);
        player.getInventory().addItem(new ItemStack[] { ISB });
        //도끼
        ItemStack ISC = new ItemStack(Material.IRON_AXE);
        ItemMeta IS2 = ISC.getItemMeta();
        IS2.setDisplayName("§e[VERYSV] §b§n§l기본 도끼");
        ISC.setItemMeta(IS2);
        ISC.addEnchantment(Enchantment.DURABILITY, 3);
        ISC.addEnchantment(Enchantment.DIG_SPEED, 3);
        player.getInventory().addItem(new ItemStack[] { ISC });
        //삽
        ItemStack ISD = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta IS3 = ISD.getItemMeta();
        IS3.setDisplayName("§e[VERYSV] §b§n§l기본 삽");
        ISD.setItemMeta(IS3);
        ISD.addEnchantment(Enchantment.DURABILITY, 3);
        ISD.addEnchantment(Enchantment.DIG_SPEED, 2);
        player.getInventory().addItem(new ItemStack[] { ISD });
        //스테이크
        ItemStack ISE = new ItemStack(Material.COOKED_BEEF, 64);
        ItemMeta IS4 = ISE.getItemMeta();
        ISE.setItemMeta(IS4);
        player.getInventory().addItem(new ItemStack[] { ISE });
        //지급완료
        player.sendMessage("§c" + player.getName() + "§b님 성공적으로 §a기본템을 지급하였습니다!");
        //player.sendMessage("==========================================");
        //player.sendMessage("§c현제 플러그인 버전은 §a2.0A-SNAPSHOT §c입니다.");
        //player.sendMessage("§c현제 플러그인 버전은 스냅숏 버전입니다. 안정된 버전으로 다운받아주시기 바랍니다.");
        //player.sendMessage("==========================================");
        /*player.sendMessage("==========================================");
        player.sendMessage("§7현재 플러그인 버전에는 무제한 지급이 가능하나 추후 'VeryMain_BasicITEM' 2.0B 업데이트 이후에는 무제한 지급문제가 수정됩니다.");
        player.sendMessage("==========================================");*/
        String message = player.getUniqueId() + ", " + player.getName() + ".used\n";
       
        FileWriter writer = null;
        
        try {
            // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
            writer = new FileWriter(file, true);
            writer.write(message);
            writer.flush();
            
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
    } 
    /*}
    	else player.sendMessage("§a" + player.getName() + " §c님은 이미 §f'§e1회§f' §c기본템을 지급받으셨습니다.");
    	return true;*/
    }
    //권한 부족
    else player.sendMessage("§c당신은 §f'§8VMBasicItem.User.GiveNormal§f'§c에 대한 권한이 잆습니다.");
    return true;
  }
  
}
