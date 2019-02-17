package org.sagi.cowfarm.modulus;

public class FarmList {

    private Node head;

    private class Node {
        private Cow element;
        private Node next;

        public Node(Cow element, Node next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    public boolean addCow(int motherId, Cow calf) {
        Cow motherCow = null;
        if (head == null) {
            calf.setGeneration(0);
            head = new Node(calf, null);
            head.element = calf;
            return true;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = head;
            motherCow = head.element;
            while (last.next != null) {
                last = last.next;
                if (last.element.getId() == motherId) {
                    motherCow = last.element;
                }
            }

            calf.setMother(motherCow);
            calf.setGeneration(motherCow.getGeneration() + 1);
            Node newNode = new Node(calf, null);

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

    public void printFarmReport() {
        Node last = head;

        if (head != null) {
            if (head.next == null) {
                System.out.println( head.toString());
            } else {
                System.out.println(last.toString());
                while (last.next != null) {
                    last = last.next;
                    String generationIdent = "";
                    for (int i = 0; i < last.element.getGeneration(); i++) {
                        generationIdent = generationIdent + "\t\t\t\t|";
                    }
                    System.out.println(generationIdent + last.toString() +"\t|");
                }
            }
        }
    }
}
