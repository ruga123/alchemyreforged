
package net.mcreator.alchemyconstructrugs.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.alchemyconstructrugs.AlchemyConstructRugsModElements;

@AlchemyConstructRugsModElements.ModElement.Tag
public class AlchemistsJarItem extends AlchemyConstructRugsModElements.ModElement {
	@ObjectHolder("alchemy_construct_rugs:alchemists_jar")
	public static final Item block = null;
	public AlchemistsJarItem(AlchemyConstructRugsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(8).rarity(Rarity.COMMON));
			setRegistryName("alchemists_jar");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
