package io.github.kill00.ManageRenew;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.*;
import io.github.kill00.configapi.cfg;

import java.util.ArrayList;
import java.util.List;

import static io.github.kill00.ManageRenew.ManagePlugin.c;

public class ManageCommand {

    public static void register() {
        List<Argument> arguments = new ArrayList<>();
        arguments.add(new MultiLiteralArgument(c().getKeys(true).toArray(new String[0])));


        new CommandAPICommand("manage")
                .withPermission("manage.use")
                .withAliases("m", "관리")
                .executes((sender, args) -> {
                    sender.sendMessage("/manage <Events> <Boolean>");
                    sender.sendMessage("---Support Events----");
                    for (var e : c().getKeys(true).toArray(new String[0])) {
                        sender.sendMessage(e);
                    } sender.sendMessage("----Support Events----");
                }).register();

        new CommandAPICommand("manage")
                .withPermission("manage.use")
                .withAliases("m", "관리")
                .withArguments(arguments)
                .withArguments(new BooleanArgument("Boolean"))
                .executes((sender, args) -> {

                    if (c().getBoolean(String.valueOf(args[0])) != Boolean.parseBoolean(String.valueOf(args[1]))) {
                        c().set(String.valueOf(args[0]), args[1]);
                        cfg.save("config.yml", false);
                        sender.sendMessage(args[0] + " = " + args[1]);
                    }
                }).register();
    }
}
