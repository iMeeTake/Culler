package com.imeetake.culler;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RangeConstraint;

@Modmenu(modId = "culler")
@Config(name = "culler", wrapperName = "CullerConfig")
public class CullerConfigModel {

    public boolean enableCulling = true;
    public boolean enableFovCulling = true;

    @RangeConstraint(min = 0, max = 120)
    public int fovBuffer = 60;

    @RangeConstraint(min = 8, max = 128)
    public int signDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int paintingDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int itemFrameDistance = 40;

    @RangeConstraint(min = 8, max = 128)
    public int armorStandDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int bannerDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int chestDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int beaconDistance = 64;

    @RangeConstraint(min = 8, max = 128)
    public int lecternDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int campfireDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int endCrystalDistance = 64;

    @RangeConstraint(min = 8, max = 128)
    public int shulkerBoxDistance = 32;

    @RangeConstraint(min = 8, max = 128)
    public int enchantingTableDistance = 32;

    @RangeConstraint(min = 8, max = 128)
    public int brewingStandDistance = 32;

    @RangeConstraint(min = 8, max = 128)
    public int furnaceDistance = 32;

    @RangeConstraint(min = 8, max = 128)
    public int hopperDistance = 24;

    @RangeConstraint(min = 8, max = 128)
    public int dispenserDistance = 32;

    @RangeConstraint(min = 8, max = 128)
    public int jukeboxDistance = 32;

    @RangeConstraint(min = 8, max = 128)
    public int bellDistance = 32;

    @RangeConstraint(min = 8, max = 128)
    public int conduitDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int sculkDistance = 32;

    @RangeConstraint(min = 4, max = 64)
    public int droppedItemDistance = 16;

    @RangeConstraint(min = 4, max = 64)
    public int experienceOrbDistance = 12;

    @RangeConstraint(min = 8, max = 128)
    public int boatDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int minecartDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int tntDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int arrowDistance = 64;

    @RangeConstraint(min = 8, max = 128)
    public int itemDisplayDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int blockDisplayDistance = 48;

    @RangeConstraint(min = 8, max = 128)
    public int textDisplayDistance = 64;

    public boolean cullSigns = true;
    public boolean cullPaintings = true;
    public boolean cullItemFrames = true;
    public boolean cullArmorStands = true;
    public boolean cullBanners = true;
    public boolean cullChests = true;
    public boolean cullBeacons = true;
    public boolean cullLecterns = true;
    public boolean cullCampfires = true;
    public boolean cullEndCrystals = true;
    public boolean cullShulkerBoxes = true;
    public boolean cullEnchantingTables = true;
    public boolean cullBrewingStands = true;
    public boolean cullFurnaces = true;
    public boolean cullHoppers = true;
    public boolean cullDispensers = true;
    public boolean cullJukeboxes = true;
    public boolean cullBells = true;
    public boolean cullConduits = true;
    public boolean cullSculkBlocks = true;
    public boolean cullDroppedItems = true;
    public boolean cullExperienceOrbs = true;
    public boolean cullBoats = true;
    public boolean cullMinecarts = true;
    public boolean cullTnt = true;
    public boolean cullArrows = true;

    public boolean cullItemDisplays = true;
    public boolean cullBlockDisplays = true;
    public boolean cullTextDisplays = true;

    public boolean cullEmptySigns = true;
    public boolean cullSmallItemFrames = true;
    public boolean cullEmptyBoats = true;
    public boolean cullEmptyMinecarts = true;

    @RangeConstraint(min = 0.1, max = 2.0)
    public double distanceMultiplier = 1.0;
}