package node;

import LinkedList.LinkedList;

public class Node<E> {
    private E data;
    private Node link;
    public Node(E data,Node link)
    {
        this.data=data;
        this.link=link;
    }
    public E getData()
    {
        return data;
    }
    public Node getLink()
    {
        return link;
    }
    public void setData(E element)
    {
        data=element;
    }
    public void setLink(Node link)
    {
        this.link=link;
    }
    public void addAfter(E element)
    {
        link=new Node(element,link);
    }
    public void removeAfter()
    {
        link=link.link;
    }
    public static int listlength(Node head)
    {
        int length=0;
        while(head!=null)
        {
            length++;
            head=head.link;
        }
        return length;
    }
    public Node listsearch(Node head, E target)
    {
        while (head!=null)
        {
            if(head.data==target)
                return head;

            head=head.link;
        }
        return null;
    }
    public static Node listcopy(Node head)
    {
        Node copylist;
        Node temp;
        copylist=new Node(head.data,null);
        temp=copylist;
        while (head!=null)
        {
            head=head.link;
            temp.addAfter(head.data);
            temp=temp.link;
        }
        return  copylist;
    }

    
}