package net.anonymousmodding.anonymousadditions.event;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AnonymousAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
}
