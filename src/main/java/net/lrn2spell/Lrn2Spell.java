package net.lrn2spell;

import net.fabricmc.api.ModInitializer;

import net.lrn2spell.input.KeyBindings;

import java.security.Key;

public class Lrn2Spell implements ModInitializer {

	public static final String MODID = "lrn2spell";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

		KeyBindings.init();
	}
}
