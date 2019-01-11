package net.lrn2spell.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class SpellingStaffItem extends Item {

    public SpellingStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {

        return ActionResult.PASS;
    }

}
