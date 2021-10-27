package com.techbow.homework.y2021.m10.Sammy;

import java.util.HashSet;

public class LC1650_LCANode {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> set = new HashSet<>();
        Node curP = p;
        while (curP != null) {
            set.add(curP);
            curP = curP.parent;
        }

        Node curQ = q;
        while (curQ != null) {
            if (set.contains(curQ)) {
                return curQ;
            }
            curQ = curQ.parent;
        }
        return null;
    }
}
