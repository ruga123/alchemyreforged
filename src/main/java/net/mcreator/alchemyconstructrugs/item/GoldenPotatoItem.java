
package net.mcreator.alchemyconstructrugs.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;

@AlchemyConstructRugsModElements.ModElement.Tag
public class GoldenPotatoItem extends AlchemyConstructRugsModElements.ModElement {
	@ObjectHolder("alchemy_construct_rugs:golden_potato")
	public static final Item block = null;
	public GoldenPotatoItem(AlchemyConstructRugsModElements instance) {
		super(instance, 73);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(12.1f).build()));
			setRegistryName("golden_potato");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
