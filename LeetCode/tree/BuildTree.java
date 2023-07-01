import java.util.HashMap;
import java.util.Map;

import generic.TreeNode;

public class BuildTree {
    Map<Integer,Integer> mapIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mapIdx = new HashMap<Integer,Integer>();
        return buildChild(preorder,inorder,0,0,preorder.length-1);
    }
    public TreeNode buildChild(int[] preorder, int[] inorder,int idx,int start, int end){
        if(idx >= preorder.length || start>end) return null;
        int pos;
        TreeNode root = new TreeNode(preorder[idx]);
        if(mapIdx.containsKey(preorder[idx])){
            pos = mapIdx.get(preorder[idx]);
        }
        else{
            for(pos = start;pos <= end && preorder[idx]!=inorder[pos];pos++){
                mapIdx.put(inorder[pos],pos);
            }
        }
        // System.out.println("Root:"+root.val+"\tLeft\nIndex:"+(idx+1)+"\tStart:"+start+"\tEnd:"+(pos-1)+"\tPos:"+pos+"\n");
        root.left = buildChild(preorder,inorder,idx+1,start,pos-1); 
        // System.out.println("Root:"+root.val+"\tRight\nIndex:"+(pos+1)+"\tStart:"+(pos+1)+"\tEnd:"+(end)+"\tPos:"+pos+"\n");
        
        root.right = buildChild(preorder,inorder,idx+1+(pos-start),pos+1,end);
        
        return root;
    }
}
