package com.imeetake.culler;

import net.fabricmc.api.ClientModInitializer;

public class CullerClient implements ClientModInitializer {

	public static final com.imeetake.culler.CullerConfig CONFIG = com.imeetake.culler.CullerConfig.createAndLoad();

	@Override
	public void onInitializeClient() {
		CullManager.initialize();
	}
}