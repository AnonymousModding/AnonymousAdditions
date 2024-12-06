package net.anonymousmodding.anonymousadditions.block;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.custom.BuddingRubyBlock;
import net.anonymousmodding.anonymousadditions.block.custom.RubyClusterBlock;
import net.anonymousmodding.anonymousadditions.block.custom.TinkererWorkbenchBlock;
import net.anonymousmodding.anonymousadditions.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystClusterBlock;
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

    public static final RegistryObject<Block> ENCHANTED_STONE = registerBlock("enchanted_stone", () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
            .strength(3.5f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)));

    public static final RegistryObject<Block> ENCHANTED_DEEPSLATE = registerBlock("enchanted_deepslate", () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.of()
            .strength(4.5f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> TINKERER_WORKBENCH = registerBlock("tinkerer_workbench", () -> new TinkererWorkbenchBlock(BlockBehaviour.Properties.of()
            .strength(2.0f, 3.0f)
            .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> FLAMING_EMBERS_ORE = registerBlock("flaming_embers_ore", () -> new DropExperienceBlock(UniformInt.of(1, 3), BlockBehaviour.Properties.of()
            .strength(2.5f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.NETHERRACK)));

    public static final RegistryObject<Block> BUDDING_RUBY = registerBlock("budding_ruby",
            () -> new BuddingRubyBlock(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.AMETHYST).randomTicks()));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RUBY_CLUSTER = registerBlock(
            "ruby_cluster", () -> new RubyClusterBlock(7, 3, BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_RED)
                            .forceSolidOn()
                            .noOcclusion()
                            .sound(SoundType.AMETHYST_CLUSTER)
                            .strength(0.5F)
                            .lightLevel(state -> 5)
                            .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SMALL_RUBY_BUD = registerBlock("small_ruby_bud",
            () -> new RubyClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(state -> 1).noOcclusion()));

    public static final RegistryObject<Block> MEDIUM_RUBY_BUD = registerBlock("medium_ruby_bud",
            () -> new RubyClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel(state -> 2).noOcclusion()));

    public static final RegistryObject<Block> LARGE_RUBY_BUD = registerBlock("large_ruby_bud",
            () -> new RubyClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel(state -> 4).noOcclusion()));

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
