package net.lrn2spell.entity;

import net.fabricmc.fabric.entity.FabricEntityTypeBuilder;
import net.lrn2spell.Lrn2Spell;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {

    public static EntityType<ProjectileSpellEntity> PROJECTILE_SPELL_ENTITY;

    public static void init() {

        PROJECTILE_SPELL_ENTITY = Registry.register(Registry.ENTITY_TYPE, new Identifier(Lrn2Spell.MOD_ID, "beam_spell"), FabricEntityTypeBuilder.create(ProjectileSpellEntity.class).trackable(64, 1, false).build());

    }

}
