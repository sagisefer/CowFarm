package org.sagi.cowfarm.modulus;

public class FarmList {

    private Node head;

    private static class Node {
        private Cow element;
        private Node next;

        public Node(Cow element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    public boolean addCow(Cow cow) {
        if (head == null) {
            head.element = cow;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            Node newNode = new Node(cow, null);
            // Insert the new_node at last node
            last.next = newNode;
        }
        return true;
    }

    public boolean removeCow(int cowId) {
        Node currNode = head;
        Node prev = null;

        while (currNode != null && currNode.element.getId() != cowId) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            // Display the message
            System.out.println(cowId + " found and deleted");
            return true;
        }
        return false;
    }

    public void printFarmReport(){

    }
}
