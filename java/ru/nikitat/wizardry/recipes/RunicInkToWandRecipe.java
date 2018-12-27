package ru.nikitat.wizardry.recipes;


import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RunicInkToWandRecipe{} /*implements IRecipe {

    private final ItemStack recipeOutput;
    public final List<ItemStack> recipeItems = new ArrayList<ItemStack>();

    public RunicInkToWandRecipe() {
        this.recipeOutput = new ItemStack(NikitatRegistry.getItem("IWoME"), 1, 2);
        recipeItems.add(new ItemStack(NikitatRegistry.getItem("IWoME"), 1, 2));
    }

    @Override
    public boolean matches(InventoryCrafting p_77569_1_, World p_77569_2_) {
        boolean w = false;
        boolean f = false;
        int inte = p_77569_1_.getSizeInventory() == 4 ? 2 : 9;
        for (int i = 0; i < inte; ++i) {
            for (int j = 0; j < inte; ++j) {
                ItemStack itemstack = p_77569_1_.getStackInRowAndColumn(j, i);
                if (itemstack != null) {
                    if (((itemstack.getItem() == NikitatRegistry.getItem("IWoME")) && (itemstack.getItemDamage() == 1)) && (itemstack.getTagCompound().getShort("myse") >= 10)) {
                        w = true;
                    } else if (itemstack.getItem() == Item.getItemFromBlock(NikitatRegistry.getBlock("BWFl")) && (itemstack.getItemDamage() == 1)) {
                        f = true;
                    }
                }
            }
        }
        return (w && f);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
        int wr = 0;
        int wc = 0;
        int inte = p_77572_1_.getSizeInventory() == 4 ? 2 : 9;
        for (int i = 0; i < inte; ++i) {
            for (int j = 0; j < inte; ++j) {
                ItemStack itemstack = p_77572_1_.getStackInRowAndColumn(j, i);
                if (itemstack != null) {
                    if (itemstack.getItem() == NikitatRegistry.getItem("IWoME")) {
                        wr = j;
                        wc = i;
                    }
                }
            }
        }
        ItemStack is = p_77572_1_.getStackInRowAndColumn(wr, wc).copy();
        NBTTagCompound nbt = is.getTagCompound();
        nbt.setShort("runicink", (short) 200);
        nbt.setShort("myse", (short) (nbt.getShort("myse") - 10));
        is.setItemDamage(2);
        return is;
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(NikitatRegistry.getItem("IWoME"), 1, 2);
    }

    @Override
    public IRecipe setRegistryName(ResourceLocation name) {
        return null;
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return null;
    }

    @Override
    public Class<IRecipe> getRegistryType() {
        return (Class<IRecipe>) this.getClass();
    }
}*/
