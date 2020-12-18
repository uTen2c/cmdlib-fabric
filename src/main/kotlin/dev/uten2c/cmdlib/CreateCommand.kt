package dev.uten2c.cmdlib

import com.mojang.brigadier.builder.LiteralArgumentBuilder
import net.minecraft.server.command.ServerCommandSource

internal typealias Child = CommandBuilder.() -> Unit

fun registerCommand(name: String, dedicated: Boolean = false, builder: CommandBuilder.() -> Unit) {
    val arg = LiteralArgumentBuilder.literal<ServerCommandSource>(name)
    builder(CommandBuilder(arg))
    CmdLib.commands.add(Command(arg, dedicated))
}