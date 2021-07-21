package net.fixfps;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RespawnGesu extends Item {

    public RespawnGesu(Settings settings){super(settings);}

    @Override
    @Environment(EnvType.CLIENT)
    public TypedActionResult<ItemStack> use(World world,PlayerEntity user, Hand hand ){
        if (world.isClient()){net.minecraft.client.MinecraftClient.getInstance().setScreen(new CottonClientScreen(new JesusGUI(user)));}
        return super.use(world, user, hand);
    }
    
    
}
