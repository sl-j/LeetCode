package ds;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {

    Deque<Integer> s1;
    Deque<Integer> s2;
    public CQueue() {
    s1 = new LinkedList<Integer>();
    s2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
    s1.push(value);
    }

    public int deleteHead() {
    if(!s2.isEmpty()){
        return s2.pop();
    }else {
        if(s1.isEmpty()){
            return -1;
        }else {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
    }
    return s2.pop();
    }
}
