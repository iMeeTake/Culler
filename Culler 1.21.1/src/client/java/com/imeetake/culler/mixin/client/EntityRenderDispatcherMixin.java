package com.imeetake.culler.mixin.client;

import com.imeetake.culler.CullManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRenderDispatcherMixin {
    @Inject(
            method = "render(Lnet/minecraft/entity/Entity;DDDFFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void culler$cullEntities(
            Entity entity, double x, double y, double z, float yaw, float tickDelta,
            MatrixStack matrices, VertexConsumerProvider consumers, int light, CallbackInfo ci) {

        if (entity instanceof PaintingEntity p && !CullManager.shouldRenderPainting(p)) { ci.cancel(); return; }
        if (entity instanceof ItemFrameEntity f && !CullManager.shouldRenderItemFrame(f)) { ci.cancel(); return; }
        if (entity instanceof ArmorStandEntity a && !CullManager.shouldRenderArmorStand(a)) { ci.cancel(); return; }
        if (entity instanceof EndCrystalEntity e && !CullManager.shouldRenderEndCrystal(e)) { ci.cancel(); return; }
        if (entity instanceof ItemEntity i && !CullManager.shouldRenderDroppedItem(i)) { ci.cancel(); return; }
        if (entity instanceof ExperienceOrbEntity o && !CullManager.shouldRenderExperienceOrb(o)) { ci.cancel(); return; }
        if (entity instanceof BoatEntity b && !CullManager.shouldRenderBoat(b)) { ci.cancel(); return; }
        if (entity instanceof MinecartEntity m && !CullManager.shouldRenderMinecart(m)) { ci.cancel(); return; }
        if (entity instanceof TntEntity t && !CullManager.shouldRenderTnt(t)) { ci.cancel(); return; }
        if ((entity instanceof ArrowEntity || entity instanceof SpectralArrowEntity) && !CullManager.shouldRenderArrow(entity)) { ci.cancel(); }
        if (entity instanceof DisplayEntity.ItemDisplayEntity && !CullManager.shouldRenderItemDisplay(entity)) { ci.cancel(); return; }
        if (entity instanceof DisplayEntity.BlockDisplayEntity && !CullManager.shouldRenderBlockDisplay(entity)) { ci.cancel(); return; }
        if (entity instanceof DisplayEntity.TextDisplayEntity && !CullManager.shouldRenderTextDisplay(entity)) { ci.cancel(); }
    }
}