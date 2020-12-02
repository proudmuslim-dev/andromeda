package com.proudmuslim.andromeda


import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.util.registry.Registry.register
import net.minecraft.util.registry.Registry
import net.fabricmc.api.ModInitializer
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.item.Item

class Andromeda: ModInitializer {


    companion object {
        private val GUNPOWDER_BLOCK = GunpowderBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(1.0f))
        private val CREEPER_HEART = CreeperHeartItem(Item.Settings().group(ItemGroup.MATERIALS).maxCount(32))
        private val MOB_WAND = HostileMobWand(Item.Settings().group(ItemGroup.TOOLS).maxCount(1))

    }

    fun actuallyRegister(blockname: GunpowderBlock /* Insert the name of the class you used to set up the block there */, _namespace: String, _path: String, _group: ItemGroup ) {
        register(Registry.ITEM, Identifier(_namespace, _path), BlockItem(blockname, Item.Settings().group(_group)))
        register(Registry.BLOCK, Identifier(_namespace, _path), blockname)
    }

    override fun onInitialize() {
        // Dual registry as both a block and item for GUNPOWDER_BLOCK
        actuallyRegister(GUNPOWDER_BLOCK, "andromeda", "gunpowder_block", ItemGroup.MATERIALS)

        register(Registry.ITEM, Identifier("andromeda", "creeper_heart"), CREEPER_HEART)
        register(Registry.ITEM, Identifier("andromeda", "mob_wand"), MOB_WAND)

        for(x in 1..10) {
            println("Fabric mod loaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
            println("I should be doing chem rn")
        }
    }

}
