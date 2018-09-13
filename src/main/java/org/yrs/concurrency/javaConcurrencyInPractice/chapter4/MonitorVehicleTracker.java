package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangrusheng
 * @Description: 基于监视器模式的车辆追踪
 * @Date: Created in 20:10 2018/9/13
 * @Modified By:
 */
@ThreadSafe
public class MonitorVehicleTracker {
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(this.locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint point = this.locations.get(id);
        return point == null ? null : new MutablePoint(point);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint point = this.locations.get(id);
        if (point == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        point.x = x;
        point.y = y;
    }

    private Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();
        for (String id : locations.keySet()) {
            result.put(id, new MutablePoint(locations.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }
}
