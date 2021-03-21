package dev.uten2c.cmdlib

import com.mojang.brigadier.CommandDispatcher
import net.minecraft.server.command.ServerCommandSource
import net.fabricmc.api.ModInitializer

class CmdLib : ModInitializer {

    override fun onInitialize() {
    }

    companion object {
        internal val commands = HashSet<Command>()

        @JvmStatic
        @Deprecated("Internal")
        fun registerCommand(dispatcher: CommandDispatcher<ServerCommandSource>, dedicated: Boolean) {
            commands.forEach {
                if (!it.dedicated) {
                    dispatcher.register(it.builder)
                }

                if (dedicated && it.dedicated) {
                    dispatcher.register(it.builder)
                }
            }
        }
    }
}