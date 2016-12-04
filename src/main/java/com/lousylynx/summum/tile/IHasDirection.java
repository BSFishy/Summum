package com.lousylynx.summum.tile;

import net.minecraft.util.EnumFacing;

public interface IHasDirection {

    void updateBlock();

    void setDirection(EnumFacing direction);

    EnumFacing getDirection();
}
