package net.lrn2spell.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class SpellingStaffItem extends Item {

    private String SPELL;

    public SpellingStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {

        // this is where spell determination will need to happen
        this.clearSpell();
        return ActionResult.PASS;
    }

    public String getSpell(){
        return this.SPELL;
    }

    public String setSpell(String newSpell){
        this.SPELL = newSpell;

        return this.SPELL;
    }

    public void addElement(String element){
        if (this.SPELL.length() >= 5){
            this.SPELL = this.SPELL.substring(1,4);
        }
        this.SPELL = this.SPELL + element;

    }

    public String clearSpell(){
        this.SPELL = "";
        return this.SPELL;
    }

}
