package com.utk.leetcode.problem355;

import java.util.*;

class Twitter {

    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> follows;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        if (tweets.containsKey(userId)) {
            for (int i = 0; i < tweets.get(userId).size(); i++) {
                pq.offer(tweets.get(userId).get(i));
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }


        if (follows.containsKey(userId)) {
            for (int followerKey : follows.get(userId)) {
                if (tweets.containsKey(followerKey)) {
                    for (int i = 0; i < tweets.get(followerKey).size(); i++) {
                        pq.offer(tweets.get(followerKey).get(i));
                        if (pq.size() > 10) {
                            pq.poll();
                        }
                    }
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll()[1]);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }

    }
}
