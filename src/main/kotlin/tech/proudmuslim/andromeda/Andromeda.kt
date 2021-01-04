package tech.proudmuslim.andromeda


import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.api.ModInitializer

import tech.proudmuslim.andromeda.tools.RedstonePickaxe
import tech.proudmuslim.andromeda.tools.CustomShield

import net.minecraft.world.gen.decorator.RangeDecoratorConfig
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry.register
import net.minecraft.world.gen.decorator.Decorator
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.feature.Feature
import net.minecraft.util.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.block.Material
import net.minecraft.block.Blocks
import net.minecraft.block.Block
import net.minecraft.item.*


class Andromeda: ModInitializer {

    companion object {

        private val BLOCK_GUNPOWDER = GunpowderBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(1.0f))
        private val ITEM_CREEPER_HEART = CreeperHeartItem(Item.Settings().group(ItemGroup.MATERIALS).maxCount(32))
        private val ITEM_CUSTOM_SHIELD = CustomShield(Item.Settings().group(ItemGroup.TOOLS).maxDamage(32767))
        private val ITEM_MOB_WAND = HostileMobWand(Item.Settings().group(ItemGroup.TOOLS).maxCount(1))
        private val ITEM_TEST_WAND = Test(Item.Settings().group(ItemGroup.TOOLS).maxCount(1))

        @JvmStatic public val ORE_SHULKER_OVERWORLD = Feature.ORE
            .configure(OreFeatureConfig( OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.BLUE_SHULKER_BOX.defaultState, 7))
            .decorate(Decorator.RANGE.configure(RangeDecoratorConfig(0, 0, 64)))
            .spreadHorizontally()
            .repeat(15)

    }

    /**
     * Register a block as both a block and an item.
     *
     * @param[block] the block
     * @param[namespace] the namespace under which you want to register the block (i.e. mod name)
     * @param[path] item name
     * @param[inventoryGroup] group to be sorted under in the creative inventory
     */
    private fun blockRegister(block: Block, namespace: String, path: String, inventoryGroup: ItemGroup ) {
        register(Registry.ITEM, Identifier(namespace, path), BlockItem(block, Item.Settings().group(inventoryGroup)))
        register(Registry.BLOCK, Identifier(namespace, path), block)
    }

    override fun onInitialize() {
        val shulkerWoolOverworld = RegistryKey.of( Registry.CONFIGURED_FEATURE_WORLDGEN,
            Identifier("andromeda", "ore_wool_overworld")
        )

        // Dual registry as both a block and item for GUNPOWDER_BLOCK
        blockRegister(BLOCK_GUNPOWDER, "andromeda", "gunpowder_block", ItemGroup.MATERIALS)

        // See ShulkerBoxOreMixin for actual world generation modification
        register(BuiltinRegistries.CONFIGURED_FEATURE, shulkerWoolOverworld.value, ORE_SHULKER_OVERWORLD)

        register(Registry.ITEM, Identifier("andromeda", "redstone_pickaxe"), RedstonePickaxe.REDSTONE_PICKAXE)
        register(Registry.ITEM, Identifier("andromeda", "creeper_heart"), ITEM_CREEPER_HEART)
        register(Registry.ITEM, Identifier("andromeda", "custom_shield"), ITEM_CUSTOM_SHIELD)
        register(Registry.ITEM, Identifier("andromeda", "test_wand"), ITEM_TEST_WAND) // Confirmed: right clicking once does in fact call the function twice
        register(Registry.ITEM, Identifier("andromeda", "mob_wand"), ITEM_MOB_WAND)



        repeat(10) {
            println("Fabric mod loaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
            println("I should be doing chem rn")
            println("I wrote this in vr")
        }
    }

}
