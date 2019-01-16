package net.lrn2spell.items;

import net.lrn2spell.misc.Tools;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.TextComponent;
import net.minecraft.util.ActionResult;

public class SpellingStaffItem extends Item {


    public SpellingStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        ItemStack stack = itemUsageContext_1.getItemStack();
        String spell = Tools.getTagCompound(stack).getString("spell");
        Tools.notify(itemUsageContext_1.getPlayer(), spell);

        // this is where spell determination will need to happen
        this.clearSpell(stack);
        return ActionResult.PASS;
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

        String spell = Tools.getTagCompound(stack).getString("spell");
        if (spell.length() >= 5){
            spell = spell.substring(1,4);
        }
        spell = spell + strElement;
        Tools.getTagCompound(stack).putString("spell", spell);

    }

    public void clearSpell(ItemStack stack){
        Tools.getTagCompound(stack).putString("spell", "");
    }



}
