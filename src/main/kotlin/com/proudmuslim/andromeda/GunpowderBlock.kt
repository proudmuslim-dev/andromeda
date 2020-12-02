package com.proudmuslim.andromeda

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.ActionResult
import net.minecraft.text.LiteralText
import net.minecraft.block.BlockState
import net.minecraft.item.ItemStack
import net.minecraft.block.Blocks
import net.minecraft.world.World
import net.minecraft.block.Block
import net.minecraft.item.Items
import net.minecraft.util.Hand

class GunpowderBlock(settings: Settings): Block(settings) {
    override fun onUse(blockState: BlockState?, world: World, blockPos: BlockPos, playerEntity: PlayerEntity, hand: Hand?, blockHitResult: BlockHitResult?): ActionResult {
        val itemStack: ItemStack = playerEntity.getStackInHand(hand).copy()
        when(itemStack.item) {
            Items.NETHERITE_INGOT -> playerEntity.sendMessage(LiteralText("Rich boy, are we?"), false)
            Items.BEDROCK -> playerEntity.sendMessage(LiteralText("How"), false)
            Items.FLINT -> world.setBlockState(blockPos.up(), Blocks.FIRE.defaultState)
            Items.FLINT_AND_STEEL -> {
                for(x in 1..10){
                    world.setBlockState(blockPos.south(x), Blocks.FIRE.defaultState)
                    world.setBlockState(blockPos.north(x), Blocks.FIRE.defaultState)
                    world.setBlockState(blockPos.east(x), Blocks.FIRE.defaultState)
                    world.setBlockState(blockPos.west(x), Blocks.FIRE.defaultState)
                }
                world.setBlockState(blockPos.up(), Blocks.FIRE.defaultState)
            }
        }
        return super.onUse(blockState, world, blockPos, playerEntity, hand, blockHitResult)
    }

}