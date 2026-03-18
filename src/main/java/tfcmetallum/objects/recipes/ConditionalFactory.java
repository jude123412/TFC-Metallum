package tfcmetallum.objects.recipes;

import java.util.function.BooleanSupplier;

import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

import com.google.gson.JsonObject;

import tfcmetallum.ConfigTFCM;
import tfcmetallum.util.IsObtainable;

public class ConditionalFactory implements IConditionFactory {

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json) {
        String type = JsonUtils.getString(json, "config");

        return switch (type) {
            case "aluminium" -> () -> ConfigTFCM.METALS.aluminium;
            case "beryllium_copper" -> () -> IsObtainable.beryllim_copper;
            case "boron" -> () -> ConfigTFCM.METALS.boron;
            case "cobalt" -> () -> ConfigTFCM.METALS.cobalt;
            case "invar" -> () -> ConfigTFCM.METALS.invar;
            case "manyullyn" -> () -> IsObtainable.manyullyn;
            case "mithril" -> () -> IsObtainable.mithril;
            case "nickel_silver" -> () -> ConfigTFCM.METALS.nickel_silver;
            case "osmium" -> () -> ConfigTFCM.METALS.osmium;
            case "titanium" -> () -> ConfigTFCM.METALS.titanum;
            case "tungsten" -> () -> ConfigTFCM.METALS.tungsten;
            case "tungsten_steel" -> () -> IsObtainable.tungsten_steel;
            case "zircaloy" -> () -> IsObtainable.zircaloy;
            case "iridium" -> () -> ConfigTFCM.METALS.iridium;
            case "lumium" -> () -> ConfigTFCM.METALS.lumium;
            case "signalum" -> () -> ConfigTFCM.METALS.signalum;
            case "enderium" -> () -> ConfigTFCM.METALS.enderium;
            case "electrum_flux" -> () -> ConfigTFCM.METALS.fluxed_electrum;
            default ->
                // Fail-safe for log spam, should never be used
                () -> false;
        };
    }
}
