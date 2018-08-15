package com.mw.raumships.client.sound;

import com.mw.raumships.common.entities.RaumShipsEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;

public class FlyingEntitySoundLoop extends MovingSound {
    private RaumShipsEntity entity;

    public FlyingEntitySoundLoop(RaumShipsEntity entity) {
        super(Sounds.JUMPER_ENGINE, SoundCategory.AMBIENT);

        this.entity = entity;
        this.repeat = true;
        this.volume = 0.3F;
    }

    @Override
    public void update() {
        boolean shouldPlay = (entity.getControllingPassenger() instanceof EntityPlayer || entity.isInAir());

        if (entity.isDead) {
            this.donePlaying = true;
        } else {
            this.xPosF = (float)entity.posX;
            this.yPosF = (float)entity.posY;
            this.zPosF = (float)entity.posZ;

            this.volume = shouldPlay ? 0.3F : 0.0F;
        }
    }
}
