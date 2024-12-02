package net.anonymousmodding.anonymousadditions.item;

import net.anonymousmodding.anonymousadditions.AnonymousAdditions;
import net.anonymousmodding.anonymousadditions.item.custom.FuelItem;
import net.anonymousmodding.anonymousadditions.item.custom.MagicMirrorItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AnonymousAdditions.MOD_ID);

    public static final RegistryObject<Item> ENCHANTED_SHARD = ITEMS.register("enchanted_shard", () -> new Item(new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistryObject<Item> ENCHANTED_CLUSTER = ITEMS.register("enchanted_cluster", () -> new Item(new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistryObject<Item> ENCHANTED_STEEL = ITEMS.register("enchanted_steel", () -> new Item(new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final RegistryObject<Item> MAGIC_MIRROR = ITEMS.register("magic_mirror", () -> new MagicMirrorItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> FLAMING_EMBERS = ITEMS.register("flaming_embers", () -> new FuelItem(new Item.Properties(), 500));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
