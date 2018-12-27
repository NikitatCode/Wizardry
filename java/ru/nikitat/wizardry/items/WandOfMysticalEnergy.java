package ru.nikitat.wizardry.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import ru.nikitat.nikitatcore.api.NikitatItem;
import ru.nikitat.wizardry.WizardryEventHandler;
import ru.nikitat.wizardry.WizardryMod;

import javax.annotation.Nullable;
import java.util.List;

import static java.lang.Short.MAX_VALUE;

public class WandOfMysticalEnergy extends Item implements NikitatItem {

    public WandOfMysticalEnergy() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(WizardryMod.tab);
        this.maxStackSize = 1;
        setRegistryName("wizardrynt", "wand_of_mystical_energy");
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged)

    {
        return false;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == WizardryMod.tab) {
            items.add(new ItemStack(this, 1, 0));
            items.add(new ItemStack(this, 1, 1));
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setShort("runicink", Short.MAX_VALUE);
            ItemStack is = new ItemStack(this, 1, 2);
            is.setTagCompound(nbt);
            items.add(is);
        }
    }

    /*@SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister p_94581_1_) {
        this.icons = new IIcon[3];
        icons[1] = p_94581_1_.registerIcon("wizardrynt:WandOfMysticalEnergy");
        icons[2] = p_94581_1_.registerIcon("wizardrynt:wand_of_mystical_energy_with_runic_ink");
        icons[0] = p_94581_1_.registerIcon("wizardrynt:wand_of_mystical_energy.billet");
    }*/

    @Override
    public String getUnlocalizedName(ItemStack p_77667_1_) {
        String n = "";
        switch (MathHelper.clamp(p_77667_1_.getItemDamage(), 0, 2)) {
            case 1:
                n = "wand_of_mystical_energy";
                break;
            case 2:
                n = "wand_of_mystical_energy_with_runic_ink";
                break;
            case 0:
                n = "wand_of_mystical_energy.billet";
                break;
        }
        return n;
    }

    /*@Override
    public IIcon getIconFromDamage(int p_77617_1_) {
        return icons[MathHelper.clamp_int(p_77617_1_, 0, 2)];
    }*/


    @Override
    public void postReg() {
        //WizardryEventHandler.regrenderlist.add(this);
    }

    @Override
    public void setRender() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName() + "0", "inventory"));
        ModelLoader.setCustomModelResourceLocation(this, 1, new ModelResourceLocation(this.getRegistryName() + "1", "inventory"));
        ModelLoader.setCustomModelResourceLocation(this, 2, new ModelResourceLocation(this.getRegistryName() + "2", "inventory"));
    }

    @Override
    public void postRegWithThaumcraft() {
        //ThaumcraftApi.registerObjectTag(new ItemStack(new WandOfMysticalEnergy()), new int[]{0, 1}, new AspectList().add(Aspect.PLANT, 3).add(Aspect.TOOL, 3).add(Aspect.ENERGY, 1).add(Aspect.MAGIC, 3));
    }

    @Override
    public void postRegWithWizardry() {
    }

    @Override
    public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        if (p_77663_1_.getItemDamage() != 0) {
            if (p_77663_1_.getTagCompound() == null) p_77663_1_.setTagCompound(new NBTTagCompound());
            NBTTagCompound nbt = p_77663_1_.getTagCompound();
            if (nbt.hasKey("runicink")) {
                if (nbt.getShort("runicink") <= 0) p_77663_1_.setItemDamage(1);
                else p_77663_1_.setItemDamage(2);
            } else p_77663_1_.setItemDamage(1);
            if (nbt.hasKey("timer")) {
                if (nbt.getByte("timer") >= 20) {
                    if (nbt.hasKey("myse")) {
                        if (nbt.getShort("myse") < 2000) nbt.setShort("myse", (short) (nbt.getShort("myse") + 1));
                        nbt.setByte("timer", (byte) 1);
                    } else nbt.setShort("myse", (short) 1);
                } else nbt.setByte("timer", (byte) (nbt.getByte("timer") + 1));
            } else nbt.setByte("timer", (byte) 1);
        }
    }

    /*public boolean showDurabilityBar(ItemStack stack) {
        if (stack.getItemDamage() == 2) return true;
        else return false;
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        return /*((double) stack.stackTagCompound.getInteger("runicink")) / ((double)100)1.0;
    }*/

/*    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        if (stack.getItemDamage() == 2) return true;
        else return false;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return ((double) stack.getTagCompound().getShort("runicink"))/200;
    }
*/
    @Override
    public void addInformation(ItemStack itemStack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        if (itemStack.getItemDamage() != 0) {
            NBTTagCompound nbt = itemStack.getTagCompound();
            if (nbt != null) {
                int myse = 0;
                if (nbt.hasKey("myse")) myse = nbt.getShort("myse");
                list.add("§5" + I18n.format("myse.value.desc", new Object[]{}) + myse);
                if (itemStack.getItemDamage() == 2) {
                    int runicink = 0;
                    if ((nbt.hasKey("runicink")) && (itemStack.getItemDamage() == 2))
                        runicink = nbt.getShort("runicink");
                    list.add("§e" + I18n.format("runicink.value.desc", new Object[]{}) + runicink);
                }
            }
        }
    }

}
