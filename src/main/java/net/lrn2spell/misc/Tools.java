package net.lrn2spell.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.StringTextComponent;
import net.minecraft.text.TextFormat;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;

import static java.lang.Math.atan2;


public class Tools {

    public static CompoundTag getTagCompound(ItemStack stack){
        CompoundTag tagCompound = stack.getTag();
        if (tagCompound == null){
            tagCompound = new CompoundTag();
            stack.setTag(tagCompound);
        }
        return tagCompound;
    }

    public static void notify(PlayerEntity player, String msg) {
        player.addChatMessage(new StringTextComponent(TextFormat.GREEN + msg), false);
    }

    public static ArrayList<LivingEntity> entitiesInCone(PlayerEntity player, ArrayList<LivingEntity> entities, double width){
        ArrayList<LivingEntity> includedEntities = new ArrayList<>();
        Vec2f playerLook = player.getRotationClient();
        Vec3d playerPos = new Vec3d(player.getPos());

        double playerAngle = playerLook.y % 360;
        if (playerAngle < 0) {
            playerAngle = 360 + playerAngle;
        }


        System.out.println("playerLook.y: " + playerLook.y);
        System.out.println("playerAngle " + playerAngle);


        for (LivingEntity entity : entities) {
            Vec3d entityPos = new Vec3d(entity.getPos());
            double dX = entityPos.x - playerPos.x;
            double dZ = entityPos.z - playerPos.z;
            double entityAngle = atan2(dZ, dX);
            System.out.println("Angle to Entity Raw: " + entityAngle);

            double entityAngleDegrees = Math.toDegrees(entityAngle) - 90;
            System.out.println("Angle to entity degrees: " + entityAngleDegrees);

            if ( entityAngleDegrees < 0){
                entityAngleDegrees += 360;
            }

            double angleDifference = Math.abs(playerAngle - entityAngleDegrees);
            System.out.println("Angle Difference: " + angleDifference);


            if (angleDifference < width){
                includedEntities.add(entity);
            }

        }

        return includedEntities;

    }
}
