package net.lrn2spell.mixin;

import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerEntity.class)
public class PlayerMixin {

    private String CURRENT_SPELL;


    public String getSpell(){
        return this.CURRENT_SPELL;
    }

    public String setSpell(String spell){
        this.CURRENT_SPELL = spell;

        return this.CURRENT_SPELL;
    }

    public String addElement(String element){
        if (this.CURRENT_SPELL.length() >= 5){
            this.CURRENT_SPELL = this.CURRENT_SPELL.substring(1,4) + element;
        } else {
            this.CURRENT_SPELL = this.CURRENT_SPELL + element;
        }

        return this.CURRENT_SPELL;
    }


}
