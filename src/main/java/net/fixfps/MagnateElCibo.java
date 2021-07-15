package net.fixfps;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
public class MagnateElCibo {
    public static final FoodComponent MangiaRoll = (new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, MoFunctions.ConvertToPotionSeconds(30),1), 1F)).alwaysEdible().build();
}
