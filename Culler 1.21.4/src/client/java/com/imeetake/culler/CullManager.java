package com.imeetake.culler;

import com.imeetake.tlib.client.render.TClientRenderUtils;
import net.minecraft.block.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import static com.imeetake.culler.CullerClient.CONFIG;

public class CullManager {

    public static void initialize() {
    }

    public static boolean shouldRenderBlockEntity(BlockEntity blockEntity, BlockPos pos) {
        if (!CONFIG.enableCulling()) return true;

        if (blockEntity instanceof SignBlockEntity signEntity && CONFIG.cullSigns()) {
            return shouldRenderSign(signEntity, pos);
        }
        if (blockEntity instanceof BannerBlockEntity && CONFIG.cullBanners()) {
            return shouldRenderWithDistance(pos, CONFIG.bannerDistance());
        }
        if (blockEntity instanceof ChestBlockEntity && CONFIG.cullChests()) {
            return shouldRenderWithDistance(pos, CONFIG.chestDistance());
        }
        if (blockEntity instanceof BeaconBlockEntity && CONFIG.cullBeacons()) {
            return shouldRenderWithDistance(pos, CONFIG.beaconDistance());
        }
        if (blockEntity instanceof LecternBlockEntity && CONFIG.cullLecterns()) {
            return shouldRenderWithDistance(pos, CONFIG.lecternDistance());
        }
        if (blockEntity instanceof CampfireBlockEntity && CONFIG.cullCampfires()) {
            return shouldRenderWithDistance(pos, CONFIG.campfireDistance());
        }
        if (blockEntity instanceof ShulkerBoxBlockEntity && CONFIG.cullShulkerBoxes()) {
            return shouldRenderWithDistance(pos, CONFIG.shulkerBoxDistance());
        }
        if (blockEntity instanceof EnchantingTableBlockEntity && CONFIG.cullEnchantingTables()) {
            return shouldRenderWithDistance(pos, CONFIG.enchantingTableDistance());
        }
        if (blockEntity instanceof BrewingStandBlockEntity && CONFIG.cullBrewingStands()) {
            return shouldRenderWithDistance(pos, CONFIG.brewingStandDistance());
        }
        if ((blockEntity instanceof FurnaceBlockEntity || blockEntity instanceof SmokerBlockEntity ||
                blockEntity instanceof BlastFurnaceBlockEntity) && CONFIG.cullFurnaces()) {
            return shouldRenderWithDistance(pos, CONFIG.furnaceDistance());
        }
        if (blockEntity instanceof HopperBlockEntity && CONFIG.cullHoppers()) {
            return shouldRenderWithDistance(pos, CONFIG.hopperDistance());
        }
        if ((blockEntity instanceof DispenserBlockEntity || blockEntity instanceof DropperBlockEntity) && CONFIG.cullDispensers()) {
            return shouldRenderWithDistance(pos, CONFIG.dispenserDistance());
        }
        if (blockEntity instanceof JukeboxBlockEntity && CONFIG.cullJukeboxes()) {
            return shouldRenderWithDistance(pos, CONFIG.jukeboxDistance());
        }
        if (blockEntity instanceof BellBlockEntity && CONFIG.cullBells()) {
            return shouldRenderWithDistance(pos, CONFIG.bellDistance());
        }
        if (blockEntity instanceof ConduitBlockEntity && CONFIG.cullConduits()) {
            return shouldRenderWithDistance(pos, CONFIG.conduitDistance());
        }
        if ((blockEntity instanceof SculkShriekerBlockEntity || blockEntity instanceof SculkSensorBlockEntity) && CONFIG.cullSculkBlocks()) {
            return shouldRenderWithDistance(pos, CONFIG.sculkDistance());
        }

        return true;
    }

    public static boolean shouldRenderSign(SignBlockEntity signEntity, BlockPos pos) {
        if (!CONFIG.enableCulling() || !CONFIG.cullSigns()) return true;

        if (CONFIG.cullEmptySigns() && isSignEmpty(signEntity)) {
            return shouldRenderWithDistance(pos, CONFIG.signDistance() * 0.5);
        }

        return shouldRenderWithDistance(pos, CONFIG.signDistance());
    }

    public static boolean shouldRenderPainting(PaintingEntity painting) {
        if (!CONFIG.enableCulling() || !CONFIG.cullPaintings()) return true;
        return shouldRenderEntity(painting, CONFIG.paintingDistance());
    }

