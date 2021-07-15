package net.fixfps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RickRollBlock extends Block {
 
    public RickRollBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity placedBy, Hand hand, BlockHitResult blockHitResult) {
        if (!world.isClient) {
            try {
                world.playSound(null, blockPos, MainClass.RICK_AUDIO, SoundCategory.BLOCKS, 1f, 1f);
                placedBy.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,MoFunctions.ConvertToPotionSeconds(9),5));
                placedBy.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,MoFunctions.ConvertToPotionSeconds(9),5));
            } catch (Exception e) {
               return ActionResult.PASS;
            }
        }
        return ActionResult.SUCCESS;
    }
}
