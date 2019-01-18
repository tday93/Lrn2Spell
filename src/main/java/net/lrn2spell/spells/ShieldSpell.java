package net.lrn2spell.spells;

import net.lrn2spell.blocks.ModBlocks;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ShieldSpell {

    private static final int[][] SHIELD_NS = {{0, 0, 0}, {-1, 0, 0}, {1, 0, 0}, {-1, 1, 0}, {0, 1, 0}, {1, 1, 0}};
    private static final int[][] SHIELD_EW = {{0, 0, 0}, {0, 0, -1}, {0, 0, 1}, {0, 1, -1}, {0, 1, 0}, {0, 1, 1}};

    public static ActionResult dirtShield(ItemUsageContext itemUsageContext_1){
        World world = itemUsageContext_1.getWorld();
        ArrayList<BlockPos> blocks = getBlocks(itemUsageContext_1);
        if (blocks.isEmpty()){
            return ActionResult.FAILURE;
        } else {
            blocks.forEach((pos) -> world.setBlockState(pos, ModBlocks.SPELL_BLOCK.getDefaultState(), 0));
            return ActionResult.SUCCESS;
        }


    }

    private static ArrayList<BlockPos> getBlocks(ItemUsageContext itemUsageContext){
        World world = itemUsageContext.getWorld();
        ArrayList<BlockPos> blocks = new ArrayList<>();
        ItemPlacementContext ctx = new ItemPlacementContext(itemUsageContext);
        BlockPos origin = ctx.getPos();
        Direction direction = ctx.getPlayerFacing();
        if (direction == Direction.NORTH || direction == Direction.SOUTH){
            for (int[] shift : SHIELD_NS){
                BlockPos pos = new BlockPos(origin.getX() + shift[0], origin.getY() + shift[1], origin.getZ() + shift[2]);
                if (world.getBlockState(pos).isAir()){
                    blocks.add(pos);
                }
            }
        } else if (direction == Direction.EAST || direction == Direction.WEST){
            for (int[] shift : SHIELD_EW){
                BlockPos pos = new BlockPos(origin.getX() + shift[0], origin.getY() + shift[1], origin.getZ() + shift[2]);
                if (world.getBlockState(pos).isAir()){
                    blocks.add(pos);
                }
            }
        }

        return blocks;

    }

}
