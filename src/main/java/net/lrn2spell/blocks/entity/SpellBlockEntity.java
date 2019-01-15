package net.lrn2spell.blocks.entity;

import net.lrn2spell.init.Lrn2SpellBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;

public class SpellBlockEntity extends BlockEntity implements Tickable {

    public SpellBlockEntity () {
        super(Lrn2SpellBlocks.SPELL_BLOCK_BE);
    }

    @Override
    public void tick() {
        return;
    }

}
