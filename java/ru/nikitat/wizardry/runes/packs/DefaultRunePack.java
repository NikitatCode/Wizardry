package ru.nikitat.wizardry.runes.packs;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import ru.nikitat.nikitatcore.enums.EnumEnableDisable;
import ru.nikitat.wizardry.api.IRune;
import ru.nikitat.wizardry.api.IRunePack;

public enum DefaultRunePack implements IRunePack, IRune {
    
    Uno("uno","uno","uno","uno"  );

    public String regName;
    public ResourceLocation t;
    public ResourceLocation st;
    public ResourceLocation rt;

    private DefaultRunePack(String rn, String tn, String stn, String rtn) {
        String modid = getPackModid();
        regName=rn;
        t=new ResourceLocation(modid, tn);
        st=new ResourceLocation(modid, stn);
        rt=new ResourceLocation(modid, rtn);
    }

    @Override
    public IRune[] getValues() {
        return DefaultRunePack.values();
    }

    @Override
    public String getPackModid() {
        return "wizardrynt";
    }

    @Override
    public String getPackName() {
        return "base";
    }

    @Override
    public String getRegName() {
        return regName;
    }

    @Override
    public ResourceLocation getTexture() {
        return t;
    }

    @Override
    public ResourceLocation getSmallTexture() {
        return st;
    }

    @Override
    public ResourceLocation getRuneTexture() {
        return rt;
    }

}
