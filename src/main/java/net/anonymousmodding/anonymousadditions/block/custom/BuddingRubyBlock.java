package net.anonymousmodding.anonymousadditions.block.custom;

import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingRubyBlock extends AmethystBlock {
    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingRubyBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(5) == 0) {
            Direction $$4 = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos $$5 = pPos.relative($$4);
            BlockState $$6 = pLevel.getBlockState($$5);
            Block newBlock = null;
            if (canClusterGrowAtState($$6)) {
                newBlock = ModBlocks.SMALL_RUBY_BUD.get();
            } else if ($$6.is(ModBlocks.SMALL_RUBY_BUD.get()) && $$6.getValue(AmethystClusterBlock.FACING) == $$4) {
                newBlock = ModBlocks.MEDIUM_RUBY_BUD.get();
            } else if ($$6.is(ModBlocks.MEDIUM_RUBY_BUD.get()) && $$6.getValue(AmethystClusterBlock.FACING) == $$4) {
                newBlock = ModBlocks.LARGE_RUBY_BUD.get();
            } else if ($$6.is(ModBlocks.LARGE_RUBY_BUD.get()) && $$6.getValue(AmethystClusterBlock.FACING) == $$4) {
                newBlock = ModBlocks.RUBY_CLUSTER.get();
            }

            if (newBlock != null) {
                BlockState $$8 = (BlockState)((BlockState)newBlock.defaultBlockState().setValue(AmethystClusterBlock.FACING, $$4)).setValue(AmethystClusterBlock.WATERLOGGED, $$6.getFluidState().getType() == Fluids.WATER);
                pLevel.setBlockAndUpdate($$5, $$8);
            }


        }
    }

    public static boolean canClusterGrowAtState(BlockState pState) {
        return pState.isAir() || pState.is(Blocks.WATER) && pState.getFluidState().getAmount() == 8;
    }
}