package net.anonymousmodding.anonymousadditions.block;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.custom.*;
import net.anonymousmodding.anonymousadditions.item.ModItems;
import net.anonymousmodding.anonymousadditions.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final RegistryObject<Block> RUBY_STONE_GEM = registerBlock("ruby_stone_gem",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SAPPHIRE_STONE_GEM = registerBlock("sapphire_stone_gem",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TOPAZ_STONE_GEM = registerBlock("topaz_stone_gem",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4.0f)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RUBY_DEEPSLATE_GEM = registerBlock("ruby_deepslate_gem",
            () -> new DropExperienceBlock(UniformInt.of(3,5), BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SAPPHIRE_DEEPSLATE_GEM = registerBlock("sapphire_deepslate_gem",
            () -> new DropExperienceBlock(UniformInt.of(3,5), BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TOPAZ_DEEPSLATE_GEM = registerBlock("topaz_deepslate_gem",
            () -> new DropExperienceBlock(UniformInt.of(3,5), BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<RotatedPillarBlock> PINE_LOG = registerBlock("pine_log",
            () -> new ModFlammableRotatedPillar(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG)));

    public static final RegistryObject<RotatedPillarBlock> PINE_WOOD = registerBlock("pine_wood",
            () -> new ModFlammableRotatedPillar(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            () -> new ModFlammableRotatedPillar(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_LOG)));

    public static final RegistryObject<RotatedPillarBlock> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            () -> new ModFlammableRotatedPillar(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG)));

    public static final RegistryObject<Block> PINE_PLANKS = registerBlock("pine_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
    });

    public static final RegistryObject<Block> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> PINE_SAPLING = registerBlock("pine_sapling",
            () -> new SaplingBlock(ModTreeGrowers.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SAPLING)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static final RegistryObject<Block> BUDDING_OMNIGEODE_BLOCK = registerBlock("budding_omnigeode_block",
            () -> new BuddingOmniGeodeBlock(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.AMETHYST).randomTicks()));

    public static final RegistryObject<Block> OMNIGEODE_BLOCK = registerBlock("omnigeode_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> OMNIGEODE_CLUSTER = registerBlock(
            "omnigeode_cluster", () -> new OmniGeodeClusterBlock(7, 3, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .forceSolidOn()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .strength(0.5F)
                    .lightLevel(state -> 5)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SMALL_OMNIGEODE_CLUSTER = registerBlock("small_omnigeode_cluster",
            () -> new OmniGeodeClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(state -> 1).noOcclusion()));

    public static final RegistryObject<Block> MEDIUM_OMNIGEODE_CLUSTER = registerBlock("medium_omnigeode_cluster",
            () -> new OmniGeodeClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel(state -> 2).noOcclusion()));

    public static final RegistryObject<Block> LARGE_OMNIGEODE_CLUSTER = registerBlock("large_omnigeode_cluster",
            () -> new OmniGeodeClusterBlock(7, 3, BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel(state -> 4).noOcclusion()));


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
