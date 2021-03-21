package dev.uten2c.cmdlib.mixin;

import com.mojang.brigadier.CommandDispatcher;
import dev.uten2c.cmdlib.CmdLib;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CommandManager.class)
public class MixinCommandManager {

    @Shadow
    @Final
    private CommandDispatcher<ServerCommandSource> dispatcher;

    @Inject(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/brigadier/CommandDispatcher;findAmbiguities(Lcom/mojang/brigadier/AmbiguityConsumer;)V"
            )
    )
    private void fabric_addCommands(CommandManager.RegistrationEnvironment environment, CallbackInfo ci) {
        //noinspection deprecation
        CmdLib.registerCommand(dispatcher, environment == CommandManager.RegistrationEnvironment.DEDICATED);
    }
}
