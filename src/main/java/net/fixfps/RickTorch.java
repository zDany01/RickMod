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
import net.minecraft.block.ShapeContext;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class RickTorch extends Block {


    protected RickTorch(Settings settings) {
        super(settings);}


    public static int numrick = 0;

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {
                world.playSound(null, pos, new SoundEvent(new Identifier("fixfps","rick" + (++numrick))), SoundCategory.PLAYERS, 0.1F, 1F);
                if (numrick>=9){numrick = 0;}
        }
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
       return VoxelShapes.cuboid(0.40,0,0.40,0.60,0.65,0.60);
    }
    
    
}
