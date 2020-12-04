package com.proudmuslim.andromeda

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World


class Smiter(settings: Item.Settings): Item(settings) {
    var x: Int = 0

    override fun use(world: World?, playerEntity: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        x += 1
        playerEntity?.sendMessage(LiteralText("Function called " + x + " times"), false) // Test why messages send twice

        return super.use(world, playerEntity, hand)
    }
}