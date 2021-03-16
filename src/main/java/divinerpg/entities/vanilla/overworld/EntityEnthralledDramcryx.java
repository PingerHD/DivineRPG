package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityEnthralledDramcryx extends EntityDivineMob {

    public EntityEnthralledDramcryx(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.25F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.corruptedDramcryxHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.corruptedDramcryxDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.corruptedDramcryxSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.corruptedDramcryxFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DRAMCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DRAMCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DRAMCRYX_HURT;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_ENTHRALLED_DRAMCRYX;
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == World.OVERWORLD && super.canSpawn(worldIn, spawnReasonIn) && getY() <= 16;
    }
}