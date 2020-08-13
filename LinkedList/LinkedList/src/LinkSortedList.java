public class LinkSortedList extends LinkList {
    
    public LinkSortedList(){
        first = null;
    }

    public void insertSortedList(int data){
        Link newLink = new Link(data);

        Link current;

        if(first == null || first.iData >= newLink.iData){
            newLink.next = first;
            first = newLink;
        }
        else{
            current = first;
            while (current.next != null && current.next.iData < newLink.iData) {
                current = current.next;
                
            }
            newLink.next = current.next;
            current.next = newLink;
        }
    }
}