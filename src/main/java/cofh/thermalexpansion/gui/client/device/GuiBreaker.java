package cofh.thermalexpansion.gui.client.device;

import cofh.thermalexpansion.gui.client.GuiTEBase;
import cofh.thermalexpansion.gui.container.ContainerTEBase;
import cofh.thermalexpansion.init.TEProps;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiBreaker extends GuiTEBase {

	public static final String TEX_PATH = TEProps.PATH_GUI_DEVICE + "breaker.png";
	public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

	public GuiBreaker(InventoryPlayer inventory, TileEntity tile) {

		super(new ContainerTEBase(inventory, tile), tile, inventory.player, TEXTURE);

		generateInfo("tab.thermalexpansion.device.breaker", 2);
	}

}
