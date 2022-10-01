package net.fabricmc.signfile;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class log implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("SignFile");
	public static boolean isPlayerSneaking = false;

	@Override
	public void onInitialize() {
		LOGGER.info("Loaded!");
	}
}
