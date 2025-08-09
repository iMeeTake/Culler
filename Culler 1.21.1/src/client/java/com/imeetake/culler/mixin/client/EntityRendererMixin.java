package com.imeetake.culler.mixin.client;

import com.imeetake.culler.CullManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.render.entity.EntityRenderer.class)
public class EntityRendererMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void culler$cullEntities(Entity entity, float yaw, float tickDelta,
                                     MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider,
                                     int light, CallbackInfo ci) {

        if (entity instanceof ArmorStandEntity armorStand && !CullManager.shouldRenderArmorStand(armorStand)) {
            ci.cancel();
        } else if (entity instanceof EndCrystalEntity endCrystal && !CullManager.shouldRenderEndCrystal(endCrystal)) {
            ci.cancel();
        } else if (entity instanceof ItemEntity itemEntity && !CullManager.shouldRenderDroppedItem(itemEntity)) {
            ci.cancel();
        } else if (entity instanceof ExperienceOrbEntity experienceOrb && !CullManager.shouldRenderExperienceOrb(experienceOrb)) {
            ci.cancel();
        } else if (entity instanceof BoatEntity boat && !CullManager.shouldRenderBoat(boat)) {
            ci.cancel();
        } else if (entity instanceof MinecartEntity minecart && !CullManager.shouldRenderMinecart(minecart)) {
            ci.cancel();
        } else if (entity instanceof TntEntity tnt && !CullManager.shouldRenderTnt(tnt)) {
            ci.cancel();
        } else if ((entity instanceof ArrowEntity || entity instanceof SpectralArrowEntity) && !CullManager.shouldRenderArrow(entity)) {
            ci.cancel();
        }
    }
}