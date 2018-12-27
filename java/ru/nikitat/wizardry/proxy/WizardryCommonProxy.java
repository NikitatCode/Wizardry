package ru.nikitat.wizardry.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.nikitat.nikitatcore.api.IHaveItemBlock;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;
import ru.nikitat.wizardry.WizardryEventHandler;
import ru.nikitat.wizardry.blocks.*;
import ru.nikitat.wizardry.gen.WizardryWorldGenerator;
import ru.nikitat.wizardry.items.WandOfMysticalEnergy;

public class WizardryCommonProxy implements IGuiHandler {
	
    public void preInit(FMLPreInitializationEvent event) {
        //WizardryMod.tab = new WizardryMod.WizardryTab();
        MinecraftForge.EVENT_BUS.register(new WizardryEventHandler());

        NikitatRegistry.registerINMNBlock(new BlockRunicStone());
        NikitatRegistry.registerINMNBlock(new BlockWizardryLeaves());
        NikitatRegistry.registerINMNBlock(new BlockWizardryLogs());
        NikitatRegistry.registerINMNBlock(new BlockWizardryFlowers());
        NikitatRegistry.registerINMNBlock(new BlockWizardrySaplings());
        NikitatRegistry.registerItem(new WandOfMysticalEnergy());
        NikitatRegistry.registerBlock(new BlockMysticalFire());
        GameRegistry.registerWorldGenerator(new WizardryWorldGenerator(), 0);
        //NikitatRegistry.registerBlockWithItemBlock(new BlockFurnaceOfMysticalFire(true));
        /*//GameRegistry.registerTileEntity(TileEntityFoMF.class, "TileEntityFoMF");
        GameRegistry.registerTileEntity(TileEntityMysticalFire.class, "TileEntityMysticalFire");*/
        //
        //WizardryItems.registerItems();
        //WizardryBlocks.registerBlocks();
        /*ItemRegistry.addToRegisterList(new WandOfNaturalEnergy());
        ItemRegistry.register();*/
        //registerItem(new WandOfNaturalEnergy());
    }

    public void init(FMLInitializationEvent event) {
        /*GameRegistry.rec.addRecipe(new RunicInkToWandRecipe());
        //GameRegistry.addShapelessRecipe(new ItemStack(NikitatRegistry.getItem("IWoME"), 1), new Object[] {NikitatRegistry.getBlock("BWLogs"), NikitatRegistry.getBlock("BWLogs")});
        GameRegistry.addRecipe(new ItemStack(NikitatRegistry.getItem("IWoME"), 1),
                new Object[]{ " A", "A ",
                        ('A'), NikitatRegistry.getBlock("BWLogs")});
        NBTTagCompound nbt = new NBTTagCompound();
        NBTTagCompound nbt2 = new NBTTagCompound();
        nbt2.setString("Name", StatCollector.translateToLocal("dopn"));
        nbt.setTag("display", nbt2);
        //nbt.setBoolean("wismop", true);
        ItemStack is = new ItemStack(Blocks.planks, 4, 5);
        is.setTagCompound(nbt);
        GameRegistry.addShapelessRecipe(is, new Object[] {NikitatRegistry.getBlock("BWLogs")});*/
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    /*public void registerItem(NikitatItem ni){
        GameRegistry.registerItem((Item) ni, ni.getRegName());
        ni.postReg();
        if (Loader.isModLoaded("Thaumcraft")) {
            ni.postRegWithThaumcraft();
            System.out.println("ththth");
        }
        WizardryMod.items.put(ni.getRegName(), (Item) ni);
    }*/

}
