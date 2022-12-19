package net.sanberdir.lessen.init.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class MetalSpiderEntity extends SpiderEntity {
    public MetalSpiderEntity(EntityType<? extends SpiderEntity> type, World worldIn) {
        super(type, worldIn);
    }




    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new MetalSpiderEntity.AttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, SkeletonEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new MetalSpiderEntity.TargetGoal<>(this, SkeletonEntity.class));
        this.targetSelector.addGoal(3, new MetalSpiderEntity.TargetGoal<>(this, ZombieEntity.class));
    }
    static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public TargetGoal(SpiderEntity spider, Class<T> classTarget) {
            super(spider, classTarget, true);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            float f = this.goalOwner.getBrightness();
            return f >= 0.5F ? false : super.shouldExecute();
        }
    }
    static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(SpiderEntity spider) {
            super(spider, 1.0D, true);
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return super.shouldExecute() && !this.attacker.isBeingRidden();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            float f = this.attacker.getBrightness();
            if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
                this.attacker.setAttackTarget((LivingEntity)null);
                return false;
            } else {
                return super.shouldContinueExecuting();
            }
        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return (double)(4.0F + attackTarget.getWidth());
        }
    }




    public static AttributeModifierMap.MutableAttribute MutableAttributeMetalSpider() {
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 50.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.3F);
    }

}
