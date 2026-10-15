package dev.s4fire.elytramace;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entry point for Elytra Mace.
 *
 * The mod is intentionally client-only. Features will be added in small,
 * buildable steps and tested in-game before being treated as complete.
 */
public final class ElytraMaceClient implements ClientModInitializer {
    public static final String MOD_ID = "elytra_mace";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Elytra Mace client initialized.");
    }
}
