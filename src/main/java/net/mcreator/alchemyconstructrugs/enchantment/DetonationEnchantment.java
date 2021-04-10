
package net.mcreator.alchemyconstructrugs.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.alchemyconstructrugs.block.ConcoctionTntBlock;
import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;

@AlchemyConstructRugsModElements.ModElement.Tag
public class DetonationEnchantment extends AlchemyConstructRugsModElements.ModElement {
	@ObjectHolder("alchemy_construct_rugs:detonation")
	public static final Enchantment enchantment = null;
	public DetonationEnchantment(AlchemyConstructRugsModElements instance) {
		super(instance, 91);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("detonation"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.VANISHABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(ConcoctionTntBlock.block, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return true;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
