package tech.proudmuslim.andromeda.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;

import tech.proudmuslim.andromeda.Andromeda;

@Mixin(DefaultBiomeFeatures.class)
public abstract class DefaultBiomeFeaturesMixin {

    @Inject(method = "addDefaultOres", at = @At("TAIL"))
    private static void addDefaultOres(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Andromeda.getORE_SHULKER_OVERWORLD());
    }

    @Inject(method = "addPlainsFeatures", at = @At("TAIL"))
    private static void addPlainsFeatures(GenerationSettings.Builder builder, CallbackInfo ci) {
        builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, Andromeda.Companion.getEMERALD_SPIRAL_CONFIGURED());
    }

}
