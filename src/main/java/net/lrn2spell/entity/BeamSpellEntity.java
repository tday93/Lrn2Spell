package net.lrn2spell.entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.thrown.ThrownEntity;
import net.minecraft.util.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BeamSpellEntity extends ThrownEntity{


    public BeamSpellEntity(World world1) {super(ModEntities.BEAM_SPELL_ENTITY, world1);}

    public BeamSpellEntity(World world, LivingEntity entity){
        super(ModEntities.BEAM_SPELL_ENTITY, entity, world);

    }

    public void onCollision(HitResult hitResult_1){
        if (hitResult_1.type == HitResult.Type.ENTITY){
            hitResult_1.entity.damage(DamageSource.MAGIC, 4.0f);
        } else if (hitResult_1.type == HitResult.Type.BLOCK){
            BlockPos pos = hitResult_1.getBlockPos();
            this.world.clearBlockState(pos);
        }

        if (!this.world.isClient){
            this.invalidate();
        }

    }



    protected void initDataTracker(){

    }



}
