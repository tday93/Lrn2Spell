package net.lrn2spell.client.render.entity;

import net.lrn2spell.Lrn2Spell;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;


public class BeamSpellRender<T extends Entity> extends EntityRenderer<T> {

    public BeamSpellRender(EntityRenderDispatcher renderManager) {
        super(renderManager);
        this.field_4672 = 0;
    }

    @Override
    protected Identifier getTexture( T entity){
        return new Identifier(Lrn2Spell.MOD_ID, "textures/entity/snowball.png");

    }
}
