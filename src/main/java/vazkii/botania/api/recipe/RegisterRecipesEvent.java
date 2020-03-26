/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.api.recipe;

import net.minecraftforge.eventbus.api.Event;

import java.util.function.Consumer;

/**
 * Fired on {@link net.minecraftforge.common.MinecraftForge#EVENT_BUS}
 * whenever Botania wants to receive recipe registrations, i.e. on server start and every /reload.
 * The handles to register recipes are simple {@link Consumer}s that accept the recipe to register it.
 * This will be fired many times during the lifecycle of the game, it's highly encouraged you keep your event
 * handlers as stateless as possible.
 */
public class RegisterRecipesEvent extends Event {
	private final Consumer<RecipeBrew> brew;
	private final Consumer<RecipePetals> apothecary;
	private final Consumer<RecipeRuneAltar> runeAltar;

	public RegisterRecipesEvent(Consumer<RecipeBrew> brew, Consumer<RecipePetals> apothecary, Consumer<RecipeRuneAltar> runeAltar) {
		this.brew = brew;
		this.apothecary = apothecary;
		this.runeAltar = runeAltar;
	}

	public Consumer<RecipeBrew> brew() {
		return brew;
	}

	public Consumer<RecipePetals> apothecary() {
		return apothecary;
	}

	public Consumer<RecipeRuneAltar> runeAltar() {
		return runeAltar;
	}
}
