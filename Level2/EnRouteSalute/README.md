## En Route Salute
Commander Lambda loves efficiency and hates anything that wastes time. The Commander is a busy lamb, after all! Henchmen who identify sources of inefficiency and come up with ways to remove them are generously rewarded. You've spotted one such source, and you think solving it will help you build the reputation you need to get promoted. Every time the Commander's employees pass each other in the hall, each of them must stop and salute each other -- one at a time -- before resuming their path. A salute is five seconds long, so each exchange of salutes takes a full ten seconds (Commander Lambda's salute is a bit, er, involved). You think that by removing the salute requirement, you could save several collective hours of employee time per day. But first, you need to show the Commander how bad the problem really is.

Write a program that counts how many salutes are exchanged during a typical walk along a hallway. The hall is represented by a string. For example:"--->-><-><-->-", Each hallway string will contain three different types of characters: '>', an employee walking to the right; '<', an employee walking to the left; and '-', an empty space. Every employee walks at the same speed either to right or to the left, according to their direction. Whenever two employees cross, each of them salutes the other. They then continue walking until they reach the end, finally leaving the hallway. In the above example, they salute 10 times.Write a function solution(s) which takes a string representing employees walking along a hallway and returns the number of times the employees will salute. s will contain at least 1 and at most 100 characters, each one of -, >, or <.

### Test Cases
#### Test case 1
Input:
```
Solution.solution(">----<")
```

Output:
2
#### Test case 2
Input:
```aidl
Solution.solution("<<>><")
```

Output:
4

### Solution Idea
We traverse from end to beginning, 
- if we saw one `<`, we increment a counter for `walkToLeftCount`
- if we saw one `>`, then this employee that walk to right will definitely meet the curr `walkToLeftCount` number of employee. We increment the count for `res`, which represents the number of meet-up will happen.

As each meet-up will have 2 hand shakes, the end result will be `2 * res`.