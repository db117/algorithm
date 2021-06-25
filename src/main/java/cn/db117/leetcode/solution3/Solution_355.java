//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 设计 哈希表 链表 堆（优先队列） 
// 👍 225 👎 0


package cn.db117.leetcode.solution3;

import java.util.*;

/**
 * 355.设计推特.design-twitter
 *
 * @author db117
 * @since 2021-06-25 16:32:32
 **/

public class Solution_355 {
    public static void main(String[] args) {
        Twitter twitter = new Solution_355().new Twitter();

        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Twitter {
        /**
         * 时间
         */
        int time;
        // 关注 用户id -> 关注的用户的id
        Map<Integer, Set<Integer>> follow = new HashMap<>();
        // 推文列表  用户id -> 推文id
        Map<Integer, List<Integer>> tweet = new HashMap<>();
        // 推文时间
        Map<Integer, Integer> tweetTime = new HashMap<>();
        // 优先队列,获取前10条推文
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        /**
         * Initialize your data structure here.
         */
        public Twitter() {

        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (!tweet.containsKey(userId)) {
                tweet.put(userId, new ArrayList<>());
            }

            tweet.get(userId).add(tweetId);

            tweetTime.put(tweetId, time);
            time++;
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            // 所有可以展示的人
            Set<Integer> follows = follow.getOrDefault(userId, new HashSet<>());
            follows.add(userId);

            // 所有推文
            for (Integer user : follows) {
                if (tweet.containsKey(user)) {
                    for (Integer tweetId : tweet.get(user)) {
                        // 排序推文
                        // 高32位为时间,可以保证循序
                        priorityQueue.add((long) tweetTime.get(tweetId) << 32 | tweetId);
                    }
                }
            }


            List<Integer> ans = new ArrayList<>();

            while (!priorityQueue.isEmpty() && ans.size() < 10) {
                // 只要低32位
                ans.add(priorityQueue.poll().intValue());
            }

            priorityQueue.clear();
            return ans;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (!follow.containsKey(followerId)) {
                follow.put(followerId, new HashSet<>());
            }

            follow.get(followerId).add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (follow.containsKey(followerId)) {
                follow.get(followerId).remove(followeeId);
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}