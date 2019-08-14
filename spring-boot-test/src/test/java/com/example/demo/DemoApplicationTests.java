package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
        //l1
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = five;
        //l2
        ListNode zero = new ListNode(0);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        zero.next = three;
        three.next = four;
        ListNode result = DemoApplicationTests.mergeTwoLists(one, zero);
        System.out.println(result);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
         val = x;
    }
}
