package net.anonymousmodding.anonymousadditions.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class MagicMirrorItem extends Item {
    private static final int COOLDOWN_TICKS = 200; // 10 seconds

    public MagicMirrorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (player instanceof ServerPlayer serverPlayer) {

                // cooldown check --- IMPORTANT --- HAVE NOT BEEN ABLE TO PROPERLY MAKE THIS MESSAGE PRINT

                if (serverPlayer.getCooldowns().isOnCooldown(this)) {
                    player.displayClientMessage(Component.literal("the mirror's powers must recharge..."), true);
                    return InteractionResultHolder.fail(itemStack); // Fail the interaction so it doesn't proceed
                }

                // overworld check

                if (level.dimension() != Level.OVERWORLD) {
                    player.displayClientMessage(Component.literal("this otherworldly place dampens the mirror's powers..."), true);
                    return InteractionResultHolder.fail(itemStack);
                }

                // determine active spawn location

                BlockPos teleportTarget;

                BlockPos respawnPosition = serverPlayer.getRespawnPosition();
                var respawnDimension = serverPlayer.getRespawnDimension();

                // check if there is a bed spawn

                boolean hasValidBedSpawn = respawnPosition != null
                        && respawnDimension == level.dimension()
                        && level.hasChunkAt(respawnPosition)
                        && level.getBlockState(respawnPosition).is(BlockTags.BEDS); // Verify bed block exists

                if (hasValidBedSpawn) {

                    // teleport to bed spawn if possible

                    teleportTarget = respawnPosition;
                    player.displayClientMessage(Component.literal("home at last..."), true);
                } else {

                    // teleport to world spawn if not

                    teleportTarget = level.getSharedSpawnPos();
                    player.displayClientMessage(Component.literal("back to where it all began..."), true);
                }

                // teleport

                serverPlayer.teleportTo(
                        teleportTarget.getX() + 0.5,
                        teleportTarget.getY() + 1.0,
                        teleportTarget.getZ() + 0.5
                );

                // play sound

                level.playSound(null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

                // apply cooldown

                serverPlayer.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
            }
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}