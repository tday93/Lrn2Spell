package net.lrn2spell.spells;

import net.lrn2spell.entity.ProjectileSpellEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class ProjectileSpell {

    public static ActionResult arcaneProjectile(PlayerEntity player, float dmg){
        System.out.println("In Arcane Beam Handling");
        World world = player.getEntityWorld();

        if (!world.isClient){
            ProjectileSpellEntity projectileSpellEntity_1 = new ProjectileSpellEntity(world, player, true, 1.0f, DamageSource.MAGIC);
            projectileSpellEntity_1.calculateVelocity(player, player.pitch, player.yaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(projectileSpellEntity_1);
            return ActionResult.SUCCESS;
        }


        return ActionResult.PASS;
    }
}
