package net.fixfps;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RickTorch extends Block {

    public static int numrick = 0;

    public RickTorch(Settings settings) {super(settings);}

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {
                world.playSound(null, pos, new SoundEvent(new Identifier("fixfps","rick" + (++numrick))), SoundCategory.BLOCKS, 1f, 1f);
        }
    }
    
}
