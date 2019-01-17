package net.lrn2spell.spells;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BoundingBox;

public class BeamSpell {

    public static ActionResult arcaneBeam(ItemUsageContext itemUsageContext_1, float dmg){
        PlayerEntity player = itemUsageContext_1.getPlayer();
        BlockPos pos = itemUsageContext_1.getPos();

        LivingEntity target = itemUsageContext_1.getWorld().getClosestVisibleEntityTo(LivingEntity.class, new BoundingBox(pos), player);

        if (target != null) {
            target.damage(DamageSource.MAGIC, dmg);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAILURE;
        }



    }
}
