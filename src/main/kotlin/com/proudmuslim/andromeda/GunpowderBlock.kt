package com.proudmuslim.andromeda

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.ActionResult
import net.minecraft.text.LiteralText
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.world.World
import net.minecraft.block.Block
import net.minecraft.item.Items
import net.minecraft.util.Hand
import net.minecraft.util.math.Direction

class GunpowderBlock(settings: Settings): Block(settings) {
    override fun onUse(blockState: BlockState?, world: World, blockPos: BlockPos, playerEntity: PlayerEntity, hand: Hand?, blockHitResult: BlockHitResult?): ActionResult {
        when(playerEntity.getStackInHand(hand).item) {
            Items.NETHERITE_INGOT -> playerEntity.sendMessage(LiteralText("Rich boy, are we?"), false)
            Items.BEDROCK -> playerEntity.sendMessage(LiteralText("/ban @p hacker"), false)
            Items.FLINT -> world.setBlockState(blockPos.up(), Blocks.FIRE.defaultState)
            Items.FLINT_AND_STEEL -> {
                var direction: Direction = Direction.NORTH
                repeat(40) {
                    direction = direction.rotateYClockwise()
                    world.setBlockState(blockPos.offset(direction, (it + 1) % 4), Blocks.FIRE.defaultState)
                }
                world.setBlockState(blockPos.up(), Blocks.FIRE.defaultState)
            }
        }
        @Suppress("DEPRECATION") // not really anything else we can do
        return super.onUse(blockState, world, blockPos, playerEntity, hand, blockHitResult)
    }

}
