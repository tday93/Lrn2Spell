package net.lrn2spell;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.lrn2spell.entity.ModEntities;
import net.lrn2spell.items.ModItems;
import net.lrn2spell.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class Lrn2Spell implements ModInitializer {

	public static final String MOD_ID = "lrn2spell";
	public static final String ITEM_CAT = "Lrn2Spell";

	public static final ItemGroup lrn2spellGroup = FabricItemGroupBuilder.build(new Identifier("lrn2spell:lrn2spell_tab"), () -> new ItemStack(ModBlocks.SPELL_BLOCK));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

		ModItems.init();
		ModBlocks.init();
		ModEntities.init();

	}
}
