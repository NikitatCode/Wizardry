package ru.nikitat.wizardry.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.nikitat.wizardry.tileentity.TileEntityFoMF;

public class WizardryClientProxy extends WizardryCommonProxy {
	
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFoMF.class, new AlchemicalCauldronRender());
    }

    /*@Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        //return ID==0?new GuiFurnaceOfMysticalFire(player.inventory, (TileEntityFoMF) world.getTileEntity(x,y,z)):null;
    }*/

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

    }
	
}
