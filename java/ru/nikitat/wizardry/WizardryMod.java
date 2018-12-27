/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.nikitat.wizardry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.nikitat.nikitatcore.api.NikitatItem;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;
import ru.nikitat.wizardry.items.TabIconItem;
import ru.nikitat.wizardry.proxy.WizardryCommonProxy;

import java.util.HashMap;

/**
 * @author 1
 */
@Mod(modid = "wizardrynt")
public class WizardryMod {

    public static HashMap<String, Item> items = new HashMap<String, Item>();

    @Mod.Instance("wizardrynt")
    public static WizardryMod instance;

    @SidedProxy(clientSide = "ru.nikitat.wizardry.proxy.WizardryClientProxy", serverSide = "ru.nikitat.wizardry.proxy.WizardryServerProxy")
    public static WizardryCommonProxy proxy;

    public static CreativeTabs tab = new WizardryTab();
    public static Item tabIconItem;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new NikitatRegistry());
        tabIconItem=new TabIconItem();
        NikitatRegistry.registerItem((NikitatItem) tabIconItem);
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {

    }

    public static class WizardryTab extends CreativeTabs {


        public WizardryTab() {
            super("Wizardry");
        }

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(tabIconItem);
        }
    }
}

