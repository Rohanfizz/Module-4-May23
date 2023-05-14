import java.io.*;
import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int q=sc.nextInt();
        sc.nextLine();
        TextEditor obj=new TextEditor();
        for(int i=0;i<q;i++)
        {
            // String[] s = sc.nextLine().split(" "); 
            String s=sc.nextLine();
            if(s.equals("UNDO"))
            {
                obj.UNDO();
            }
            else if(s.equals("REDO"))
            {
                obj.REDO();
            }
            else if(s.equals("READ"))
            {
               obj.READ();

            }
            else
            {
                char ch=s.charAt(6);
                obj.WRITE(ch);
            }
        }
    }
}

class TextEditor{
    // your code here
	//https://course.acciojob.com/idle?question=81e92f10-8cae-412f-8d37-c0478c4619f5
	static Stack<Character> curr  = new Stack<>();
	static Stack<Character> prev  = new Stack<>();
    static void WRITE(char X)
    {
		curr.push(X);
    }
  
    static void UNDO()
    {
		if(curr.size() == 0) return;
        prev.push(curr.pop());
    }
  

    static void REDO(){
		if(prev.size() == 0) return;
	    curr.push(prev.pop());
    }

    static void READ(){
      Stack<Character> temp = new Stack<>();
		while(curr.size() > 0) temp.push(curr.pop()); //moving all the elements of curr to temp
		while(temp.size()>0){
			System.out.print(temp.peek());
			curr.push(temp.pop());
		}
		System.out.print(" ");
		
    }

}