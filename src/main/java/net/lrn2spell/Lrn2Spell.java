package net.lrn2spell;

import net.fabricmc.api.ModInitializer;
import net.lrn2spell.init.Lrn2SpellItems;
import net.lrn2spell.init.Lrn2SpellBlocks;


public class Lrn2Spell implements ModInitializer {

	public static final String MOD_ID = "lrn2spell";
	public static final String ITEM_CAT = "Lrn2Spell";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

		Lrn2SpellItems.init();
		Lrn2SpellBlocks.init();

	}
}
