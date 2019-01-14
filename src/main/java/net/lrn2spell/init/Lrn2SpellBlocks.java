package net.lrn2spell.init;

import net.lrn2spell.Lrn2Spell;
import net.lrn2spell.blocks.SpellBlock;
import net.lrn2spell.blocks.entity.SpellBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class Lrn2SpellBlocks {

    public static SpellBlock SPELL_BLOCK;

    public static BlockEntityType<SpellBlockEntity> SPELL_BLOCK_BE;

    public static void init() {

        SPELL_BLOCK = new SpellBlock();

        SPELL_BLOCK_BE = register("spell_block", SpellBlockEntity::new);
    }

    public static BlockEntityType register(String name, Supplier<BlockEntity> be){
        return Registry.register(Registry.BLOCK_ENTITY, Lrn2Spell.MOD_ID + ":" + name, BlockEntityType.Builder.create(be).method_11034(null));
    }
}
