package tech.proudmuslim.andromeda

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.TypedActionResult
import net.minecraft.text.LiteralText
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraft.util.Hand
import net.minecraft.item.Item
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents

class HostileMobWand(settings: Settings): Item(settings) {

    override fun use(world: World, playerEntity: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        world.setMobSpawnOptions(hand == Hand.OFF_HAND, true)
        playerEntity?.sendMessage(LiteralText("Set hostile mab spawning to " + (hand == Hand.OFF_HAND)), false)

        when(!world.isClient) {
            true -> {
                world.playSound(null, playerEntity?.blockPos, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.WEATHER, 1f, 1f)
            }
        }

        return super.use(world, playerEntity, hand)
    }
}
