package com.proudmuslim.andromeda.materials

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.item.Items

/**
 * Setting default values for tools that extend this class
 */
class RedstoneToolMaterial: ToolMaterial {
    override fun getDurability(): Int = 69420

    override fun getMiningSpeedMultiplier(): Float = 420.69f

    override fun getAttackDamage(): Float = 666f

    override fun getMiningLevel(): Int = 3

    override fun getEnchantability(): Int = 69

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(Items.REDSTONE)
}