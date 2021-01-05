package tech.proudmuslim.andromeda.features;

import static net.minecraft.world.Heightmap.Type.WORLD_SURFACE;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.BlockPos;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;

import java.util.Random;

public class EmeraldSpiral extends Feature<DefaultFeatureConfig> {

    public EmeraldSpiral(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        BlockPos topPos = world.getTopPosition(WORLD_SURFACE, pos);
        Direction offset = Direction.NORTH;

        for (int y = 1; y <= 35; y++) {
            offset = offset.rotateYClockwise();
            world.setBlockState(topPos.up(y).offset(offset), Blocks.EMERALD_BLOCK.getDefaultState(), 3);
        }

        return true;
    }
}
