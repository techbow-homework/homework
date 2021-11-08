package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.List;
import java.util.Map;

//in queries, each string has the format "A <name>" or "D <name>". "A" for allocate and "D" for deallocate.
// When allocating a <name>, append the index(1,2,3,4 ...) to the <name> as the real name in the system. Always append the smallest missing index.
// When deallocating, need to specify the index, such as tracker.deallocate("name1"). It is valid to deallocate an index not exist.

public class Tracker {
    private Map<String, List<Integer>> map;

}
