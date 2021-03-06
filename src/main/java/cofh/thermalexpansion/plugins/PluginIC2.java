package cofh.thermalexpansion.plugins;

import cofh.core.util.helpers.ItemHelper;
import cofh.thermalexpansion.util.managers.machine.CompactorManager;
import cofh.thermalexpansion.util.managers.machine.CompactorManager.Mode;
import cofh.thermalexpansion.util.managers.machine.InsolatorManager;
import cofh.thermalexpansion.util.managers.machine.RefineryManager;
import cofh.thermalfoundation.item.ItemMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

public class PluginIC2 extends PluginTEBase {

	public static final String MOD_ID = "ic2";
	public static final String MOD_ID_CLASSIC = "ic2-classic-spmod";
	public static final String MOD_NAME = "IndustrialCraft 2";

	public PluginIC2() {

		super(MOD_ID, MOD_NAME);
	}

	@Override
	public void initializeDelegate() {

		/* PULVERIZER */
		{
			//			ItemStack bioChaff = getItemStack("crafting", 1, 21);
			//
			//			int energy = PulverizerManager.DEFAULT_ENERGY;
			//
			//			PulverizerManager.addRecipe(energy, bioChaff, new ItemStack(Blocks.DIRT));
		}

		/* INSOLATOR */
		{
			String name = Loader.isModLoaded(MOD_ID_CLASSIC) ? "blockrubwood" : "rubber_wood";
			ItemStack logRubber = getItemStack(name, 1, 0);
			name = Loader.isModLoaded(MOD_ID_CLASSIC) ? "blockrubsapling" : "sapling";
			ItemStack saplingRubber = getItemStack(name, 1, 0);

			InsolatorManager.addDefaultTreeRecipe(saplingRubber, ItemHelper.cloneStack(logRubber, 6), saplingRubber);
		}

		/* COMPACTOR */
		{
			String name = Loader.isModLoaded(MOD_ID_CLASSIC) ? "itemmisc" : "crafting";
			int metaBase  = Loader.isModLoaded(MOD_ID_CLASSIC) ? 250 : 16;
			ItemStack coalBall = getItemStack(name, 1, metaBase);
			ItemStack coalBallCompressed = getItemStack(name, 1, metaBase + 1);
			ItemStack coalChunk = getItemStack(name, 1, metaBase + 2);

			int energy = CompactorManager.DEFAULT_ENERGY;

			CompactorManager.addRecipe(energy, ItemHelper.cloneStack(ItemMaterial.dustCoal, 8), coalBall, Mode.ALL);
			CompactorManager.addRecipe(energy, coalBall, coalBallCompressed, Mode.ALL);
			CompactorManager.addRecipe(energy, ItemHelper.cloneStack(coalBallCompressed, 8), coalChunk, Mode.ALL);
			CompactorManager.addRecipe(energy, coalChunk, ItemMaterial.gemDiamond, Mode.ALL);
		}

		/* REFINERY */
		{
			Fluid biomass = FluidRegistry.getFluid("ic2biomass");
			Fluid biogas = FluidRegistry.getFluid("ic2biogas");

			int energy = RefineryManager.DEFAULT_ENERGY * 2;

			if (biomass != null && biogas != null) {
				RefineryManager.addRecipe(energy, new FluidStack(biomass, 25), new FluidStack(biogas, 500), getItemStack("crop_res", 1, 2), 5);
			}
		}

		/* BREWER */
		{
			//			ItemStack bioChaff = getItemStack("crafting", 1, 21);
			//			Fluid biomass = FluidRegistry.getFluid("ic2biomass");
			//
			//			int energy = BrewerManager.DEFAULT_ENERGY * 2;
			//
			//			if (biomass != null) {
			//				BrewerManager.addRecipe(energy, bioChaff, new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME), new FluidStack(biomass, Fluid.BUCKET_VOLUME));
			//			}
		}
	}

}
