package important;

import java.util.Stack;

class Element {
    int data;
    int min;

    Element(int data, int min) {
        this.data = data;
        this.min = min;
    }
}

public class CustomSTack {
    Stack<Element> mystack = new Stack<>();
    public static void main(String [] args){
        CustomSTack sTack = new CustomSTack();
        sTack.push(1);
        sTack.push(2);
        sTack.push(3);
        sTack.push(4);
        System.out.println(sTack.getMin());
        System.out.println(sTack.pop());
    }

    public void push(int x){
        if(mystack.isEmpty()){
            mystack.push(new Element(x,x));
        } else {
            Element temp = mystack.peek();
            Element newnode;
            if(temp.min>x){
                newnode= new Element(x,x);
            } else {
                newnode = new Element(x, temp.min);
            }
            mystack.push(newnode);
        }

    }

    public int getMin(){
        Element temp = mystack.peek();
        return temp.min;
    }

    public int pop(){
        Element temp = mystack.peek();
        return temp.data;
    }

}
