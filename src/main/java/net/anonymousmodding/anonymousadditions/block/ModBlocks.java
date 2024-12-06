package net.anonymousmodding.anonymousadditions.block;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.custom.BuddingEnchantedCrystalBlock;
import net.anonymousmodding.anonymousadditions.block.custom.EnchantedCrystalClusterBlock;
import net.anonymousmodding.anonymousadditions.block.custom.TinkererWorkbenchBlock;
import net.anonymousmodding.anonymousadditions.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AnonymousAdditions.MOD_ID);

    public static final RegistryObject<Block> TINKERER_WORKBENCH = registerBlock("tinkerer_workbench", () -> new TinkererWorkbenchBlock(BlockBehaviour.Properties.of()
            .strength(2.0f, 3.0f)
            .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> FLAMING_EMBERS_ORE = registerBlock("flaming_embers_ore", () -> new DropExperienceBlock(UniformInt.of(1, 3), BlockBehaviour.Properties.of()
            .strength(2.5f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHERRACK)));

    public static final RegistryObject<Block> BUDDING_ENCHANTED_CRYSTAL = registerBlock("budding_enchanted_crystal",
            () -> new BuddingEnchantedCrystalBlock(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.AMETHYST).randomTicks()));

    public static final RegistryObject<Block> ENCHANTED_CRYSTAL_BLOCK = registerBlock("enchanted_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENCHANTED_CLUSTER = registerBlock(
            "enchanted_cluster", () -> new EnchantedCrystalClusterBlock(7, 3, BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_RED)
                            .forceSolidOn()
                            .noOcclusion()
                            .sound(SoundType.AMETHYST_CLUSTER)
                            .strength(0.5F)
                            .lightLevel(state -> 5)
                            .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SMALL_ENCHANTED_CLUSTER_BUD = registerBlock("small_enchanted_cluster_bud",
            () -> new EnchantedCrystalClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(state -> 1).noOcclusion()));

    public static final RegistryObject<Block> MEDIUM_ENCHANTED_CLUSTER_BUD = registerBlock("medium_enchanted_cluster_bud",
            () -> new EnchantedCrystalClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel(state -> 2).noOcclusion()));

    public static final RegistryObject<Block> LARGE_ENCHANTED_CLUSTER_BUD = registerBlock("large_enchanted_cluster_bud",
            () -> new EnchantedCrystalClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel(state -> 4).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