    public static boolean shouldRenderItemFrame(ItemFrameEntity itemFrame) {
        if (!CONFIG.enableCulling() || !CONFIG.cullItemFrames()) return true;

        double distance = CONFIG.itemFrameDistance();

        if (CONFIG.cullSmallItemFrames() && itemFrame.getType().toString().contains("glow")) {
            distance *= 0.75;
        }

        return shouldRenderEntity(itemFrame, distance);
    }

    public static boolean shouldRenderArmorStand(ArmorStandEntity armorStand) {
        if (!CONFIG.enableCulling() || !CONFIG.cullArmorStands()) return true;
        return shouldRenderEntity(armorStand, CONFIG.armorStandDistance());
    }

    public static boolean shouldRenderEndCrystal(EndCrystalEntity endCrystal) {
        if (!CONFIG.enableCulling() || !CONFIG.cullEndCrystals()) return true;
        return shouldRenderEntity(endCrystal, CONFIG.endCrystalDistance());
    }

    public static boolean shouldRenderDroppedItem(ItemEntity itemEntity) {
        if (!CONFIG.enableCulling() || !CONFIG.cullDroppedItems()) return true;
        return shouldRenderEntity(itemEntity, CONFIG.droppedItemDistance());
    }

    public static boolean shouldRenderExperienceOrb(ExperienceOrbEntity experienceOrb) {
        if (!CONFIG.enableCulling() || !CONFIG.cullExperienceOrbs()) return true;
        return shouldRenderEntity(experienceOrb, CONFIG.experienceOrbDistance());
    }

    public static boolean shouldRenderBoat(BoatEntity boat) {
        if (!CONFIG.enableCulling() || !CONFIG.cullBoats()) return true;

        double distance = CONFIG.boatDistance();

        if (CONFIG.cullStaticBoats() && boat.getVelocity().lengthSquared() < 0.01) {
            distance *= 0.75;
        }

        return shouldRenderEntity(boat, distance);
    }

    public static boolean shouldRenderMinecart(MinecartEntity minecart) {
        if (!CONFIG.enableCulling() || !CONFIG.cullMinecarts()) return true;

        double distance = CONFIG.minecartDistance();

        if (CONFIG.cullEmptyMinecarts() && !minecart.hasPassengers()) {
            distance *= 0.8;
        }

        return shouldRenderEntity(minecart, distance);
    }

    public static boolean shouldRenderTnt(TntEntity tnt) {
        if (!CONFIG.enableCulling() || !CONFIG.cullTnt()) return true;
        return shouldRenderEntity(tnt, CONFIG.tntDistance());
    }

    public static boolean shouldRenderArrow(Entity arrow) {
        if (!CONFIG.enableCulling() || !CONFIG.cullArrows()) return true;
        return shouldRenderEntity(arrow, CONFIG.arrowDistance());
    }

    private static boolean shouldRenderWithDistance(BlockPos pos, double maxDistance) {
        try {
            Vec3d cameraPos = getCameraPosition();
            Vec3d blockPos = Vec3d.of(pos).add(0.5, 0.5, 0.5);

            double distance = cameraPos.distanceTo(blockPos) * CONFIG.distanceMultiplier();
            if (distance > maxDistance) return false;

            if (CONFIG.enableFovCulling() && !isInFOV(cameraPos, blockPos)) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean shouldRenderEntity(Entity entity, double maxDistance) {
        try {
            Vec3d cameraPos = getCameraPosition();
            Vec3d entityPos = entity.getPos();

            double distance = cameraPos.distanceTo(entityPos) * CONFIG.distanceMultiplier();
            if (distance > maxDistance) return false;

            if (CONFIG.enableFovCulling() && !isInFOV(cameraPos, entityPos)) {
                return false;
            }


            return true;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean isSignEmpty(SignBlockEntity signEntity) {
        for (int i = 0; i < 4; i++) {
            Text text = signEntity.getText(true).getMessage(i, false);
            if (text != null && !text.getString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private static Vec3d getCameraPosition() {
        return TClientRenderUtils.getCameraPosition();
    }

    private static Vec3d getCameraLookVector() {
        return TClientRenderUtils.getCameraLookVector();
    }


    private static boolean isInFOV(Vec3d cameraPos, Vec3d targetPos) {
        Vec3d lookVector = getCameraLookVector();
        Vec3d toTarget = targetPos.subtract(cameraPos).normalize();

        double dotProduct = lookVector.dotProduct(toTarget);
        double angle = Math.toDegrees(Math.acos(Math.max(-1.0, Math.min(1.0, dotProduct))));

        double cullAngle = CONFIG.fovCullAngle();

        return angle <= cullAngle / 2.0;
    }
}