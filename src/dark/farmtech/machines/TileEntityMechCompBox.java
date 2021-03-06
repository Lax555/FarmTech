package dark.farmtech.machines;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import dark.api.parts.INetworkEnergyPart;
import dark.core.prefab.tilenetwork.NetworkSharedPower;
import dark.core.prefab.tilenetwork.NetworkTileEntities;

/** Advanced version of the compBox that can link to other boxes and process matter at a higher rate.
 * Cost some minor power and will have some mechanical animation of flipping dirt & items
 * 
 * @author DarkGuardsman */
public class TileEntityMechCompBox extends TileEntityCompBox implements INetworkEnergyPart
{
    List<TileEntity> connections = new ArrayList<TileEntity>();

    public TileEntityMechCompBox()
    {
        this.MAX_WATTS = 100;
        this.WATTS_PER_TICK = .001f; //1w
    }

    @Override
    public List<TileEntity> getNetworkConnections()
    {
        if (this.connections == null)
        {
            this.connections = new ArrayList<TileEntity>();
        }
        return this.connections;
    }

    @Override
    public void refresh()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public NetworkSharedPower getTileNetwork()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTileNetwork(NetworkTileEntities fluidNetwok)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean mergeDamage(String result)
    {
        return false;
    }

    @Override
    public boolean canTileConnect(Connection type, ForgeDirection dir)
    {
        return type != null && type == Connection.NETWORK;
    }

    @Override
    public float getPartEnergy()
    {
        return this.energyStored;
    }

    @Override
    public float getPartMaxEnergy()
    {
        return this.MAX_WATTS;
    }

    @Override
    public void setPartEnergy(float energy)
    {
        this.energyStored = energy;
    }
}
