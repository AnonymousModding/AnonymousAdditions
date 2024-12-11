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

    public static final RegistryObject<CreativeModeTab> ANONYMOUS_ADDITIONS_TAB = CREATIVE_MODE_TABS.register("anonymous_additions_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TINKERER_WORKBENCH.get()))
            .title(Component.translatable("creativetab.anonymousadditions.anonymous_additions"))
            .displayItems((itemDisplayParameters, output) -> {
                // ITEMS
                output.accept(ModItems.ENCHANTED_CRYSTAL_SHARD.get());
                output.accept(ModItems.ENCHANTED_CRYSTAL.get());
                output.accept(ModItems.ENCHANTED_STEEL.get());
                output.accept(ModItems.FLAMING_EMBERS.get());
                output.accept(ModItems.RAW_RUBY.get());
                output.accept(ModItems.POLISHED_RUBY.get());
                output.accept(ModItems.RAW_SAPPHIRE.get());
                output.accept(ModItems.POLISHED_SAPPHIRE.get());
                output.accept(ModItems.RAW_TOPAZ.get());
                output.accept(ModItems.POLISHED_TOPAZ.get());

                // ACCESSORIES
                output.accept(ModItems.MAGIC_MIRROR.get());
                output.accept(ModItems.CLOUD_IN_A_BOTTLE.get());

                // BLOCKS
                output.accept(ModBlocks.TINKERER_WORKBENCH.get());
                output.accept(ModBlocks.FLAMING_EMBERS_ORE.get());
                output.accept(ModBlocks.SMALL_ENCHANTED_CLUSTER_BUD.get());
                output.accept(ModBlocks.MEDIUM_ENCHANTED_CLUSTER_BUD.get());
                output.accept(ModBlocks.LARGE_ENCHANTED_CLUSTER_BUD.get());
                output.accept(ModBlocks.ENCHANTED_CLUSTER.get());
                output.accept(ModBlocks.ENCHANTED_CRYSTAL_BLOCK.get());
                output.accept(ModBlocks.BUDDING_ENCHANTED_CRYSTAL.get());
                output.accept(ModBlocks.SAPPHIRE_STONE_GEM.get());
                output.accept(ModBlocks.SAPPHIRE_DEEPSLATE_GEM.get());
                output.accept(ModBlocks.RUBY_STONE_GEM.get());
                output.accept(ModBlocks.RUBY_DEEPSLATE_GEM.get());
                output.accept(ModBlocks.TOPAZ_STONE_GEM.get());
                output.accept(ModBlocks.TOPAZ_DEEPSLATE_GEM.get());
                output.accept(ModBlocks.PINE_LOG.get());
                output.accept(ModBlocks.PINE_WOOD.get());
                output.accept(ModBlocks.STRIPPED_PINE_LOG.get());
                output.accept(ModBlocks.STRIPPED_PINE_WOOD.get());
                output.accept(ModBlocks.PINE_PLANKS.get());
                output.accept(ModBlocks.PINE_LEAVES.get());
                output.accept(ModBlocks.PINE_SAPLING.get());
                output.accept(ModBlocks.SMALL_OMNIGEODE_CLUSTER.get());
                output.accept(ModBlocks.MEDIUM_OMNIGEODE_CLUSTER.get());
                output.accept(ModBlocks.LARGE_OMNIGEODE_CLUSTER.get());
                output.accept(ModBlocks.OMNIGEODE_CLUSTER.get());
                output.accept(ModBlocks.OMNIGEODE_BLOCK.get());
                output.accept(ModBlocks.BUDDING_OMNIGEODE_BLOCK.get());
                output.accept(ModItems.OMNIGEODE.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
