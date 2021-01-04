package tech.proudmuslim.andromeda

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.TypedActionResult
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraft.item.Item
import net.minecraft.util.Hand

class CreeperHeartItem(settings: Settings): Item(settings) {

    private var using: Boolean = true

    override fun use(world: World?, playerEntity: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        if (using) {
            when(hand) {
                Hand.MAIN_HAND -> println("Sssssssssssssssss.........") // Prints twice because I'm lazy and cba to fix it
                else -> println("Else statement triggered!")
            }
        }
        using = !using

        return super.use(world, playerEntity, hand)
    }
}
