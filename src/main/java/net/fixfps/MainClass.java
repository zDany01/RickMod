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
	
	public static ItemGroup RickCreativeTab = new RickCreativeTab(10, "rickctab");
	public static final Item StickRoll = new Item(new Item.Settings().group(RickCreativeTab)); //crea l'item
	public static final Block StickRollBlock = new StickRollOre(FabricBlockSettings.of(Material.STONE).strength(4.5F, 4.5F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool()); //crea il blocco
	public static final Item StickRollBlock_ITEM = new BlockItem(StickRollBlock, new Item.Settings().group(RickCreativeTab)); //crea l'item del blocco(ndr quello nell'invetario che si può piazzare)
	public static final Block RickRollBlock = new RickRollBlock(FabricBlockSettings.of(Material.WOOD).strength(2, 10F).sounds(BlockSoundGroup.AMETHYST_CLUSTER).breakByHand(true));
	public static final Item RickRollBlock_ITEM = new BlockItem(RickRollBlock, new Item.Settings().group(RickCreativeTab));
	public static final Item MangiaRoll = new Item(new Item.Settings().group(RickCreativeTab).food(MagnateElCibo.MangiaRoll));
	public static SoundEvent RICK_AUDIO = new SoundEvent(new Identifier("fixfps","rickaudio")); //crea un nuovo envento che genera un suono che viene identificato con "fixfps:rickaudio"(Controlla il file json contiene la posizione)
	public static final Block RickTorch = new RickTorch(FabricBlockSettings.of(Material.DECORATION).breakInstantly().breakByHand(true).luminance(20).noCollision().nonOpaque());
	public static final Item RickTorch_ITEM = new BlockItem(RickTorch, new Item.Settings().group(RickCreativeTab));
	public static SoundEvent RICK1 = new SoundEvent(new Identifier("fixfps","rick1"));
    public static SoundEvent RICK2 = new SoundEvent(new Identifier("fixfps","rick2"));
    public static SoundEvent RICK3 = new SoundEvent(new Identifier("fixfps","rick3"));
    public static SoundEvent RICK4 = new SoundEvent(new Identifier("fixfps","rick4"));
    public static SoundEvent RICK5 = new SoundEvent(new Identifier("fixfps","rick5"));
    public static SoundEvent RICK6 = new SoundEvent(new Identifier("fixfps","rick6"));
    public static SoundEvent RICK7 = new SoundEvent(new Identifier("fixfps","rick7"));
    public static SoundEvent RICK8 = new SoundEvent(new Identifier("fixfps","rick8"));
    public static SoundEvent RICK9 = new SoundEvent(new Identifier("fixfps","rick9"));


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
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick1"), RICK1);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick2"), RICK2);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick3"), RICK3);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick4"), RICK4);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick5"), RICK5);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick6"), RICK6);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick7"), RICK7);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick8"), RICK8);
		Registry.register(Registry.SOUND_EVENT, new Identifier("fixfps","rick9"), RICK9);
		Registry.register(Registry.BLOCK, new Identifier("fixfps","ricktorch"), RickTorch);
		Registry.register(Registry.ITEM, new Identifier("fixfps","ricktorch"), RickTorch_ITEM);
		RegistryKey<ConfiguredFeature<?,?>> StickRollOreGen = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("fixfps","stickrollblock"));


		//BlockRenderLayerMap.INSTANCE.putBlock(RickTorch, RenderLayer.getCutout());

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, StickRollOreGen.getValue(), StickRollBlock_Generator);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, StickRollOreGen);
	}
}