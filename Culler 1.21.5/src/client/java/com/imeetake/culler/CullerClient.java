package com.imeetake.culler;

import net.fabricmc.api.ClientModInitializer;

public class CullerClient implements ClientModInitializer {

	public static final CullerConfig CONFIG = CullerConfig.createAndLoad();

	@Override
	public void onInitializeClient() {
		CullManager.initialize();
	}
}