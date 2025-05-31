// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description
// 2359. Find Closest Node to Given Two Nodes
// Difficulty: Medium

import java.util.Arrays;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int l = edges.length;

        int[] d1 = new int[l];
        int[] d2 = new int[l];
        Arrays.fill(d1, 100001);
        Arrays.fill(d2, 100001);
        d1[node1] = 0;
        d2[node2] = 0;
        int dist = 0;

        for (int i=0; i<l; i++) {
            node1 = edges[node1];
            if (node1 == -1) break;
            if (d1[node1] < dist++) break;
            d1[node1] = dist;
        }

        dist = 0;
        for (int i=0; i<l; i++) {
            node2 = edges[node2];
            if (node2 == -1) break;
            if (d2[node2] < dist++) break;
            d2[node2] = dist;
        }

        int minnode = -1;
        int mindist = 100001;
        int dist1, dist2;
        for (int i=0; i<l; i++) {
            dist1 = d1[i];
            dist2 = d2[i];
            if (dist1 == 100001 || dist2 == 100001) continue;
            if (minnode == -1 || Math.max(dist1, dist2) < mindist) {
                mindist = Math.max(dist1, dist2);
                minnode = i;
            }
        }
        return minnode;
    }
}