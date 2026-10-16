package dev.s4fire.elytramace;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entry point for Elytra Mace.
 *
 * The configurable toggle is the foundation for the mod's client-side
 * features. The key can be reassigned in Options -> Controls -> Key Binds.
 */
public final class ElytraMaceClient implements ClientModInitializer {
    public static final String MOD_ID = "elytra_mace";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final KeyMapping.Category CATEGORY =
            KeyMapping.Category.register(Identifier.fromNamespaceAndPath(MOD_ID, "controls"));

    private static final KeyMapping TOGGLE_KEY = KeyMappingHelper.registerKeyMapping(
            new KeyMapping(
                    "key.elytra_mace.toggle",
                    InputConstants.Type.KEYBOARD,
                    InputConstants.KEY_X,
                    CATEGORY
            )
    );

    private static boolean enabled;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (TOGGLE_KEY.consumeClick()) {
                if (client.player == null || client.level == null) {
                    continue;
                }

                enabled = !enabled;
                client.player.sendSystemMessage(
                        Component.literal("Elytra Mace: " + (enabled ? "Enabled" : "Disabled"))
                );
                LOGGER.info("Elytra Mace toggled {}", enabled ? "on" : "off");
            }
        });

        LOGGER.info("Elytra Mace client initialized. Default toggle key: X");
    }

    public static boolean isEnabled() {
        return enabled;
    }
}
