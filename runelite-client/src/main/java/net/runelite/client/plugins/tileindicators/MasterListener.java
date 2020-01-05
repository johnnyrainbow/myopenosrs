package net.runelite.client.plugins.tileindicators;

import net.runelite.api.Client;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.input.MouseAdapter;

import javax.inject.Inject;
import java.awt.event.MouseEvent;

public class MasterListener extends MouseAdapter {
	private final Client client;

	@Inject
	private MasterListener(final Client client) {
		this.client = client;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent mouseEvent) {
		int clickType = mouseEvent.getButton();
		if (clickType == 2) { //middle click
			if (client.getSelectedSceneTile() != null) {
				WorldPoint wp = client.getSelectedSceneTile().getWorldLocation();
				LocalPoint lp1 = LocalPoint.fromWorld(client, wp);
				if (lp1 != null) {
					client.getScene().walkToTargetTile(lp1.getSceneX(), lp1.getSceneY());
				}
			}
		}
		return super.mousePressed(mouseEvent);
	}
}
