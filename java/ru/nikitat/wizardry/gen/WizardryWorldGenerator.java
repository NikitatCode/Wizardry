package ru.nikitat.wizardry.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.IPlantable;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;
import ru.nikitat.wizardry.blocks.BlockWizardryFlowers;

import java.util.Random;

public class WizardryWorldGenerator implements IWorldGenerator {

    public WizardryWorldGenerator() {
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                this.generateNether(world, random, chunkX, chunkZ);
            case 1:
                break;
            case 0:
                this.generateSurface(world, random, chunkX, chunkZ);
        }
    }

    public void generateNether(World world, Random random, int chunkX, int chunkZ) {

    }

    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        //if (!world.getWorldInfo().getTerrainType().getWorldTypeName().startsWith("flat")) {
        this.generateTrees(world, random, chunkX, chunkZ);
        this.generateFlowers(world, random, chunkX, chunkZ);
        //}
    }

    public void generateFlowers(World world, Random random, int chunkX, int chunkZ) {
        Block b = NikitatRegistry.getBlock("wflowers");
        for (int attempts = 0; attempts < 6; attempts++) {
            int x = chunkX * 16 + random.nextInt(16);
            int z = chunkZ * 16 + random.nextInt(16);
            int y = world.getHeight(x, z);
            BlockPos pos = new BlockPos(x, y, z);
            Biome bio = world.getBiome(pos);
            if ((world.isAirBlock(pos) || world.getBlockState(pos).getBlock() instanceof BlockBush) && world.getBlockState(pos.down()).getBlock().canSustainPlant(world.getBlockState(pos.down()), world, pos.down(), EnumFacing.UP, (IPlantable) b)) {
                int m = 2;
                int r = random.nextInt(9);
                r++;
                if (r == 1) m = 3;
                else if (r == 2 || r == 3) m = 0;
                else if (r == 4 || r == 5 || r == 6) m = 1;
                IBlockState bs = b.getDefaultState().withProperty(BlockWizardryFlowers.TYPE, m);
                if (bio instanceof BiomeForestMutated) {
                    world.setBlockState(pos, bs, 18);
                }
                if (bio instanceof BiomeJungle && attempts < 4){
                    world.setBlockState(pos, bs, 18);
                }
                if(bio instanceof BiomePlains && attempts < 3){
                    world.setBlockState(pos, bs, 18);
                }
                if (bio.getTempCategory() == Biome.TempCategory.MEDIUM && attempts < 2){
                    world.setBlockState(pos, bs, 18);
                }
            }
        }
    }

    public void generateTrees(World world, Random random, int chunkX, int chunkZ) {
        if (random.nextInt(20) == 0) {
                generateMysticalOak(world, random, chunkX, chunkZ);
        }
    }

    public void generateMysticalOak(World world, Random random, int chunkX, int chunkZ) {
        int x = chunkX * 16 + random.nextInt(8);
        int z = chunkZ * 16 + random.nextInt(8);
        int y = world.getHeight(x, z);
        BlockPos pos = new BlockPos(x, y, z);
        Biome bio = world.getBiome(pos);
        if ((bio.getTempCategory() == Biome.TempCategory.MEDIUM || bio.getTempCategory() == Biome.TempCategory.WARM) && !(bio instanceof BiomeDesert)) {
            new WorldGenWizardryTrees(true).generate(world, random, pos);
        }
    }
}