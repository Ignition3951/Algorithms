package com.utk.leetcode.problem355;

import java.util.Arrays;
import java.util.List;

public class TwitterImpl {

    static void main() {
        Twitter twitter = null;
        List<String> operations = Arrays.asList("Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed");
        List<List<Integer>> values = Arrays.asList(
                List.of(),
                List.of(1, 5),
                List.of(1),
                List.of(1, 2),
                List.of(2, 6),
                List.of(1),
                List.of(1, 2),
                List.of(1)
        );
        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "Twitter":
                    twitter = new Twitter();
                    System.out.print("null ");
                    break;
                case "postTweet":
                    assert twitter != null;
                    twitter.postTweet(values.get(i).get(0), values.get(i).get(1));
                    System.out.print("null ");
                    break;
                case "getNewsFeed":
                    assert twitter != null;
                    System.out.print(twitter.getNewsFeed(values.get(i).getFirst())+" ");
                    break;
                case "follow":
                    assert twitter != null;
                    twitter.follow(values.get(i).get(0), values.get(i).get(1));
                    System.out.print("null ");
                    break;
                case "unfollow":
                    assert twitter != null;
                    twitter.unfollow(values.get(i).get(0), values.get(i).get(1));
                    System.out.print("null ");
                    break;
            }
        }
    }
}
