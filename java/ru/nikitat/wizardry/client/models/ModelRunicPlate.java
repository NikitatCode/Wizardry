//Made with Blockbench

package ru.nikitat.wizardry.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRunicPlate extends ModelBase {

    //fields
    ModelRenderer e0;
    ModelRenderer e1;
    ModelRenderer e2;

    public ModelRunicPlate() {
        this.textureWidth = 32;
        this.textureHeight = 32;

        this.e0 = new ModelRenderer(this, 0, 0);
        this.e0.addBox(0F, 0F, 0F, 16, 1, 16, 1.0F);
        this.e1 = new ModelRenderer(this, 0, 0);
        this.e1.addBox(1F, 1F, 1F, 14, 1, 14, 1.0F);
        this.e2 = new ModelRenderer(this, 0, 0);
        this.e2.addBox(2F, 2F, 2F, 12, 0, 12, 1.0F);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.e0.render(f5);
        this.e1.render(f5);
        this.e2.render(f5);

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}