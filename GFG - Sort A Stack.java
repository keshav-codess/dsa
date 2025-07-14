/*Complete the function below*/
class GfG {
    public Stack<Integer> sortHelper(Stack<Integer> s) {
        // add code here.
        if (s.isEmpty()){
            return;
        }
        int top =s.pop();
        // recursion build
        sortHelper(s);
        
        doTheSort( top, s );
    }
    
    public Stack<Integer> sort(Stack<Integer> s) {
        sortHelper(s);
        return;
    }
    
    void doTheSort( int top, Stack<Integer> s){
        
        if(s.isEmpty() || s.peek() < top){
            s.push(top);
            
        }
    }
    
}
