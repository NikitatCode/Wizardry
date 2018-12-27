package ru.nikitat.wizardry;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import ru.nikitat.nikitatcore.api.NikitatGameObject;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;
import ru.nikitat.wizardry.api.PlayerUseWoMEEvent;
import ru.nikitat.wizardry.blocks.BlockMysticalFire;
import ru.nikitat.wizardry.blocks.BlockWizardryFlowers;
import ru.nikitat.wizardry.items.WandOfMysticalEnergy;

public class WizardryEventHandler {

    /*@SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack is = event.entityPlayer.getCurrentEquippedItem();
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && is != null) {
            if (event.entityPlayer.getCurrentEquippedItem().getItem() == NikitatRegistry.getItem("IWoME") && event.entityPlayer.getCurrentEquippedItem().getItemDamage() == 0) {
                if (event.world.getBlock(event.x, event.y, event.z) == NikitatRegistry.getBlock("BWLeaves")) {
                    event.world.setBlock(event.x, event.y, event.z, Blocks.leaves);
                    event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, 1, 1);
                    is.setItemDamage(1);
                }
            }
        }
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && is != null && event.entityPlayer.isSneaking()) {
            if (event.entityPlayer.getCurrentEquippedItem().getItem() == NikitatRegistry.getItemForNBlock("BWFl") && event.entityPlayer.getCurrentEquippedItem().getItemDamage() == 3) {
                if (event.face == 1 && event.world.getBlock(event.x, event.y, event.z).isOpaqueCube() && event.world.getBlock(event.x, event.y, event.z).renderAsNormalBlock()) {
                    event.world.setBlock(event.x, event.y + 1, event.z, NikitatRegistry.getBlock("BWMysF"));
                    //event.world.setBlockMetadataWithNotify(event.x, event.y, event.z, 1, 1);
                    //is.setItemDamage(1);
                }
            }
        }
    }*/

    /*@SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        WandOfMysticalEnergy.instance.setRender();
        System.out.println("11221122");
    }*/

    @SubscribeEvent
    public void onPlayerUseWoME(PlayerInteractEvent event) {
        ItemStack is = event.getItemStack();
        ItemStack is2 = event.getEntityPlayer().getHeldItemOffhand();
        if (is != null && !event.getWorld().isRemote) {
            if (is.getItem() == NikitatRegistry.getItem("wand_of_mystical_energy") && is.getItemDamage() != 0) {
                PlayerUseWoMEEvent ev = new PlayerUseWoMEEvent(event, is);
                MinecraftForge.EVENT_BUS.post(ev);
            }else if(is2 != null){
                if(is2.getItem() == NikitatRegistry.getItem("wand_of_mystical_energy") && is.getItemDamage() != 0){
                    PlayerUseWoMEEvent.Offhand ev = new PlayerUseWoMEEvent.Offhand(event, is2, is);
                    MinecraftForge.EVENT_BUS.post(ev);
                }
            }
        }
    }


    @SubscribeEvent
    public void playerMakeWoME(PlayerInteractEvent event){
        if(event.getItemStack() != null && event.getWorld().getBlockState(event.getPos()).getBlock() == NikitatRegistry.getBlock("moleaves")){
            if(event.getItemStack().getItem() == NikitatRegistry.getItem("wand_of_mystical_energy") && event.getItemStack().getItemDamage() == 0)
            event.getWorld().setBlockState(event.getPos(), Blocks.LEAVES.getDefaultState());
            event.getItemStack().setItemDamage(1);
        }
    }

    @SubscribeEvent
    public void putOutFire(PlayerUseWoMEEvent ev){
        PlayerInteractEvent pie = ev.getPlayerInteractEvent();
        if(/*pie.getFace() == EnumFacing.UP &&*/ pie.getWorld().getBlockState(pie.getPos().up()).getBlock() instanceof BlockMysticalFire && ev.takeAwayMysEnergy((short) 20)){
            pie.getWorld().setBlockToAir(pie.getPos().up());
        }
    }

    /*@SubscribeEvent
    public void setMysFire(BlockEvent.PlaceEvent ev){
        if(ev.getPlayer().isSneaking() && ev.getPlacedBlock().getBlock() instanceof BlockWizardryFlowers){
            if(ev.getPlacedBlock().getValue(BlockWizardryFlowers.TYPE).intValue() == 3){
                ev.setCanceled(true);
                ev.getWorld().setBlockState(ev.getPos(), NikitatRegistry.getBlock("mystical_fire").getDefaultState());
            }
        }
    }*/

    /*@SubscribeEvent
    public void onPlayerUseWoME(PlayerInteractEvent event) {
        ItemStack is = event.entityPlayer.getCurrentEquippedItem();
        if (is != null && !event.world.isRemote) {
            if (is.getItem() == NikitatRegistry.getItem("IWoME") && is.getItemDamage() != 0) {
                NBTTagCompound nbt;
                if (is.hasTagCompound()) nbt = is.stackTagCompound;
                else {
                    nbt = new NBTTagCompound();
                    is.setTagCompound(nbt);
                }
                short myse = nbt.hasKey("myse")?nbt.getShort("myse"):0;
                short runicink = nbt.hasKey("runicink")?nbt.getShort("runicink"):0;
                if(event.face == 1 && event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK && myse >4){
                    if(event.world.getBlock(event.x, event.y + 1, event.z)==NikitatRegistry.getBlock("BWMysF")){
                        event.world.setBlockToAir(event.x, event.y + 1, event.z);
                        myse = (short) (myse - 5);
                    }
                }
                nbt.setShort("myse", myse);
                nbt.setShort("runicink", runicink);
                is.setTagCompound(nbt);
            }
        }
    }*/

    /*@SubscribeEvent
    public void kostil(ItemTooltipEvent ite) {
        ItemStack is = ite.itemStack;
        if (is.stackTagCompound != null) {
            NBTTagCompound nbt = is.stackTagCompound;
            if (nbt.hasKey("wismop")) {
                if (nbt.hasKey("display")) {
                    NBTTagCompound nbt2 = nbt.getCompoundTag("display");
                    nbt.setString("Name", StatCollector.translateToLocal("dopn"));
                    nbt.setTag("display", nbt2);
                } else {
                    NBTTagCompound nbt2 =  new NBTTagCompound();
                    nbt.setString("Name", StatCollector.translateToLocal("dopn"));
                    nbt.setTag("display", nbt2);
                }
            }
        }
    }*/

}
