package dev.uten2c.cmdlib;

import com.mojang.brigadier.arguments.*;
import net.minecraft.command.argument.*;

// gradlew migrateMappingsをやるためのクラス
@SuppressWarnings("ResultOfMethodCallIgnored")
final class UpdateHelper {
    static {
        AngleArgumentType.angle();
        BlockPosArgumentType.blockPos();
        BlockPredicateArgumentType.blockPredicate();
        BlockStateArgumentType.blockState();
        BoolArgumentType.bool();
        ColorArgumentType.color();
        ColumnPosArgumentType.columnPos();
        NbtCompoundArgumentType.nbtCompound();
        ScoreboardCriterionArgumentType.scoreboardCriterion();
        DimensionArgumentType.dimension();
        DoubleArgumentType.doubleArg(0.0, 0.0);
        EnchantmentArgumentType.enchantment();
        EntityArgumentType.entities();
        EntityArgumentType.entity();
        EntityAnchorArgumentType.entityAnchor();
        EntitySummonArgumentType.entitySummon();
        FloatArgumentType.floatArg(0f, 0f);
        CommandFunctionArgumentType.commandFunction();
        GameProfileArgumentType.gameProfile();
        StringArgumentType.greedyString();
        IdentifierArgumentType.identifier();
        IntegerArgumentType.integer(0, 0);
        ItemPredicateArgumentType.itemPredicate();
        ItemSlotArgumentType.itemSlot();
        ItemStackArgumentType.itemStack();
        LongArgumentType.longArg(0, 0);
        MessageArgumentType.message();
        StatusEffectArgumentType.statusEffect();
        NbtPathArgumentType.nbtPath();
        ScoreboardObjectiveArgumentType.scoreboardObjective();
        OperationArgumentType.operation();
        ParticleEffectArgumentType.particleEffect();
        EntityArgumentType.player();
        EntityArgumentType.players();
        RotationArgumentType.rotation();
        ScoreHolderArgumentType.scoreHolder();
        ScoreHolderArgumentType.scoreHolders();
        ScoreboardSlotArgumentType.scoreboardSlot();
        StringArgumentType.string();
        SwizzleArgumentType.swizzle();
        NbtElementArgumentType.nbtElement();
        TeamArgumentType.team();
        TestClassArgumentType.testClass();
        TestFunctionArgumentType.testFunction();
        TextArgumentType.text();
        UuidArgumentType.uuid();
        Vec2ArgumentType.vec2();
        Vec3ArgumentType.vec3(true);
        StringArgumentType.word();
    }
}
