package net.runelite.rs.api;

import net.runelite.api.ActorMovement;
import net.runelite.api.CollisionData;
import net.runelite.mapping.Import;

public interface RSMovementEvent extends ActorMovement, RSRouteStrategy
{

	@Override
	@Import("hasArrived")
	boolean atDestinationMaybe(int var1, int x, int y, CollisionData var4);
}
