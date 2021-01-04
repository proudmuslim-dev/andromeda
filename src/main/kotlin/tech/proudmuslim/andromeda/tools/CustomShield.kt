package tech.proudmuslim.andromeda.tools

import net.minecraft.item.ShieldItem
import net.minecraft.item.ItemStack
import net.minecraft.tag.ItemTags

class CustomShield(settings: Settings?) : ShieldItem(settings) {

   override fun canRepair(stack: ItemStack?, ingredient: ItemStack?): Boolean {
      return ItemTags.ANVIL.contains(ingredient!!.item) || super.canRepair(stack, ingredient)
   }

}