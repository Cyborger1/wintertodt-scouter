/*
 * Copyright (c) 2021, Cyborger1
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.wintertodt.scouter.ui;

import com.wintertodt.scouter.WintertodtBossData;
import com.wintertodt.scouter.WintertodtScouterPlugin;
import java.util.ArrayList;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.PluginPanel;

@Slf4j
public abstract class WintertodtScouterPluginPanelBase extends PluginPanel
{
	@Getter
	private boolean open = false;

	protected WintertodtScouterPlugin plugin;

	protected WintertodtScouterPluginPanelBase(WintertodtScouterPlugin plugin)
	{
		this(plugin, true);
	}

	protected WintertodtScouterPluginPanelBase(WintertodtScouterPlugin plugin, boolean wrap)
	{
		super(wrap);
		this.plugin = plugin;
	}

	public abstract void populate(ArrayList<WintertodtBossData> bossData);
	public abstract void updateList();

	public void onActivate()
	{
		// If the panel is opened, try to run a get request to populate/refresh the panel.
		log.debug("Activated");
		open = true;
		plugin.hitAPI();
	}

	public void onDeactivate()
	{
		log.debug("Deactivated");
		open = false;
	}
}
