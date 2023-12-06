/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.StringTokenizer;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if(current!=null) {
                ans += Integer.toString(current.val) + " ";
                queue.add(current.left);
                queue.add(current.right);
            }
            else ans += "null ";
        }
        // int lastIndex = -1;
        // for(int i=0;i<ans.length();i++) {
        //     if(ans.charAt(i)>='0' && ans.charAt(i)<='9') lastIndex = i;
        // }
        // if(lastIndex==-1) return "null";
        // System.out.println("Serialize output: " + ans.substring(0, lastIndex+1));
        // return ans.substring(0, lastIndex+1);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        StringTokenizer st = new StringTokenizer(data, " ");
        int i = 1; // index starts from 1
        Queue<TreeNode> queue = new LinkedList<>(); 
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            TreeNode temp = null;
            if(!token.equals("null")) {
                temp = new TreeNode(Integer.parseInt(token));
                queue.add(temp);
            }
            if(root==null) {
                root = temp;
            }
            else {
                if(i%2==0) { // even index is left child
                    queue.peek().left = temp;
                }
                else { // odd index is right child
                    queue.peek().right = temp;
                    queue.remove();
                }
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));