package net.lrn2spell.blocks;

import net.lrn2spell.Lrn2Spell;
import net.lrn2spell.blocks.entity.SpellBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.block.FabricBlockSettings;


public class SpellBlock extends Block implements BlockEntityProvider {

    String name = "spell_block";

    public SpellBlock(){
        super(FabricBlockSettings.of(Material.STONE).hardness(0.0f).collidable(false).build());
        Registry.BLOCK.register(new Identifier(Lrn2Spell.MOD_ID, "spell_block"), this);
    }

    public String getName(){return this.name;}

    public Block getBlock(){return this;}

    public BlockEntity createBlockEntity(BlockView var1) {
        return new SpellBlockEntity();
    }
}
