package net.lrn2spell.blocks;

import net.lrn2spell.blocks.entity.SpellBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.Material;
import net.fabricmc.fabric.block.FabricBlockSettings;


public class SpellBlock extends Block implements BlockEntityProvider {

    public SpellBlock(){

        super(FabricBlockSettings.of(Material.STONE).hardness(0.0f).collidable(false).build());
    }

    public BlockEntity createBlockEntity(BlockView var1) {
        return new SpellBlockEntity();
    }
}
