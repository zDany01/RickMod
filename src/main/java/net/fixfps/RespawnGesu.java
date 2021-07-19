package net.fixfps;

import com.mojang.authlib.minecraft.client.MinecraftClient;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RespawnGesu extends Item {

    public RespawnGesu(Settings settings){super(settings);}

    @Override
    public TypedActionResult<ItemStack> use(World world,PlayerEntity user, Hand hand ){
        user.damage(DamageSource.DRAGON_BREATH, 2);
       return super.use(world, user, hand);
    }
    
    
}
