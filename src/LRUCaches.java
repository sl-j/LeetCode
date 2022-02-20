import sun.awt.image.ImageWatched;
import sun.misc.LRUCache;

import java.util.*;

public class LRUCaches {

    class LinkNode{
        int key;
        int value;
        LinkNode front;
        LinkNode next;
        public LinkNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer,LinkNode> map;
    LinkNode head;//设置头结点
    LinkNode tail;//设置尾结点
    int capacity;
    public LRUCaches(int capacity) {
        map = new HashMap<>();
        head = new LinkNode(0,0);
        tail = new LinkNode(0,0);
        this.capacity = capacity;
        head.next = tail;
        tail.front = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LinkNode linkNode = map.get(key);
            moveNodeToTop(linkNode);//访问过的结点放在最前方
            return linkNode.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        //如果存在相同的key值，取出对应的结点，修改value的值，并且放在双向链表的最前方
        if(map.containsKey(key)){
            LinkNode linkNode = map.get(key);//取出对应的结点
            linkNode.value = value;//修改value的值
            moveNodeToTop(linkNode);//将此结点移到最前方
        }else {
            if(map.size() == capacity) { removeLastNode(); }//如果达到容量上限，删除最后面的结点(最久未访问的结点在最后面)
            LinkNode linkNode = new LinkNode(key,value);
            map.put(key,linkNode);//map中不存在，则存入

            //存入的结点要放在链表的最前方
            LinkNode tmp = head.next;//保存头结点之后的结点
            head.next = linkNode;//头结点的next指向新增结点
            linkNode.front = head;//要新增结点的front指向头结点
            linkNode.next = tmp;//新增结点的front指向保存的tmp
            tmp.front = linkNode;//tmp的front指向新增结点
        }
    }

    //删除最后一个结点
    public void removeLastNode(){
        LinkNode tmp = tail.front;
        tmp.front.next = tail;//最后一个结点的前一个结点指向尾结点
        tail.front = tmp.front;//尾结点指向最后一个结点的前一个结点
        map.remove(tmp.key);
    }
    //将结点移到链表最前方
    public void moveNodeToTop(LinkNode linkNode){
        linkNode.front.next = linkNode.next;//断开node前一个结点和node的联系
        linkNode.next.front = linkNode.front;//链接node的前一个结点和node的后一个结点
        LinkNode tmp = head.next;//保存head之后的链表
        head.next = linkNode;
        linkNode.front = head;
        linkNode.next = tmp;
        tmp.front = linkNode;
    }
}
