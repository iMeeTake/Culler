package com.imeetake.culler.mixin.client;

import com.imeetake.culler.CullManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PaintingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PaintingEntityRenderer.class)
public class PaintingEntityRendererMixin {

    @Inject(method = "render(Lnet/minecraft/entity/decoration/painting/PaintingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At("HEAD"),
            cancellable = true)
    private void culler$cullPaintings(PaintingEntity paintingEntity, float yaw, float tickDelta,
                                      MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider,
                                      int light, CallbackInfo ci) {

        if (!CullManager.shouldRenderPainting(paintingEntity)) {
            ci.cancel();
        }
    }
}