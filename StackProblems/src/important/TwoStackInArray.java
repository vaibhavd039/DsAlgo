package important;

public class TwoStackInArray {
    int [] arr;
    int top1, top2;
    TwoStackInArray(int x){
        arr= new int[x];
        top1=-1;
        top2 =x;
    }

    public static void main(String [] args){
        TwoStackInArray stack = new TwoStackInArray(10);
        stack.push1(1);
        stack.push1(2);
        stack.push1(5);
        stack.push1(6);

        stack.push2(3);
        stack.push2(4);
        stack.push2(7);
        stack.push2(8);
        stack.push2(9);
        stack.push2(10);
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());
        System.out.println(stack.pop1());

        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());



    }

    public void push1(int x) {
        if(top1<top2-1){
            top1++;
            arr[top1]=x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public void push2(int x) {
        if(top1<top2-1){
            top2--;
            arr[top2]=x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public int pop1(){
        if(top1>=0){
            int x = arr[top1];
            top1--;
            return x;
        } else{
            System.out.println("Stack underflow");
        }
        return -1;
    }
    public int pop2(){
        if(top2<arr.length){
            int x = arr[top2];
            top2++;
            return x;
        } else{
            System.out.println("Stack underflow");
        }
        return -1;
    }


}
