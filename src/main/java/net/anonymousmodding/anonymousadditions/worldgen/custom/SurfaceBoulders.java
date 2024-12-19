package net.anonymousmodding.anonymousadditions.worldgen.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SurfaceBoulders extends Feature<NoneFeatureConfiguration> {

    private static final BlockState[] BOULDER_BLOCKS = new BlockState[]{
            Blocks.ANDESITE.defaultBlockState(),
            Blocks.STONE.defaultBlockState(),
            Blocks.COBBLESTONE.defaultBlockState(),
            Blocks.MOSSY_COBBLESTONE.defaultBlockState()
    };

    public SurfaceBoulders(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        // Base Layer: Random pattern with 2x1 or 2x2 center
        BlockPos[] centerBlocks = createRandomBase(level, origin, random);

        // Second Layer: Add blocks above some or all center blocks
        createUpperLayer(level, centerBlocks, random);

        return true;
    }

    private BlockPos[] createRandomBase(WorldGenLevel level, BlockPos origin, RandomSource random) {
        // Generate random 2x1 or 2x2 center
        BlockPos[] centerBlocks = {
                origin.offset(random.nextBoolean() ? 0 : 1, 0, 0),
                origin.offset(0, 0, random.nextBoolean() ? 0 : 1)
        };
        if (random.nextBoolean()) {
            centerBlocks = new BlockPos[]{
                    origin.offset(0, 0, 0),
                    origin.offset(1, 0, 0),
                    origin.offset(0, 0, 1),
                    origin.offset(1, 0, 1)
            };
        }

        // Place random surrounding blocks
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (x == 0 && z == 0) continue; // Skip the exact origin block
                BlockPos pos = origin.offset(x, 0, z);

                if (random.nextDouble() < 0.5 || isCenter(pos, centerBlocks)) {
                    placeBlock(level, pos, random, false);
                }
            }
        }

        // Place the center blocks
        for (BlockPos center : centerBlocks) {
            placeBlock(level, center, random, false);
        }

        return centerBlocks;
    }

    private void createUpperLayer(WorldGenLevel level, BlockPos[] centerBlocks, RandomSource random) {
        for (BlockPos center : centerBlocks) {
            if (random.nextBoolean()) {
                placeBlock(level, center.above(), random, true);
            }
        }
    }

    private boolean isCenter(BlockPos pos, BlockPos[] centerBlocks) {
        for (BlockPos center : centerBlocks) {
            if (pos.equals(center)) {
                return true;
            }
        }
        return false;
    }

    private void placeBlock(WorldGenLevel level, BlockPos pos, RandomSource random, boolean allowMossCarpet) {
        BlockState state = BOULDER_BLOCKS[random.nextInt(BOULDER_BLOCKS.length)];
        level.setBlock(pos, state, 2);

        // If mossy cobblestone and not part of the center, add moss carpet
        if (allowMossCarpet && state.is(Blocks.MOSSY_COBBLESTONE)) {
            level.setBlock(pos.above(), Blocks.MOSS_CARPET.defaultBlockState(), 2);
        }
    }
}
