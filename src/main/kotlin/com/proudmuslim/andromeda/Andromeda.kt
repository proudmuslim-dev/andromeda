package com.proudmuslim.andromeda

import net.fabricmc.api.ModInitializer
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.Registry.register

// For support join https://discord.gg/v6v4pMv

class Andromeda: ModInitializer {

    private val CREEPER_HEART = Item(Item.Settings().group(ItemGroup.MATERIALS).maxCount(32))


    override fun onInitialize() {

        register(Registry.ITEM, Identifier("andromeda", "creeper_heart"), CREEPER_HEART)

        for(x in 1..10){
            println("Fabric mod loaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
            println("I should be doing chem rn")
        }
    }

}
