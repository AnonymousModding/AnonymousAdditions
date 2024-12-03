package net.anonymousmodding.anonymousadditions.block;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.block.custom.TinkererWorkbenchBlock;
import net.anonymousmodding.anonymousadditions.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
