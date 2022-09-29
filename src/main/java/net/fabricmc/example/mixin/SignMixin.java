package net.fabricmc.example.mixin;

import net.fabricmc.example.log;
import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.block.entity.SignBlockEntity;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.io.BufferedReader;
import com.google.gson.Gson;

import net.fabricmc.loader.api.FabricLoader;

@Mixin(SignEditScreen.class)
public class SignMixin {
	@Shadow private String[] text;
	@Shadow private SignBlockEntity sign;

	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		log.LOGGER.info("Sign mixin sucess.");

		log.LOGGER.info(String.valueOf(text[0]));

		log.LOGGER.info("Setting empty lines.");

		text[0] = "";
		text[1] = "";
		text[2] = "";
		text[3] = "";

		log.LOGGER.info("Loading signs.json");

		try {
			HashMap<String, String> conf = loadConfig();

			log.LOGGER.info("Parsing");

			String val = String.valueOf(conf.get(String.valueOf(sign.getPos().getX()) + "," + String.valueOf(sign.getPos().getY()) + "," + String.valueOf(sign.getPos().getZ())));
			//String val = String.valueOf(conf.get("0,0,0"));

			log.LOGGER.info("Setting text");

			if (String.valueOf(val) != "null") {
				String[] lines = val.split("\n");
				
				log.LOGGER.info("Line 1: " + lines[0]);
				log.LOGGER.info("Line 2: " + lines[1]);
				log.LOGGER.info("Line 3: " + lines[2]);
				log.LOGGER.info("Line 4:" + lines[3]);

				for(int i = 0; i < 4; i++) {
					text[i] = lines[i];
				}
			}
			else {
				log.LOGGER.info("Placed sign's coordinates not found in signs.json");
				text[1] = "Invalid";
				text[2] = "coordinates.";
			}
		} catch (FileNotFoundException e) {
			log.LOGGER.info("Could not load signs.json");
			text[1] = "Missing";
			text[2] = "file.";
		}

		log.LOGGER.info("Finish editing");
		finishEditing();
		// MinecraftClient.getInstance().setScreen(null);
	}
	
	private static Path getConfigPath() {
        return FabricLoader.getInstance().getConfigDir().resolve("signs.json");
    }

	public HashMap<String, String> loadConfig() throws FileNotFoundException {
		String path = String.valueOf(getConfigPath());
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

		Gson gson = new Gson();
		HashMap<String, String> json = gson.fromJson(bufferedReader, HashMap.class);
		return json;
	}	


	@Shadow
	private void finishEditing()
	{
		
	}

}
