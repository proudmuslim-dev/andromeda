@file:Suppress("SameParameterValue")

package tech.proudmuslim.andromeda

import net.minecraft.world.gen.decorator.RangeDecoratorConfig
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry.register
import net.minecraft.world.gen.decorator.Decorator
import net.minecraft.util.registry.RegistryKey
import net.minecraft.util.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.block.Material
import net.minecraft.block.Blocks
import net.minecraft.block.Block
import net.minecraft.item.*

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig
import net.minecraft.world.gen.feature.*
import net.fabricmc.api.ModInitializer

import tech.proudmuslim.andromeda.features.EmeraldSpiral
import tech.proudmuslim.andromeda.tools.RedstonePickaxe
import tech.proudmuslim.andromeda.tools.CustomShield
import tech.proudmuslim.andromeda.item.GunpowderBag


class Andromeda: ModInitializer {

    companion object {

        private val BLOCK_GUNPOWDER = GunpowderBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(1.0f))
        private val ITEM_CREEPER_HEART = CreeperHeartItem(Item.Settings().group(ItemGroup.MATERIALS).maxCount(32))
        private val ITEM_CUSTOM_SHIELD = CustomShield(Item.Settings().group(ItemGroup.TOOLS).maxDamage(32767))
        private val ITEM_GUNPOWDER_BAG = GunpowderBag(Item.Settings().group(ItemGroup.TOOLS).maxCount(1))
        private val ITEM_MOB_WAND = HostileMobWand(Item.Settings().group(ItemGroup.TOOLS).maxCount(1))
        private val ITEM_TEST_WAND = Test(Item.Settings().group(ItemGroup.TOOLS).maxCount(1))

        @JvmStatic val EMERALD_SPIRAL: Feature<DefaultFeatureConfig> = EmeraldSpiral(DefaultFeatureConfig.CODEC)
        @JvmStatic val EMERALD_SPIRAL_CONFIGURED: ConfiguredFeature<*, *>  = EMERALD_SPIRAL
            .configure(FeatureConfig.DEFAULT)
            .decorate(Decorator.CHANCE.configure(ChanceDecoratorConfig(100)))

        @JvmStatic val ORE_SHULKER_OVERWORLD: ConfiguredFeature<*, *> = Feature.ORE
            .configure(OreFeatureConfig( OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.BLUE_SHULKER_BOX.defaultState, 7))
            .decorate(Decorator.RANGE.configure(RangeDecoratorConfig(0, 0, 64)))
            .spreadHorizontally()
            .repeat(15)

    }

    /**
     * Register a feature in one go
     *
     * @param[feature] the feature
     * @param[configuredFeature] the feature, configured
     * @param[namespace] typically your mode name, the namespace under which you want to register your feature
     * @param[path] item name
     */
    private fun featureRegister(feature: Feature<DefaultFeatureConfig>, configuredFeature: ConfiguredFeature<*, *>, namespace: String, path: String) {
        register(Registry.FEATURE, Identifier(namespace, path), feature)
        register(BuiltinRegistries.CONFIGURED_FEATURE, Identifier(namespace, path), configuredFeature)
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
        val shulkerOreOverworld = RegistryKey.of( Registry.CONFIGURED_FEATURE_WORLDGEN,
            Identifier("andromeda", "ore_shulker_overworld")
        )

        // Dual registry as both a block and item for GUNPOWDER_BLOCK
        blockRegister(BLOCK_GUNPOWDER, "andromeda", "gunpowder_block", ItemGroup.MATERIALS)

        // See DefaultBiomeFeaturesMixin for actual world generation modification
        featureRegister(EMERALD_SPIRAL, EMERALD_SPIRAL_CONFIGURED, "andromeda", "emerald_spiral")
        register(BuiltinRegistries.CONFIGURED_FEATURE, shulkerOreOverworld.value, ORE_SHULKER_OVERWORLD)

        register(Registry.ITEM, Identifier("andromeda", "redstone_pickaxe"), RedstonePickaxe.REDSTONE_PICKAXE)
        register(Registry.ITEM, Identifier("andromeda", "creeper_heart"), ITEM_CREEPER_HEART)
        register(Registry.ITEM, Identifier("andromeda", "gunpowder_bag"), ITEM_GUNPOWDER_BAG)
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
