package com.imeetake.culler.mixin.client;

import com.imeetake.culler.CullManager;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BlockEntityRenderer.class)
public interface BlockEntityRendererMixin<T extends BlockEntity> {

    @Inject(
            method = "isInRenderDistance",
            at = @At("HEAD"),
            cancellable = true
    )
    default void culler$checkRenderDistance(T blockEntity, Vec3d pos, CallbackInfoReturnable<Boolean> cir) {
        if (!CullManager.shouldRenderBlockEntity(blockEntity, blockEntity.getPos())) {
            cir.setReturnValue(false);
        }
    }
}