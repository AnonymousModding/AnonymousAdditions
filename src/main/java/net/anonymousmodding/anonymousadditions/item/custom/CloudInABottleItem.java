package net.anonymousmodding.anonymousadditions.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

public class CloudInABottleItem extends Item {

    public CloudInABottleItem(Properties pProperties) {
        super(pProperties);
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
    }

    public static class EventHandler {
        private static boolean doubleJumpUsed = false;
        private static boolean spacePressedPreviously = false;

        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            Player player = event.player;
            Level level = player.level();

            if (event.phase == TickEvent.Phase.START && level.isClientSide()) {
                if (isCloudInABottleInInventory(player)) {
                    boolean isSpacePressed = Minecraft.getInstance().options.keyJump.isDown();
                    if (!isPlayerOnGround(player)) {
                        if (isSpacePressed && !spacePressedPreviously && !doubleJumpUsed) {
                            player.setDeltaMovement(player.getDeltaMovement().x, 0.5, player.getDeltaMovement().z);
                            doubleJumpUsed = true;
                            Minecraft.getInstance().player.playSound(SoundEvents.BREEZE_JUMP, 0.5F, 0.01F);
                            spawnCloudParticles(player);
                        }
                    } else {
                        doubleJumpUsed = false;
                    }
                    spacePressedPreviously = isSpacePressed;
                }
            }
        }

        private static boolean isCloudInABottleInInventory(Player player) {
            for (ItemStack stack : player.getInventory().items) {
                if (stack.getItem() instanceof CloudInABottleItem) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isPlayerOnGround(Player player) {
            boolean onGround = Math.abs(player.getDeltaMovement().y) < 0.1 &&
                    !player.level().getBlockState(player.blockPosition().below()).isAir();
            return onGround;
        }

        private static void spawnCloudParticles(Player player) {
            Minecraft mc = Minecraft.getInstance();
            for (int i = 0; i < 5; i++) {
                double offsetX = (mc.level.random.nextDouble() - 0.5) * 2;
                double offsetY = (mc.level.random.nextDouble()) * 0.5;
                double offsetZ = (mc.level.random.nextDouble() - 0.5) * 2;
                mc.level.addParticle(ParticleTypes.GUST,
                        player.getX() + offsetX,
                        player.getY() + offsetY,
                        player.getZ() + offsetZ,
                        0, 0, 0);
            }
        }
    }
}
