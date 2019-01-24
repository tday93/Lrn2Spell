package net.lrn2spell.items;

import net.lrn2spell.misc.Tools;
import net.lrn2spell.spells.ProjectileSpell;
import net.lrn2spell.spells.ShieldSpell;
import net.lrn2spell.spells.SpraySpell;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class SpellingStaffItem extends Item {


    public SpellingStaffItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity player, Hand hand_1){
        TypedActionResult<ItemStack> result = new TypedActionResult<>(ActionResult.PASS, player.getStackInHand(hand_1));
        ItemStack stack = player.getStackInHand(hand_1);
        String spell = Tools.getTagCompound(stack).getString("spell");

        if (spell.matches("RR")){
            Tools.notify(player,"Spell Matched 'RR'");
            result = new TypedActionResult<>(ProjectileSpell.arcaneProjectile(player, 4.0f), stack);
        }
        if (spell.matches("EE")){
            Tools.notify(player,"Spell Matched 'EE'");
            result = new TypedActionResult<>(SpraySpell.spraySpell(player), stack);
        }
        this.clearSpell(stack);




        return result;

    }

    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        ActionResult result = ActionResult.PASS;
        ItemStack stack = itemUsageContext_1.getItemStack();
        String spell = Tools.getTagCompound(stack).getString("spell");
        Tools.notify(itemUsageContext_1.getPlayer(), spell);

        if (spell.matches("AR")){
            Tools.notify(itemUsageContext_1.getPlayer(),"Spell matched 'AR' ");
            result = ShieldSpell.dirtShield(itemUsageContext_1);
        } else if (spell.matches("RR")){
            TypedActionResult<ItemStack> tRes = this.use(itemUsageContext_1.getWorld(), itemUsageContext_1.getPlayer(), Hand.MAIN);
            result = tRes.getResult();
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

    public void addElement(PlayerEntity player, ItemStack stack, int element){
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
        Tools.notify(player, "Adding element: " + strElement);
        String spell = Tools.getTagCompound(stack).getString("spell");
        if (spell.length() >= 5){
            spell = spell.substring(1,5);
        }
        spell = spell + strElement;
        Tools.getTagCompound(stack).putString("spell", spell);

    }

    public void clearSpell(ItemStack stack){
        Tools.getTagCompound(stack).putString("spell", "");
    }



}
