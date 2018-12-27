package ru.nikitat.wizardry.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import ru.nikitat.nikitatcore.api.IHaveItemBlock;
import ru.nikitat.nikitatcore.api.INeedManyNames;
import ru.nikitat.nikitatcore.api.NikitatBlock;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;
import ru.nikitat.wizardry.WizardryMod;

import java.util.Random;

public class BlockWizardryFlowers extends BlockBush implements NikitatBlock, INeedManyNames{

    public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 3);
    //private static BlockWizardryFlowersItem ib;

    public BlockWizardryFlowers() {
        super(Material.PLANTS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, 0));
        this.setTickRandomly(true);
        this.setCreativeTab(WizardryMod.tab);
        this.setSoundType(SoundType.PLANT);
        this.setCreativeTab(WizardryMod.tab);
        this.setRegistryName("wizardrynt","wflowers");
        //float var3 = 0.4F;
        //this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(TYPE);
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        if(WizardryMod.tab == itemIn){
            items.add(new ItemStack(this, 1, 0));
            items.add(new ItemStack(this, 1, 1));
            items.add(new ItemStack(this, 1, 2));
            items.add(new ItemStack(this, 1, 3));
        }
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        if(placer instanceof EntityPlayer){
            if(placer.isSneaking() && meta==3 && facing == EnumFacing.UP && NikitatRegistry.getBlock("mystical_fire").canPlaceBlockAt(world, pos)){
                placer.getHeldItem(hand).grow(1);
                return NikitatRegistry.getBlock("mystical_fire").getDefaultState();
            }
        }
        return this.getDefaultState().withProperty(TYPE, meta);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 60;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, meta);
    }


    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(TYPE)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }

    @Override
    public void postReg() {

    }

    @Override
    public void setRender() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(this.getRegistryName().getResourceDomain() + ":wflower0", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 1, new ModelResourceLocation(this.getRegistryName().getResourceDomain() + ":wflower1", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 2, new ModelResourceLocation(this.getRegistryName().getResourceDomain() + ":wflower2", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 3, new ModelResourceLocation(this.getRegistryName().getResourceDomain() + ":wflower3", "inventory"));
    }

    @Override
    public void postRegWithThaumcraft() {

    }

    @Override
    public void postRegWithWizardry() {

    }

    @Override
    public String[] getNames() {
        return new String[]{"wizardry.flower.mana", "wizardry.flower.runic", "wizardry.flower.solvent", "wizardry.flower.mfire"};
    }

    //@Override
    //public ItemBlock getItemBlock() {
        //return ib == null?ib=new BlockWizardryFlowersItem(this):ib;
    //}

    private class WizardryFlowersPlantTypes implements IPlantable {

        //int md = 0;

        //public WizardryFlowersPlantTypes(int md) {
            //this.md = md;
        //}

        @Override
        public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
            return EnumPlantType.Plains;
        }

        @Override
        public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
            return NikitatRegistry.getBlock("wflowers").getDefaultState();
        }
    }

    /*public class BlockWizardryFlowersItem extends ItemBlock{

        public BlockWizardryFlowersItem(Block par1) {
            super(par1);
            //this.setMaxDamage(0);
            //this.setHasSubtypes(true);
            this.setCreativeTab(WizardryMod.tab);
            this.setRegistryName("wizardrynt","wflowers");
            this.setHasSubtypes(true);
        }

        @Override
        public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
            return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
        }

        /*@Override
        public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
            if(WizardryMod.tab == tab){
                items.add(new ItemStack(this, 1, 1));
                items.add(new ItemStack(this, 1, 2));
                items.add(new ItemStack(this, 1, 3));
                items.add(new ItemStack(this, 1, 4));
            }
        }

        public String getUnlocalizedName(ItemStack par1ItemStack) {
            return "IWFl" + (par1ItemStack.getItemDamage());
        }

    }*/ /*extends ItemBlock{

        public BlockWizardryFlowersItem(Block par1) {
            super(par1);
            this.setMaxDamage(0);
            this.setHasSubtypes(true);
            this.setCreativeTab(WizardryMod.tab);
        }
        public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
            p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
            p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
            p_150895_3_.add(new ItemStack(p_150895_1_, 1, 2));
            p_150895_3_.add(new ItemStack(p_150895_1_, 1, 3));
        }

        public int getMetadata(int par1) {
            return par1;
        }

        public String getUnlocalizedName(ItemStack par1ItemStack) {
            return "IWFl" + par1ItemStack.getItemDamage();
        }

        public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
            if (side != 1) {
                return false;
            } else if (player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack)) {
                if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, new WizardryFlowersPlantTypes(stack.getItemDamage())) && world.isAirBlock(x, y + 1, z)) {
                    world.setBlock(x, y + 1, z, NikitatRegistry.getBlock("BWFl"), stack.getItemDamage(), 3);
                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 1.5F), (double)((float)z + 0.5F), NikitatRegistry.getBlock("BWFl").stepSound.getStepResourcePath(), (NikitatRegistry.getBlock("BWFl").stepSound.getVolume() + 1.0F) / 2.0F, NikitatRegistry.getBlock("BWFl").stepSound.getPitch() * 0.8F);
                    --stack.stackSize;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override
        public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
            if(p_77624_1_.getItemDamage() == 3){
                p_77624_3_.add(StatCollector.translateToLocal("fmfd"));
            }
        }

        private class WizardryFlowersPlantTypes implements IPlantable {
            int md = 0;

            public WizardryFlowersPlantTypes(int md) {
                this.md = md;
            }

            public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
                return EnumPlantType.Plains;
            }

            public Block getPlant(IBlockAccess world, int x, int y, int z) {
                return NikitatRegistry.getBlock("BWFl");
            }

            public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
                return this.md;
            }

            @Override
            public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
                return EnumPlantType.Plains;
            }

            @Override
            public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
                return (IBlockState) NikitatRegistry.getBlock("flowers");
            }
        }
    }*/
}
