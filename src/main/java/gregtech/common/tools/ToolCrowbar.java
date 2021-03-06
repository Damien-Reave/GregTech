package gregtech.common.tools;

import gregtech.api.items.metaitem.MetaItem.MetaValueItem;
import gregtech.common.items.behaviors.CrowbarBehaviour;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

public class ToolCrowbar extends ToolBase {

    @Override
    public int getToolDamagePerBlockBreak(ItemStack stack) {
        return 1;
    }

    @Override
    public int getToolDamagePerContainerCraft(ItemStack stack) {
        return 1;
    }

    @Override
    public float getBaseDamage(ItemStack stack) {
        return 2.0F;
    }

    @Override
    public boolean isCrowbar(ItemStack stack) {
        return true;
    }

    @Override
    public void onStatsAddedToTool(MetaValueItem item) {
        item.addStats(new CrowbarBehaviour(DamageValues.DAMAGE_FOR_CROWBAR));
    }

    @Override
    public boolean canMineBlock(IBlockState block, ItemStack stack) {
        String tool = block.getBlock().getHarvestTool(block);
        return (tool != null && tool.equals("crowbar")) ||
            block.getMaterial() == Material.CIRCUITS;
    }
}
