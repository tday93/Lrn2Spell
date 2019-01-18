package net.lrn2spell.blocks;

import net.lrn2spell.Lrn2Spell;
import net.lrn2spell.blocks.entity.SpellBlockEntity;
import net.lrn2spell.items.ModItems;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModBlocks {

    public static Block SPELL_BLOCK = new SpellBlock();

    public static BlockEntityType<SpellBlockEntity> SPELL_BLOCK_BE;

    public static void init() {

        SPELL_BLOCK_BE = register("spell_block", SpellBlockEntity::new);

        register(SPELL_BLOCK, "spell_block", Lrn2Spell.lrn2spellGroup);
    }

    public static void register(Block block, String name, ItemGroup tab){
        Registry.BLOCK.register(new Identifier(Lrn2Spell.MOD_ID, name), block);
        BlockItem item = new BlockItem(block, new Item.Settings().itemGroup(tab));
        ModItems.register(item, name);

    }

    public static BlockEntityType register(String name, Supplier<BlockEntity> be){
        return Registry.register(Registry.BLOCK_ENTITY, new Identifier(Lrn2Spell.MOD_ID, name), BlockEntityType.Builder.create(be).build(null));
    }
}
