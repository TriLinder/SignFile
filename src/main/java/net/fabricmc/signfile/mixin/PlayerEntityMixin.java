package net.fabricmc.signfile.mixin;

import net.fabricmc.signfile.log;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Shadow protected abstract boolean shouldDismount(); //Detect sneaking

    @Inject(at = @At("HEAD"), method = "tick()V")
    public void tick(CallbackInfo ci) {
        log.isPlayerSneaking = shouldDismount();
    }
}
