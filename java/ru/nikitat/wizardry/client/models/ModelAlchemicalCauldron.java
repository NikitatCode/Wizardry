//Made with Blockbench

package ru.nikitat.wizardry.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAlchemicalCauldron extends ModelBase {

    //fields
    ModelRenderer e0;
    ModelRenderer e1;
    ModelRenderer e2;
    ModelRenderer e3;
    ModelRenderer e4;

    public ModelAlchemicalCauldron() {
        this.textureWidth = 32;
        this.textureHeight = 32;

        this.e0 = new ModelRenderer(this, 0, 0);
        this.e0.addBox(1F, 0F, 1F, 14, 1, 14, 1.0F);
        this.e1 = new ModelRenderer(this, 0, 0);
        this.e1.addBox(0F, 0F, 15F, 16, 16, 1, 1.0F);
        this.e2 = new ModelRenderer(this, 0, 0);
        this.e2.addBox(15F, 0F, 1F, 1, 16, 14, 1.0F);
        this.e2.setRotationPoint(14.5F, 8F, 9F);
        this.setRotateAngle(e2, 0.0F, 0F, 0.0F);
        this.e3 = new ModelRenderer(this, 0, 0);
        this.e3.addBox(0F, 0F, 1F, 1, 16, 14, 1.0F);
        this.e3.setRotationPoint(0.5F, 8F, 9F);
        this.setRotateAngle(e3, 0.0F, 0F, 0.0F);
        this.e4 = new ModelRenderer(this, 0, 0);
        this.e4.addBox(0F, 0F, 0F, 16, 16, 1, 1.0F);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.e0.render(f5);
        this.e1.render(f5);
        this.e2.render(f5);
        this.e3.render(f5);
        this.e4.render(f5);

    }

    public void render() {
        this.e0.render(0.0625F);
        this.e1.render(0.0625F);
        this.e2.render(0.0625F);
        this.e3.render(0.0625F);
        this.e4.render(0.0625F);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}