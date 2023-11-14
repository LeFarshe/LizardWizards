package com.lizardwizards.lizardwizards.core.gameplay.collision;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;

import java.util.ArrayList;
import java.util.List;

public final class Raycast {
    private Raycast(){ }

    public static RaycastResult raycastFirstHit(Line ray, List<EntityWrapper> entities, List<CollisionLayer> hittableLayers){
        RaycastResult result = null;
        Line newRay = ray.clone();

        for (EntityWrapper entity: entities){
            if (hittableLayers.contains(entity.collider.layer)){
                List<Vector2> collision = entity.collider.IntersectLine(newRay);
                if (!collision.isEmpty()){
                    newRay.end = collision.get(0);
                    List<Vector2> newCollision = new ArrayList<>();
                    newCollision.add(collision.get(0));
                    result = new RaycastResult(entity, newCollision);
                }
            }
        }
        return result;
    }

    public static List<RaycastResult> raycast(Line ray, List<EntityWrapper> entities, List<CollisionLayer> hittableLayers){
        return collidingRaycast(ray, entities, hittableLayers, new ArrayList<>());
    }

    public static List<RaycastResult> collidingRaycast(Line ray, List<EntityWrapper> entities
            , List<CollisionLayer> hittableLayers, List<CollisionLayer> stoppingLayers){
        Line newRay = ray.clone();
        List<RaycastResult> results = new ArrayList<>();

        for (EntityWrapper entity: entities){
            if (hittableLayers.contains(entity.collider.layer) || stoppingLayers.contains(entity.collider.layer)){
                List<Vector2> collision = entity.collider.IntersectLine(newRay);
                if (!collision.isEmpty()) {
                    if (stoppingLayers.contains(entity.collider.layer)) {
                        newRay.end = collision.get(0);
                    }
                    if (hittableLayers.contains(entity.collider.layer)) {
                        results.add(new RaycastResult(entity, collision));
                    }
                }
            }
        }

        double maxDistance = newRay.getLength();
        results.removeIf(result -> result.hits.get(0).DistanceTo(newRay.start) > maxDistance);
        for (RaycastResult result: results){
            result.hits.removeIf(vector -> vector.DistanceTo(newRay.start) > maxDistance);
        }

        results.sort((raycast1, raycast2) -> {
            double distanceDifference = raycast2.hits.get(0).DistanceTo(newRay.start) - raycast1.hits.get(0).DistanceTo(newRay.start);
            if (distanceDifference > 0) {
                return 1;
            } else if (distanceDifference < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        return results;
    }
}
