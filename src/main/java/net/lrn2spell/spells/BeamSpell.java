package net.lrn2spell.spells;

import net.lrn2spell.entity.BeamSpellEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class BeamSpell {

    public static ActionResult arcaneBeam(PlayerEntity player, float dmg){
        System.out.println("In Arcnae Beam Handling");
        World world = player.getEntityWorld();

        if (!world.isClient){
            BeamSpellEntity beamSpellEntity_1 = new BeamSpellEntity(world, player);
            beamSpellEntity_1.calculateVelocity(player, player.pitch, player.yaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(beamSpellEntity_1);
            return ActionResult.SUCCESS;
        }


        return ActionResult.PASS;
    }
}
