/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_16_R3.block.impl;

public final class CraftCoralFan extends org.bukkit.craftbukkit.v1_16_R3.block.data.CraftBlockData implements org.bukkit.block.data.Waterlogged {

    public CraftCoralFan() {
        super();
    }

    public CraftCoralFan(net.minecraft.block.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.block.data.CraftWaterlogged

    private static final net.minecraft.state.BooleanProperty WATERLOGGED = getBoolean(net.minecraft.block.CoralFinBlock.class, "waterlogged");

    @Override
    public boolean isWaterlogged() {
        return get(WATERLOGGED);
    }

    @Override
    public void setWaterlogged(boolean waterlogged) {
        set(WATERLOGGED, waterlogged);
    }
}
