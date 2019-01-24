package net.lrn2spell.client.render.entity;

import net.lrn2spell.Lrn2Spell;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;


public class ProjectileSpellRenderer<T extends Entity> extends EntityRenderer<T> {

    public ProjectileSpellRenderer(EntityRenderDispatcher renderManager) {
        super(renderManager);
        this.field_4672 = 0;
    }


    public void render(T entity_1, double double_1, double double_2, double double_3, float float_1, float float_2) {
        System.out.println("Rendering ProjectileSpell");
        super.render(entity_1, double_1, double_2, double_3, float_1, float_2);
    }

    protected Identifier getTexture(T var1){
        System.out.println("Getting beamspell texture");
        return new Identifier(Lrn2Spell.MOD_ID, "textures/entity/snowball.png");
    }
}
