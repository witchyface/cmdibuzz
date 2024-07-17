package in.usera.cmdibuzz.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import in.usera.cmdibuzz.Cmdibuzz;
import in.usera.cmdibuzz.config.CmdibuzzConfig;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.io.IOException;
import java.nio.file.Path;

public class ReloadCommand {

    private static CmdibuzzConfig CONFIG;

    private ReloadCommand() {}

    static int execute(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();
            try {
                reload(context.getSource().getServer());
                source.sendMessage(Text.of("Reload was successful"));
            } catch (IOException e) {
                source.sendMessage(Text.of("Something unexpected happened."));
                e.printStackTrace();
            }
            return 0;
        }
    public static void reload(MinecraftServer server) throws IOException {
        // Clear the existing configuration data
        CmdibuzzConfig.COMMAND_POOLS.clear();

        // Reload the configuration
        CONFIG = new CmdibuzzConfig();
    }
}
