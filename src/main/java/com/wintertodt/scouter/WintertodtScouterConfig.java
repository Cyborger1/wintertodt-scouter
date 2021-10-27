package com.wintertodt.scouter;

import com.wintertodt.scouter.ui.WintertodtScouterPanelType;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("wintertodtscouter")

public interface WintertodtScouterConfig extends Config
{
	String NETWORK_UPLINK = "get uplink";
	String NETWORK_DOWNLINK = "get downlink";

	@ConfigItem
			(
				keyName = NETWORK_UPLINK,
				position = 0, name = "Realtime Uplink",
				description = "Web endpoint to upload boss data to"
			)
	default String wintertodtGetDownlinkConfig()
	{
		return "https://www.wintertodt.com/scouter/";
	}

	@ConfigItem(keyName = NETWORK_DOWNLINK,
				position = 1,
				name = "Realtime Downlink",
				description = "Web endpoint to get boss data from"
	)
	default String wintertodtGetUplinkConfig()
	{

		return "https://www.wintertodt.com/scouter/";
	}

	default WintertodtScouterPanelType wintertodtScouterPanelType()
	{
		return WintertodtScouterPanelType.CONDENSED;
	}

	@ConfigItem(
			keyName = "worldHopperEnabled",
			position = 2,
			name = "Double click to Hop",
			description = "Enables double clicking worlds in the side view panels to quick-hop to them"
	)
	default boolean isWorldHopperEnabled()
	{
		return true;
	}
}
