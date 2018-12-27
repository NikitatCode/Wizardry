package ru.nikitat.wizardry.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import ru.nikitat.nikitatcore.api.INeedManyNames;
import ru.nikitat.nikitatcore.api.NikitatBlock;
import ru.nikitat.wizardry.WizardryMod;

public class BlockWizardryLogs extends BlockLog implements NikitatBlock, INeedManyNames{

    public static final String[] names = new String[]{"MysticalOak"};

    public BlockWizardryLogs() {
        super();
        this.setCreativeTab(WizardryMod.tab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        this.setRegistryName("wizardrynt", "logs");
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 5;
    }

    public String getUnlocalizedName() {
        return "BWLogs";
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LOG_AXIS, meta==3?EnumAxis.Z:meta==2?EnumAxis.Y:meta==1?EnumAxis.X:EnumAxis.NONE);
    }

    public int getMetaFromState(IBlockState state)
    {
        EnumAxis axis = state.getValue(LOG_AXIS);
        return axis == EnumAxis.Z?3:axis == EnumAxis.Y?2:axis == EnumAxis.Z?1:0;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }

    @Override
    public void postReg() {

    }

    @Override
    public void setRender() {

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(this.getRegistryName().getResourceDomain() + ":mystical_oak_log", "inventory"));
    }

    @Override
    public void postRegWithThaumcraft() {

    }

    @Override
    public void postRegWithWizardry() {

    }

    @Override
    public String[] getNames() {
        return new String[]{"wizardry.log.mystical_oak"};
    }
}
