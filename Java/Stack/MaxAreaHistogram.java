import java.util.Stack;

public class MaxAreaHistogram {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length,max = 0;

        int [] vectorNsl = new int [size],vectorNsr = new int [size];
        int slC = 0,srC = size-1;  
        Stack<Integer> nsl = new Stack<Integer>();
        Stack<Integer> nsr = new Stack<Integer>();
        for(int i = 0,j=size-1; i<size;i++,j--){
            if(nsl.isEmpty()){
                vectorNsl[slC++] = -1;
            }
            else if(!nsl.isEmpty() && heights[nsl.peek()]<heights[i]){
                vectorNsl[slC++] = nsl.peek();
            }
            else if(!nsl.isEmpty() && heights[nsl.peek()]>= heights[i]){
                while(!nsl.isEmpty() && heights[nsl.peek()]>=heights[i]){
                    nsl.pop();
                }
                vectorNsl[slC++] = (!nsl.isEmpty())?nsl.peek():-1;
            }
            nsl.push(i);

            if(nsr.isEmpty()){
                vectorNsr[srC--] = size;
            }
            else if(!nsr.isEmpty() && heights[nsr.peek()]<heights[j]){
                vectorNsr[srC--] = nsr.peek();
            }
            else if(!nsr.isEmpty() && heights[nsr.peek()]>= heights[j]){
                while(!nsr.isEmpty() && heights[nsr.peek()]>=heights[j]){
                    nsr.pop();
                }
                vectorNsr[srC--] = (!nsr.isEmpty())?nsr.peek():size;
            }
            nsr.push(j);
        }

        int [] width  = new int [size];
        int [] area = new int [size];
        for(int i=0;i<size;i++){
            
            width[i] = vectorNsr[i] - vectorNsl[i] -1;
            area[i] = width[i]*heights[i];
            if(max< area[i]){
                max = area[i];
            }   
        }
        return max;

    }
    public int[] NSL(int[] heights,int size){
        int [] vectorNsl = new int [size],vectorNsr = new int [size];
        int slC = 0,srC = size-1;  
        Stack<Integer> nsl = new Stack<Integer>();
        Stack<Integer> nsr = new Stack<Integer>();
        for(int i = 0,j=size-1; i<size;i++,j--){
            if(nsl.isEmpty()){
                vectorNsl[slC++] = -1;
            }
            else if(!nsl.isEmpty() && heights[nsl.peek()]<heights[i]){
                vectorNsl[slC++] = nsl.peek();
            }
            else if(!nsl.isEmpty() && heights[nsl.peek()]>= heights[i]){
                while(!nsl.isEmpty() && heights[nsl.peek()]>=heights[i]){
                    nsl.pop();
                }
                vectorNsl[slC++] = (!nsl.isEmpty())?nsl.peek():-1;
            }
            nsl.push(i);

            if(nsr.isEmpty()){
                vectorNsr[srC--] = size;
            }
            else if(!nsr.isEmpty() && heights[nsr.peek()]<heights[j]){
                vectorNsr[srC--] = nsr.peek();
            }
            else if(!nsr.isEmpty() && heights[nsr.peek()]>= heights[j]){
                while(!nsr.isEmpty() && heights[nsr.peek()]>=heights[j]){
                    nsr.pop();
                }
                vectorNsr[srC--] = (!nsr.isEmpty())?nsr.peek():size;
            }
            nsr.push(j);
        }
        return vectorNsl;
    }
    public int[] NSR(int[] heights,int size){
        int [] vector = new int [size];
        int k = size-1;  
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = size-1; i>= 0;i--){
            if(stack.isEmpty()){
                vector[k--] = size;
            }
            else if(!stack.isEmpty() && heights[stack.peek()]<heights[i]){
                vector[k--] = stack.peek();
            }
            else if(!stack.isEmpty() && heights[stack.peek()]>= heights[i]){
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                vector[k--] = (!stack.isEmpty())?stack.peek():size;
            }
            stack.push(i);
        }
        return vector;
    }
}
