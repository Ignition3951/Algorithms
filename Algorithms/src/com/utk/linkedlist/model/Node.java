package com.utk.linkedlist.model;

public class Node {

    private int data;
    private Node next;

    public Node() {
        this.data = 0;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node convertArrayToLL(int[] target) {
        Node head = new Node(target[0], null);
        Node temp = head;
        for (int i = 1; i < target.length; i++) {
            temp.next = new Node(target[i], null);
            temp = temp.next;
        }
        return head;
    }

    public Node insertAtHead(Node head, int x) {
        return new Node(x, head);
    }

    public int searchAnElement(Node head, int target) {
        while (head.next != null) {
            if (head.data == target) return 1;
            head = head.next;
        }
        return 0;
    }

    public int lengthOfLinkedList(Node head) {
        int counter = 1;
        while (head.next != null) {
            head = head.next;
            ++counter;
        }
        return counter;
    }

    public void deleteNode(Node node) {
        while (node.next != null) {
            if (node.next.data == node.data) {
                node.next = node.next.next;
                node.next.next = null;
                return;
            }
            node = node.next;
        }
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    @SuppressWarnings("unused")
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    @SuppressWarnings("unused")
    public Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public boolean isPalindrome(Node head) {
        if (head == null) return false;
        if (head.next == null) return true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node tail = reverseList(slow.next);
        Node first = head;
        Node second = tail;
        while (second != null) {
            if (first.data != second.data) {
                reverseList(tail);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(tail);
        return true;
    }

    public Node oddEvenLinkedList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node oddHead = head;
        Node evenHead = head.next;
        Node tempSecond = evenHead;
        while (evenHead != null && evenHead.next != null) {
            oddHead.next = oddHead.next.next;
            evenHead.next = evenHead.next.next;

            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = tempSecond;
        return head;
    }

    public Node removeNthFromEnd(Node head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public Node deleteMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public Node sortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        Node leftHead;
        Node rightHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        rightHead = slow.next;
        slow.next = null;
        leftHead = sortLinkedList(head);
        rightHead = sortLinkedList(rightHead);

        return mergeLinkedList(leftHead, rightHead);
    }

    public Node mergeLinkedList(Node leftHead, Node rightHead) {
        Node dummyHead = new Node(-1);
        Node temp = dummyHead;

        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                dummyHead.next = leftHead;
                dummyHead = leftHead;
                leftHead = leftHead.next;
            } else {
                dummyHead.next = rightHead;
                dummyHead = rightHead;
                rightHead = rightHead.next;
            }
        }

        if (leftHead != null) dummyHead.next = leftHead;
        else dummyHead.next = rightHead;

        return temp.next;
    }

    public Node sortListOf0And1(Node head) {
        Node zero = new Node(0);
        Node tempZero = zero;
        Node one = new Node(1);
        Node tempOne = one;
        Node two = new Node(2);
        Node tempTwo = two;
        while (head != null) {//1 0 2 0 1
            if (head.data == 0) {
                zero.next = head;
                zero = head;
            } else if (head.data == 1) {
                one.next = head;
                one = head;
            } else {
                two.next = head;
                two = head;
            }
            head = head.next;
        }
        zero.next = ((tempOne.next == null) ? tempTwo.next : tempOne.next);
        one.next = tempTwo.next;
        two.next = null;
        return tempZero.next;
    }

    @SuppressWarnings({"unused", "ReassignedVariable"})
    public Node getIntersectionNode(Node headA, Node headB) {
        int counterA = 0;
        int counterB = 0;
        Node slow;
        Node fast;
        Node tempA = headA;
        Node tempB = headB;
        while (tempA != null) {
            ++counterA;
            tempA = tempA.next;
        }
        while (tempB != null) {
            ++counterB;
            tempB = tempB.next;
        }
        int diff;
        if (counterA > counterB) {
            fast = headA;
            slow = headB;
            diff = counterA - counterB;
        } else {
            fast = headB;
            slow = headA;
            diff = counterB - counterA;
        }
        while (diff > 0 && fast != null) {
            --diff;
            fast = fast.next;
        }
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }

    public Node addOne(Node head) {
        Node tail = reverseList(head);
        Node temp = tail;
        int carry = 1;
        while (tail != null) {
            if (tail.data + carry > 9) {
                tail.data = 0;
            } else {
                tail.data = tail.data + carry;
                carry = 0;
                break;
            }
            tail = tail.next;
        }
        Node resultNode = reverseList(temp);
        if (carry == 1) {
            Node newHeadNode = new Node(1);
            newHeadNode.next = resultNode;
            return newHeadNode;
        }
        return resultNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
