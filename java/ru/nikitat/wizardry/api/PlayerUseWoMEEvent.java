package ru.nikitat.wizardry.api;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class PlayerUseWoMEEvent extends Event {

    private ItemStack is;
    private PlayerInteractEvent playerInteractEvent;

    public PlayerUseWoMEEvent(PlayerInteractEvent event, ItemStack is) {
        playerInteractEvent = event;
        this.is = is;
        if (!is.hasTagCompound()) is.setTagCompound(new NBTTagCompound());
    }

    public ItemStack getItemStack() {
        return is;
    }

    public PlayerInteractEvent getPlayerInteractEvent() {
        return playerInteractEvent;
    }

    public boolean isBillet() {
        return is.getItemDamage() == 0;
    }

    public boolean hasRunicInk() {
        return is.getTagCompound().hasKey("runicink") ? is.getTagCompound().getShort("runicink") > 0 : false;
    }

    public boolean hasMysEnergy() {
        return is.getTagCompound().hasKey("myse") ? is.getTagCompound().getShort("myse") > 0 : false;
    }

    public boolean addRunicInk(short ri) {
        if (hasRunicInk()) {
            if ((is.getTagCompound().getShort("runicink") + ri) < 201) {
                is.getTagCompound().setShort("runicink", (short) (is.getTagCompound().getShort("runicink") + ri));
                return true;
            } else return false;
        } else {
            is.getTagCompound().setShort("runicink", ri);
            return true;
        }
    }

    public boolean addMysEnergy(short me) {
        if (hasMysEnergy()) {
            if ((is.getTagCompound().getShort("myse") + me) < 2001) {
                is.getTagCompound().setShort("myse", (short) (is.getTagCompound().getShort("myse") + me));
                return true;
            } else return false;
        } else {
            is.getTagCompound().setShort("myse", me);
            return true;
        }
    }

    public boolean takeAwayRunicInk(short ri) {
        if (hasRunicInk()) {
            if ((is.getTagCompound().getShort("runicink")) >= ri) {
                is.getTagCompound().setShort("runicink", (short) (is.getTagCompound().getShort("runicink") - ri));
                return true;
            } else return false;
        } else return false;
    }

    public boolean takeAwayMysEnergy(short me) {
        if (hasMysEnergy()) {
            if ((is.getTagCompound().getShort("myse")) >= me) {
                is.getTagCompound().setShort("myse", (short) (is.getTagCompound().getShort("myse") - me));
                return true;
            } else return false;
        } else return false;
    }

    public static class Offhand extends PlayerUseWoMEEvent{

        private ItemStack is2;

        public Offhand(PlayerInteractEvent event, ItemStack is2, ItemStack is) {
            super(event, is2);
            this.is2 = is;
        }

        public ItemStack getMainItem() {
            return is2;
        }
    }
}
