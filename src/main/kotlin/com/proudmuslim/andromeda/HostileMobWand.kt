package com.proudmuslim.andromeda

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.TypedActionResult
import net.minecraft.text.LiteralText
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraft.util.Hand
import net.minecraft.item.Item

class HostileMobWand(settings: Settings): Item(settings) {

    override fun use(world: World?, playerEntity: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world?.setMobSpawnOptions(hand == Hand.OFF_HAND, true)
        playerEntity?.sendMessage(LiteralText("Set hostile mab spawning to " + (hand == Hand.OFF_HAND)), false)

        return super.use(world, playerEntity, hand)
    }
}
