package dark.farmtech.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dark.core.prefab.ModPrefab;
import dark.farmtech.FarmTech;

/** Generic block set containing farm blocks: mulch, fertilizer, fertile dirt, mud
 * 
 * mulch/fertilizer -> fertileDirt -> mud -> dirt
 * 
 * @mulch is a decor version of fertilizer made from wood. decays very slowly when actually used for
 * crops. Design is to be used with small plant for decor
 * 
 * @fertilizer enriches the soil and is used to grow crops faster fertilizer can be created from
 * anything using several means
 * 
 * @author darkguardsman */
public class BlockFarmSoil extends Block
{
    Icon mulch, mulch_top, fertilizer, fertileDirt, fertileDirt_top, mud, mud_top;

    public BlockFarmSoil()
    {
        super(FarmTech.CONFIGURATION.getBlock("FarmSoil", ModPrefab.getNextID()).getInt(), Material.clay);
        this.setUnlocalizedName("FarmBlock");
        this.setCreativeTab(FarmTech.TabFarmTech);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconReg)
    {
        super.registerIcons(iconReg);
        this.mud = iconReg.registerIcon(FarmTech.instance.PREFIX + "mud");
        this.fertilizer = iconReg.registerIcon(FarmTech.instance.PREFIX + "fertiliser");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
        switch (meta)
        {

        //0 = mulch
            case 1:
                return this.fertilizer;
                //2 = fertileDirt;
            case 3:
                return this.mud;
            default:
                return this.blockIcon;
        }
    }

    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(this.blockID, 1, 1));
        par3List.add(new ItemStack(this.blockID, 1, 3));
    }

}
