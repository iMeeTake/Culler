package com.imeetake.culler;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RangeConstraint;

@Modmenu(modId = "culler")
@Config(name = "culler", wrapperName = "CullerConfig")
public class CullerConfigModel {

    public boolean enableCulling = true;
    public boolean enableFovCulling = true;

    @RangeConstraint(min = 8, max = 128)
    public double signDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double paintingDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double itemFrameDistance = 40.0;

    @RangeConstraint(min = 8, max = 128)
    public double armorStandDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double bannerDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double chestDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double beaconDistance = 64.0;

    @RangeConstraint(min = 8, max = 128)
    public double lecternDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double campfireDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double endCrystalDistance = 64.0;

    @RangeConstraint(min = 8, max = 128)
    public double shulkerBoxDistance = 32.0;

    @RangeConstraint(min = 8, max = 128)
    public double enchantingTableDistance = 32.0;

    @RangeConstraint(min = 8, max = 128)
    public double brewingStandDistance = 32.0;

    @RangeConstraint(min = 8, max = 128)
    public double furnaceDistance = 32.0;

    @RangeConstraint(min = 8, max = 128)
    public double hopperDistance = 24.0;

    @RangeConstraint(min = 8, max = 128)
    public double dispenserDistance = 32.0;

    @RangeConstraint(min = 8, max = 128)
    public double jukeboxDistance = 32.0;

    @RangeConstraint(min = 8, max = 128)
    public double bellDistance = 32.0;

    @RangeConstraint(min = 8, max = 128)
    public double conduitDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double sculkDistance = 32.0;

    @RangeConstraint(min = 4, max = 64)
    public double droppedItemDistance = 16.0;

    @RangeConstraint(min = 4, max = 64)
    public double experienceOrbDistance = 12.0;

    @RangeConstraint(min = 8, max = 128)
    public double boatDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double minecartDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double tntDistance = 48.0;

    @RangeConstraint(min = 8, max = 128)
    public double arrowDistance = 64.0;

    @RangeConstraint(min = 90, max = 180)
    public double fovCullAngle = 135.0;

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

    public boolean cullEmptySigns = true;
    public boolean cullSmallItemFrames = true;
    public boolean cullEmptyBoats = true;
    public boolean cullEmptyMinecarts = true;

    @RangeConstraint(min = 0.1, max = 2.0)
    public double distanceMultiplier = 1.0;
}