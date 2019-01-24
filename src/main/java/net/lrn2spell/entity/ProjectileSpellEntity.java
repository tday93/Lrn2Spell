package net.lrn2spell.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.thrown.SnowballEntity;
import net.minecraft.util.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BoundingBox;
import net.minecraft.world.World;

public class ProjectileSpellEntity extends SnowballEntity {

    private boolean BREAK_BLOCK;
    private float DAMAGE_AMOUNT;
    private DamageSource DAMAGE_SRC;

    public ProjectileSpellEntity(World world, LivingEntity entity, boolean breakBlock, float dmg, DamageSource dmgSrc){
        super(world, entity);
        this.BREAK_BLOCK = breakBlock;
        this.DAMAGE_AMOUNT = dmg;
        this.DAMAGE_SRC = dmgSrc;


    }

    public void onCollision(HitResult hitResult_1){
        if (hitResult_1.getType() == HitResult.Type.ENTITY){
            LivingEntity entity = this.world.getEntities(LivingEntity.class, new BoundingBox(new BlockPos(hitResult_1.getPos())), null).get(0);
            entity.damage(this.DAMAGE_SRC, this.DAMAGE_AMOUNT);
        } else if (hitResult_1.getType() == HitResult.Type.BLOCK){
            if(this.BREAK_BLOCK){
                BlockPos pos = new BlockPos(hitResult_1.getPos());
                this.world.clearBlockState(pos);
            }
        }

        if (!this.world.isClient){
            this.invalidate();
        }

    }

    protected void initDataTracker(){

    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean shouldRenderAtDistance(double double_1){
        return true;
    }



}
