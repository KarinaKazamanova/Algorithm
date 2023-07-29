
import java.util.Random;

public class Tree {


    public static void main (String[] args){
    //    Node root = BuildBalanseTree(10);
    //    System.out.println(root.right.value);
       Node[] list = {new Node(15), new Node(1),new Node(3),new Node(4),new Node(5), new Node(6), new Node(31), new Node(31), new Node(16), new Node(14)};
       balanceTree(list,  list.length);
       for (int i = 0; i < list.length; i++){System.out.println(list[i].value + " - " + list[i].colour );}
        


    }

    static int high(Node root){
        if (root== null){
            return 0;

        } else{
            return 1 + Math.max(high(root.left), high(root.right));

        }
       

    }

    static boolean isBalance(Node root){
        int i = 0;
        if (root == null){
            return true;
        }
        i = Math.abs(high(root.right) - high(root.left));
        if (i < 2){
            return true;
        } else{return false;}
    }

    static Node BuildBalanseTree(int count){
        Node root;
        if (count <= 0){
            return null;
        }
        else{
            root = new Node();
            root.value = new Random().nextInt(30);
            root.left = BuildBalanseTree(count/2);
            root.right = BuildBalanseTree(count/2 - 1);
            

        }
        return root;



    }
    static void balanceTree(Node[] values, int end_index){
           
            for (int i = 0; i < end_index / 2 - 1; i ++){
                Node root = values[i];
                Node left_child = values[2 * i + 1];
                Node right_child = values[2 * i + 2];
               
               
                if (root.value <= left_child.value){
                    if (left_child.value > right_child.value && root.value < right_child.value){
                        values[2 * i + 2] = left_child;
                        values[2 * i + 1] = right_child;
                        
                        balanceTree(values, 2 * (i + 2));
                        
                    
                    }
                    else{
                
                        values[i] = left_child;
                        values[2 * i + 1] = root;
                          if (values[(i -1) /2].colour.equals("") | values[(i -1) /2].colour.equals("красный"))
                        {
                            values[i].colour = "черный";
                            
                        }
                        else{
                            values[i].colour = "красный";
                        }
                        balanceTree(values, 2 * (i + 2));
                        

                        
                    }

                }
                if(root.value > right_child.value){
                       
                    
                        values[i] = right_child;
                        values[2 * i + 2] = root;
                          if (values[(i -1) /2].colour.equals("") | values[(i -1) /2].colour.equals("красный"))
                        {
                            values[i].colour = "черный";
                            
                        }
                        else if (values[(i -1) /2].colour.equals("черный")){
                            values[i].colour = "красный";
                        }
                        balanceTree(values, 2 * (i + 2));
                    

                    
                    
                

                }
                
              if (values[(i - 1) / 2].colour.equals("красный") && (i*2 + 2) <= values.length)
                        {
                            values[i].colour = "черный";
                          
                            
                        }
                        else{
                            values[i].colour = "красный";
                   
                            
                        }
          
            
            
            }
            for (int i = values.length / 2 + 2; i < values.length; i ++){
                if( values[(i -1) /2].colour.equals("черный")){
                values[i].colour = "красный";}

            }
            
        
            

        
    }

   

    
}


class Node {
    int value;
    Node left;  // index = index * 2 + 1
    Node right; // index = index * 2 + 2
    Node next;
    String colour;
    public Node(int value, Node right, Node left, String colour){
        this.value = value;
        this.left = left;
        this.right = right;
        this.colour = colour;
        this.next = null;
    }
    public Node(int value){
        this(value, null, null, "черный");
    }
    public Node(){
        this(0, null, null, "черный");

    }
}
