package com.utk.leetcode;

import java.util.Arrays;
import java.util.Stack;

// Asteroid Collision
public class Problem735 {

    static void main() {
        int[] asteroids = {-2,-2,-1,-2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {

            //if asteroid is moving right >0 then push
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                // if asteroid is moving left then conditions

                //if arr[-1] is positive then pop until bigger is achieved
                while (!stack.isEmpty() && Math.abs(stack.peek()) < Math.abs(asteroid) && stack.peek() > 0) {
                    stack.pop();
                }

                //if arr[-1] is equal and opposite then pop and don't push
                if (!stack.isEmpty() && Math.abs(stack.peek()) == Math.abs(asteroid) && stack.peek() > 0) {
                    stack.pop();
                }

                //if arr[-1] is negative push
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }


        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
