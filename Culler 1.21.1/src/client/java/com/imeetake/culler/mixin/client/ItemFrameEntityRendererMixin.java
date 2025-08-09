package com.imeetake.culler.mixin.client;

import com.imeetake.culler.CullManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemFrameEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.ItemFrameEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemFrameEntityRenderer.class)
public class ItemFrameEntityRendererMixin {

    @Inject(method = "render(Lnet/minecraft/entity/decoration/ItemFrameEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At("HEAD"),
            cancellable = true)
    private void culler$cullItemFrames(ItemFrameEntity itemFrameEntity, float yaw, float tickDelta,
                                       MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider,
                                       int light, CallbackInfo ci) {

        if (!CullManager.shouldRenderItemFrame(itemFrameEntity)) {
            ci.cancel();
        }
    }
}