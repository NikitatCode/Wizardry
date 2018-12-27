package ru.nikitat.wizardry.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.nikitat.nikitatcore.api.NikitatItem;

public class TabIconItem extends Item implements NikitatItem{

    public TabIconItem() {
        this.setRegistryName("wizardrynt", "ctab_wizardry_icon");
        //ForgeRegistries.ITEMS.register(this);
    }

    @Override
    public void postRegWithThaumcraft() {

    }

    @Override
    public void postRegWithWizardry() {

    }

    @Override
    public void postReg() {

    }

    public void setRender() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
}
