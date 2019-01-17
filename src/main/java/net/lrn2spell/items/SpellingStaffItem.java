package net.lrn2spell.items;

import net.lrn2spell.misc.Tools;
import net.lrn2spell.spells.BeamSpell;
import net.lrn2spell.spells.ShieldSpell;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class SpellingStaffItem extends Item {


    public SpellingStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity player, Hand hand_1){
        return new TypedActionResult<>(ActionResult.PASS, player.getStackInHand(hand_1));

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        ActionResult result = ActionResult.PASS;
        System.out.println("Using Staff");
        ItemStack stack = itemUsageContext_1.getItemStack();
        String spell = Tools.getTagCompound(stack).getString("spell");
        Tools.notify(itemUsageContext_1.getPlayer(), spell);

        if (spell.contentEquals("AR")){
            System.out.println("Spell matched 'AR' ");
            result = ShieldSpell.dirtShield(itemUsageContext_1);
        }

        // this is where spell determination will need to happen
        this.clearSpell(stack);
        return result;
    }

    public String getSpell(ItemStack stack){
        String spell = Tools.getTagCompound(stack).getString("spell");
        return spell;
    }

    public void setSpell(ItemStack stack, String newSpell){
        Tools.getTagCompound(stack).putString("spell", newSpell);
    }

    public void addElement(ItemStack stack, int element){
        String strElement = "";
        if (element == 1){
            strElement = "F";
        } else if(element == 2){
            strElement = "E";
        } else if(element == 3){
            strElement = "A";
        } else if(element == 4){
            strElement = "W";
        } else if(element == 5){
            strElement = "R";
        } else if (element == 6){
            strElement = "S";
        }
        System.out.println("Adding element: " + strElement);
        String spell = Tools.getTagCompound(stack).getString("spell");
        System.out.println("Existing Spell:" + spell);
        if (spell.length() >= 5){
            spell = spell.substring(1,5);
        }
        spell = spell + strElement;
        System.out.println("New Spell:" + spell);
        Tools.getTagCompound(stack).putString("spell", spell);

    }

    public void clearSpell(ItemStack stack){
        Tools.getTagCompound(stack).putString("spell", "");
    }



}
