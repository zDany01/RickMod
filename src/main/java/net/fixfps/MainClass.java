package net.fixfps;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MainClass implements ModInitializer {
	
	public static final Item StickRoll = new Item(new Item.Settings().group(ItemGroup.MISC)); //crea l'item

	public static final Block StickRollBlock = new Block(FabricBlockSettings.of(Material.STONE).strength(4.5F, 4.5F).sounds(BlockSoundGroup.ANVIL).breakByTool(FabricToolTags.PICKAXES).requiresTool()); //crea il blocco
	public static final Item StickRollBlock_ITEM = new BlockItem(StickRollBlock, new Item.Settings().group(ItemGroup.DECORATIONS)); //crea l'item del blocco(ndr quello nell'invetario che si può piazzare)

		

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("fixfps","stickroll"), StickRoll);
		Registry.register(Registry.BLOCK, new Identifier("fixfps","stickrollblock"), StickRollBlock); //registra il blocco nei blocchi esistenti
		Registry.register(Registry.ITEM, new Identifier("fixfps","stickrollblock"), StickRollBlock_ITEM); //registra il blocco piazzabile




	}
}
