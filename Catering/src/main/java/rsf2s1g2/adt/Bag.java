package rsf2s1g2.adt;

public class Bag<E>
{

    private Node<E> head;

    public Bag()
    {
        head = null;
    }

    public void add(E key)
    {

        if (isEmpty())
        {
            Node<E> newNode = new Node<E>(key);
            head = newNode;
        } else
        {
            Node<E> current = head;
            Node<E> last = head; 
            boolean found = false;
            while (current != null)
            {
                if (current.getKey().equals(key) )
                {
                    current.incrementValue();
                    found = true;
                    break;
                }
                last = current;
                current = current.getNext();
            }

            if (!found)
            {
                Node<E> newNode = new Node<E>(key);
                last.setNext(newNode);
            }

        }

    }

    public boolean remove(E key) 
    {

        if (!contains(key))
        {
            System.out.println("The item '" + key + "' is not located in the Bag");
        } else
        {
            Node<E> current = head;
            Node<E> previous = head;
            while (current != null)
            {
                if (current.getKey().equals(key) )
                {
                    if (current == head) 
                    {
                        current.decreaseValue();
                        if (current.getValue() < 1) 
                        {
                            head = head.getNext();
                            return false;
                        }
                        return true;
                    } else
                    {
                        current.decreaseValue();
                        if (current.getValue() < 1)
                        {
                            previous.setNext(current.getNext());
                            current.setNext(null);
                            return false;
                        }

                        return true;

                    }
                }
                previous = current;
                current = current.getNext();
            }
        }
        return false;
    }

    public int size() 
    {
        Node<E> current = head;
        int size = 0;
        while (current != null)
        {
            size = size + current.getValue();
            current = current.getNext();

        }
        return size;
    }

    public int distictSize()
    {
        Node<E> current = head;
        int counter = 0;
        while (current != null) 
        {
            counter++;
            current = current.getNext();
        }
        
        return counter;
    }

    public int elementSize(E key) 
    {
        Node<E> current = head;
        int elementsize = 0;
        while (current != null) 
        {
            if (current.getKey() == key) 
            {
                elementsize = current.getValue();
                break;
            }

            current = current.getNext();
        }
        
        return elementsize;
    }

    public void clear() {
        head = null;
    }

    public boolean contains(E key)
    {
        Node<E> current = head;
        while (current != null)
        {
            if (current.getKey().equals(key) )
            {

                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public boolean isEmpty()
    {
        if (head == null) 
        {

            return true;
        } else
        {
            return false;
        }
    }

    public void display()
    {
        if (head == null)
        {
            System.out.println("The Bag is empty");

        }
        else
        {
            Node<E> current = head;
        String displayList="List Representation = ";
        while (current != null)
        {
            displayList+="[" + current.getKey() + " , " + current.getValue() + "]" + "--> ";
            
            current = current.getNext();

        }
        System.out.println(displayList + "null" );
    }
    }

    public String toString()
    {
        if(isEmpty())
        {
            return "Bag is empty";
        }
        Node<E> current = head;
        
        String string = "Bag = ";
        while (current != null)
        {
            for (int i = 0; i < current.getValue(); i++) 
            {

                string += "{" + current.getKey() + "}";
            }

            current = current.getNext();
        }
        return string;
    }

}
