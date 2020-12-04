package com.proudmuslim.andromeda


import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.util.registry.Registry.register
import net.minecraft.util.registry.Registry
import net.fabricmc.api.ModInitializer
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.item.Item

class Andromeda: ModInitializer {

    companion object {

        private val BLOCK_GUNPOWDER = GunpowderBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(1.0f))
        private val ITEM_CREEPER_HEART = CreeperHeartItem(Item.Settings().group(ItemGroup.MATERIALS).maxCount(32))
        private val ITEM_MOB_WAND = HostileMobWand(Item.Settings().group(ItemGroup.TOOLS).maxCount(1))
        private val ITEM_TEST_WAND = Test(Item.Settings().group(ItemGroup.TOOLS).maxCount(1))

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
        // Dual registry as both a block and item for GUNPOWDER_BLOCK
        blockRegister(BLOCK_GUNPOWDER, "andromeda", "gunpowder_block", ItemGroup.MATERIALS)

        register(Registry.ITEM, Identifier("andromeda", "creeper_heart"), ITEM_CREEPER_HEART)
        register(Registry.ITEM, Identifier("andromeda", "mob_wand"), ITEM_MOB_WAND)
        register(Registry.ITEM, Identifier("andromeda", "test_wand"), ITEM_TEST_WAND) // Confirmed: right clicking once does in fact call the function twice

        for(x in 1..10) {
            println("Fabric mod loaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
            println("I should be doing chem rn")
        }
    }

}
