package net.lrn2spell.blocks.entity;

import net.lrn2spell.blocks.ModBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;

public class SpellBlockEntity extends BlockEntity implements Tickable {

    private int decayTime = 200;

    public SpellBlockEntity () {
        super(ModBlocks.SPELL_BLOCK_BE);
    }

    @Override
    public void tick() {
        this.decayTime--;
        if (this.decayTime <= 0 ){
            this.getWorld().clearBlockState(this.getPos());
            this.getWorld().removeBlockEntity(this.getPos());
        }
        return;
    }

}
