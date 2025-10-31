package com.imeetake.culler.mixin.client;

import com.imeetake.culler.CullManager;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public abstract class EntityRendererMixin<T extends Entity> {

    @Inject(
            method = "shouldRender",
            at = @At("HEAD"),
            cancellable = true
    )
    private void culler$cullEntities(
            T entity, Frustum frustum, double x, double y, double z,
            CallbackInfoReturnable<Boolean> cir) {

        if (entity instanceof PaintingEntity p && !CullManager.shouldRenderPainting(p)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof ItemFrameEntity f && !CullManager.shouldRenderItemFrame(f)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof ArmorStandEntity a && !CullManager.shouldRenderArmorStand(a)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof EndCrystalEntity e && !CullManager.shouldRenderEndCrystal(e)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof ItemEntity i && !CullManager.shouldRenderDroppedItem(i)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof ExperienceOrbEntity o && !CullManager.shouldRenderExperienceOrb(o)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof BoatEntity b && !CullManager.shouldRenderBoat(b)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof MinecartEntity m && !CullManager.shouldRenderMinecart(m)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof TntEntity t && !CullManager.shouldRenderTnt(t)) {
            cir.setReturnValue(false);
            return;
        }
        if ((entity instanceof ArrowEntity || entity instanceof SpectralArrowEntity) && !CullManager.shouldRenderArrow(entity)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof DisplayEntity.ItemDisplayEntity && !CullManager.shouldRenderItemDisplay(entity)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof DisplayEntity.BlockDisplayEntity && !CullManager.shouldRenderBlockDisplay(entity)) {
            cir.setReturnValue(false);
            return;
        }
        if (entity instanceof DisplayEntity.TextDisplayEntity && !CullManager.shouldRenderTextDisplay(entity)) {
            cir.setReturnValue(false);
        }
    }
}