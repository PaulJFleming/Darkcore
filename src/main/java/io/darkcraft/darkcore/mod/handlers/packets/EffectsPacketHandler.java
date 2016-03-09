package io.darkcraft.darkcore.mod.handlers.packets;

import io.darkcraft.darkcore.mod.handlers.EffectHandler;
import io.darkcraft.darkcore.mod.impl.EntityEffectStore;
import io.darkcraft.darkcore.mod.interfaces.IDataPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class EffectsPacketHandler implements IDataPacketHandler
{
	public static final byte effPacketDisc = 4;
	@Override
	public void handleData(NBTTagCompound data)
	{
		if(!data.hasKey("dcEff")) return;
		String type = data.getString("dcEff");
		if(type.equals("plOnly"))
		{
			EntityPlayer pl = Minecraft.getMinecraft().thePlayer;
			EntityEffectStore ees = EffectHandler.getEffectStore(pl);
			ees.loadNBTData(data);
		}
	}

}