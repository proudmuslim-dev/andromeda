package tech.proudmuslim.andromeda.tools

import tech.proudmuslim.andromeda.materials.RedstoneToolMaterial
import net.minecraft.item.ToolMaterial
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ItemGroup
import net.minecraft.item.Item

class RedstonePickaxe(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings): PickaxeItem(material, attackDamage, attackSpeed, settings) {
    companion object {
        val REDSTONE_PICKAXE: RedstonePickaxe = RedstonePickaxe(RedstoneToolMaterial(), 1, 69f, Settings().group(
            ItemGroup.TOOLS))
    }
}