package net.lrn2spell.spells;

import net.lrn2spell.misc.Tools;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BoundingBox;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.system.CallbackI;

import java.security.PolicySpi;
import java.util.ArrayList;

import static java.lang.Math.atan2;

public class SpraySpell {


    public static ActionResult spraySpell(PlayerEntity player){
        ArrayList<LivingEntity> targets = getSprayTargets(player, 7);
        for(LivingEntity entity : targets){
            entity.damage(DamageSource.MAGIC, 5.0f);
        }
        return ActionResult.PASS;

    }

    public static ArrayList<LivingEntity> getSprayTargets(PlayerEntity player, double range){
        Vec3d vec = player.getPosVector();
        BoundingBox box = new BoundingBox(vec.x - range, vec.y-range, vec.z - range, vec.x + range, vec.y + range, vec.z + range);
        ArrayList<LivingEntity> allEntities = new ArrayList(player.world.getEntities(LivingEntity.class, box, null));
        ArrayList<LivingEntity> targets = Tools.entitiesInCone(player, allEntities, 15);
        return targets;
    }



}
