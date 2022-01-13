package com.techbow.homework.y2021.m10.ryanxu.LC_1146;

import java.util.HashMap;
import java.util.TreeMap;

class SnapshotArray {

    private TreeMap<Integer, HashMap<Integer, Integer>> snapshotPool; // [snapId, updatedCell]
    private int count;
    public SnapshotArray(int length) {
        this.snapshotPool = new TreeMap<>();
        this.count = 1;
        this.snapshotPool.put(-1, new HashMap<>());
    }

    public void set(int index, int val) {

        HashMap<Integer, Integer> cur = this.snapshotPool.getOrDefault(this.count - 1, new HashMap<>());
        cur.put(index, val);
        this.snapshotPool.put(this.count - 1, cur);
    }

    public int snap() {
        this.count++;
        return this.count - 2;
    }

    public int get(int index, int snap_id) {

        int curSnapID = this.snapshotPool.floorKey(snap_id);
        while (!this.snapshotPool.get(curSnapID).containsKey(index)) {
            if (curSnapID == -1) {
                return 0;
            }
            curSnapID = this.snapshotPool.floorKey(curSnapID - 1);
        }
        return this.snapshotPool.get(curSnapID).get(index);
    }
}
