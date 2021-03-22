/*
 * Minecraft Forge
 * Copyright (c) 2016-2020.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.server.permission.context;

import com.google.common.base.Preconditions;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;

import javax.annotation.Nullable;

public class BlockPosContext extends PlayerContext
{
    private final BlockPos blockPos;
    private BlockState blockState;
    private Direction facing;

    public BlockPosContext(PlayerEntity ep, BlockPos pos, @Nullable BlockState state, @Nullable Direction f)
    {
        super(ep);
        blockPos = Preconditions.checkNotNull(pos, "BlockPos can't be null in BlockPosContext!");
        blockState = state;
        facing = f;
    }

    public BlockPosContext(PlayerEntity ep, ChunkPos pos)
    {
        this(ep, new BlockPos(pos.getMinBlockX() + 8, 0, pos.getMinBlockZ() + 8), null, null);
    }

    @Override
    @Nullable
    public <T> T get(ContextKey<T> key)
    {
        if(key.equals(ContextKeys.POS))
        {
            return (T) blockPos;
        }
        else if(key.equals(ContextKeys.BLOCK_STATE))
        {
            if(blockState == null)
            {
                blockState = getWorld().getBlockState(blockPos);
            }

            return (T) blockState;
        }
        else if(key.equals(ContextKeys.FACING))
        {
            return (T) facing;
        }

        return super.get(key);
    }

    @Override
    protected boolean covers(ContextKey<?> key)
    {
        return key.equals(ContextKeys.POS) || key.equals(ContextKeys.BLOCK_STATE) || (facing != null && key.equals(ContextKeys.FACING));
    }
}
