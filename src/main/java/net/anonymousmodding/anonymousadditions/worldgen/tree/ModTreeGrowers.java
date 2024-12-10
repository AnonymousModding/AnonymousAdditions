package net.anonymousmodding.anonymousadditions.worldgen.tree;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower PINE = new TreeGrower(AnonymousAdditions.MOD_ID + "pine",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PINE_KEY), Optional.empty());
}
