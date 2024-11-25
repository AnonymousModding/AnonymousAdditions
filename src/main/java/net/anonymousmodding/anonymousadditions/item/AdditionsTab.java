package net.anonymousmodding.anonymousadditions.item;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AdditionsTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AnonymousAdditions.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ANONYMOUS_ADDITIONS_TAB = CREATIVE_MODE_TABS.register("anonymous_additions_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENCHANTED_CLUSTER.get()))
            .title(Component.translatable("creativetab.anonymousadditions.anonymous_additions"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.ENCHANTED_SHARD.get());
                output.accept(ModItems.ENCHANTED_CLUSTER.get());
                output.accept(ModBlocks.ENCHANTED_STONE.get());
                output.accept(ModBlocks.ENCHANTED_DEEPSLATE.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
