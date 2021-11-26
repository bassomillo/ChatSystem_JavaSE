package com.SuperChain;

public class  SuperLink {
    //head of the chain
    private Node head;
    private int currentIndex = -1;

    //insert to the head
    public void addToHead(int data){
        this.add(0,data);
    }

    //insert
    public void add(int index, int data){
        if(head==null){
            head = new Node(data,null);
        }else {
            if(index == 0){
                Node node = new Node(data,head);
                head = node;
            }else {
                Node node = selectNode(index-1);
                //insert node in the index place
                Node newNode = new Node(data, node.getNext());
                node.setNext(newNode);
            }
        }
        currentIndex++;
    }
    //insert to the end
    public void addToTail(int data){
        this.add(currentIndex+1,data);
    }

    //delete
    public void delete(int index){
        if(index == 0){
            head = head.getNext();
        }else {
            Node node = selectNode(index-1);
            node.setNext(node.getNext().getNext());
        }
        currentIndex--;
    }
    //set
    public void set(int index, int data){
        Node node = selectNode(index);
        node.setData(data);
    }

    //search
    public Integer select(int index){
       return selectNode(index).getData();
    }
    // PULBLIC method
    public Node selectNode(int index){
        //find node with index
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    //length of the array
    public int arrayLength(){
        return currentIndex++;
    }

    public String arrayToString(){
        String res = "[";
        for (int i = 0; i <= currentIndex; i++) {
            res += select(i)+",";
        }
        return res.substring(0,res.length()-1)+"]";
    }


    public void sort(){
        for (int i = 0; i < currentIndex; i++) {
            for (int j = 0; j < currentIndex - i; j++) {
                if(select(j)>select(j+1)){
                    int temp = select(j);
                    selectNode(j).setData(selectNode(j+1).getData());
                    selectNode(j+1).setData(temp);

                }
            }
        }
    }

    public void sort1(){
        for (int i = 0; i < currentIndex; i++) {
            Node node = null;
            for (int j = 0; j < currentIndex - i; j++) {
                if (j==0){
                    node = head;
                }else{
                    node = node.getNext();
                }
                Node next = node.getNext();
                if(node.getData()>next.getData()){
                    int temp = node.getData();
                    node.setData(next.getData());
                    next.setData(temp);
                }
            }
        }
    }

    public void sort2(){
        for (int i = 0; i < currentIndex; i++) {
            for (int j = 0; j < currentIndex - 1; j++) {
                Node node = selectNode(j);
                Node next = node.getNext();
                if(node.getData()>next.getData()){
                    int temp = node.getData();
                    node.setData(next.getData());
                    next.setData(temp);
                }
            }
        }
    }

    public Node reverse(Node node){
        Node pre = null;
        if (node == null){
            return null;
        }
        while (node != null){
            Node next = node.getNext();
            node.setNext(pre);
            pre=node;
            node=next;

        }
        head = pre;
        return head;
    }

}
