package net.fixfps;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class MainClass implements ModInitializer {
	
	public static final Item StickRoll = new Item(new Item.Settings().group(ItemGroup.MISC)); //crea l'item
	public static final Block StickRollBlock = new StickRollOre(FabricBlockSettings.of(Material.STONE).strength(4.5F, 4.5F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool()); //crea il blocco
	public static final Item StickRollBlock_ITEM = new BlockItem(StickRollBlock, new Item.Settings().group(ItemGroup.MATERIALS)); //crea l'item del blocco(ndr quello nell'invetario che si può piazzare)
	public static final Block RickRollBlock = new RickRollBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 10F).sounds(BlockSoundGroup.AMETHYST_CLUSTER).breakByHand(true));
	public static final Item RickRollBlock_ITEM = new BlockItem(RickRollBlock, new Item.Settings().group(ItemGroup.MISC));
	public static final Item MangiaRoll = new Item(new Item.Settings().group(ItemGroup.FOOD).food(MagnateElCibo.MangiaRoll));
	public static SoundEvent RICK_AUDIO = new SoundEvent(new Identifier("fixfps","rickaudio")); //crea un nuovo envento che genera un suono che viene identificato con "fixfps:rickaudio"(Controlla il file json contiene la posizione)
	
	
	private static ConfiguredFeature<?, ?> StickRollBlock_Generator = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, StickRollBlock.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(20))))).spreadHorizontally().repeat(2);
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("fixfps","stickroll"), StickRoll);
		Registry.register(Registry.BLOCK, new Identifier("fixfps","stickrollblock"), StickRollBlock); //registra il blocco nei blocchi esistenti
		Registry.register(Registry.ITEM, new Identifier("fixfps","stickrollblock"), StickRollBlock_ITEM); //registra il blocco piazzabile
		Registry.register(Registry.BLOCK, new Identifier("fixfps","rickrollblock"),RickRollBlock);
		Registry.register(Registry.ITEM, new Identifier("fixfps","rickrollblock"), RickRollBlock_ITEM);
		Registry.register(Registry.ITEM, new Identifier("fixfps","mangiaroll"), MangiaRoll);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rickaudio"), RICK_AUDIO); //registra questo evento audio all'avvio del gioco

		RegistryKey<ConfiguredFeature<?,?>> StickRollOreGen = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("fixfps","stickrollblock"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, StickRollOreGen.getValue(), StickRollBlock_Generator);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StickRollOreGen);
	}
}