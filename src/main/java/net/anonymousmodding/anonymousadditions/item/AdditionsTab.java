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
                // ITEMS
                output.accept(ModItems.ENCHANTED_SHARD.get());
                output.accept(ModItems.ENCHANTED_CLUSTER.get());
                output.accept(ModItems.ENCHANTED_STEEL.get());
                output.accept(ModItems.FLAMING_EMBERS.get());
                output.accept(ModItems.RAW_RUBY.get());
                output.accept(ModItems.POLISHED_RUBY.get());

                // ACCESSORIES
                output.accept(ModItems.MAGIC_MIRROR.get());
                output.accept(ModItems.CLOUD_IN_A_BOTTLE.get());

                // BLOCKS
                output.accept(ModBlocks.ENCHANTED_STONE.get());
                output.accept(ModBlocks.ENCHANTED_DEEPSLATE.get());
                output.accept(ModBlocks.TINKERER_WORKBENCH.get());
                output.accept(ModBlocks.FLAMING_EMBERS_ORE.get());
                output.accept(ModBlocks.RUBY_BLOCK.get());
                output.accept(ModBlocks.BUDDING_RUBY.get());
                output.accept(ModBlocks.SMALL_RUBY_BUD.get());
                output.accept(ModBlocks.MEDIUM_RUBY_BUD.get());
                output.accept(ModBlocks.LARGE_RUBY_BUD.get());
                output.accept(ModBlocks.RUBY_CLUSTER.get());

            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
