package com.proudmuslim.andromeda.mixin;

import jdk.nashorn.internal.codegen.CompilerConstants;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Mixins HAVE to be written in java due to constraints in the mixin system.
@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDeath(DamageSource source, CallbackInfo ci) {
        Entity attacker = source.getAttacker();
        if(attacker instanceof PlayerEntity) System.out.println(" a a a a a a a a a a aa a a a a ");
    }

}
