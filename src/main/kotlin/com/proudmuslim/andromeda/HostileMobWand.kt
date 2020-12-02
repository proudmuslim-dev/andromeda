package com.proudmuslim.andromeda

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.TypedActionResult
import net.minecraft.text.LiteralText
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraft.util.Hand
import net.minecraft.item.Item

class HostileMobWand(settings: Item.Settings): Item(settings) {

    override fun use(world: World?, playerEntity: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        when (hand) {

            Hand.MAIN_HAND -> if (world != null) {
                world.setMobSpawnOptions(false, true)
                playerEntity?.sendMessage(LiteralText("Set hostile mab spawning to false"), false)
            }

            Hand.OFF_HAND -> {
                world?.setMobSpawnOptions(true, true)
                playerEntity?.sendMessage(LiteralText("Set hostile mab spawning to true"), false)
            }
        }

        return super.use(world, playerEntity, hand)
    }
}