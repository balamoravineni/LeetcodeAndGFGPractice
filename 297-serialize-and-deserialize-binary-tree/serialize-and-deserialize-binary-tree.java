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
        // return serializeUsingPreorderAndInorder(root);
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
        int lastIndex = -1;
        for(int i=0;i<ans.length();i++) {
            if(ans.charAt(i)>='0' && ans.charAt(i)<='9') lastIndex = i;
        }
        if(lastIndex==-1) return "null";
        System.out.println("Serialize output: " + ans.substring(0, lastIndex+1));
        return ans.substring(0, lastIndex+1);
    }

    String serializeUsingPreorderAndInorder(TreeNode root) {
        String[] ans = new String[2];
        ans[0] = "";
        ans[1] = "";
        inorderTraversal(root, ans);
        preorderTraversal(root, ans);
        // System.out.println("Returned: " + ans[0] + "$" + ans[1]);
        return ans[0] + "$" + ans[1];
    }

    void inorderTraversal(TreeNode root, String[] ans) {
        if(root==null) return;
        inorderTraversal(root.left, ans);
        ans[0] = ans[0] + Integer.toString(root.val) + " ";
        inorderTraversal(root.right, ans);
    }

    void preorderTraversal(TreeNode root, String[] ans) {
        if(root==null) return;
        ans[1] = ans[1] + Integer.toString(root.val) + " ";
        preorderTraversal(root.left, ans);
        preorderTraversal(root.right, ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // return deserializeUsingPreorderAndInorder(data);
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

    TreeNode deserializeUsingPreorderAndInorder(String data) {
        StringTokenizer st = new StringTokenizer(data, "$");
        String inorderString = null, preorderString = null;
        while(st.hasMoreTokens()) {
            if(inorderString==null) inorderString = st.nextToken();
            else preorderString = st.nextToken();
        }
        // System.out.println("Inorder: " + inorderString);
        // System.out.println("Preorder: " + preorderString);
        if(inorderString==null || preorderString==null) return null;
        StringTokenizer inorderST = new StringTokenizer(inorderString, " ");
        StringTokenizer preorderST = new StringTokenizer(preorderString, " ");
        int len = inorderST.countTokens();
        System.out.println("Length: " + len);
        int[] inorder = new int[len];
        int[] preorder = new int[len];
        Map<Integer,Integer> inorderMap = new HashMap<>();
        int i=0;
        while(inorderST.hasMoreTokens()) {
            inorder[i] = Integer.parseInt(inorderST.nextToken());
            inorderMap.put(inorder[i], i);
            preorder[i] = Integer.parseInt(preorderST.nextToken());
            i++;
        }
        System.out.print("Inorder array: ");
        for(int temp: inorder) System.out.print(temp + " ");
        System.out.println();
        System.out.print("Preorder array: ");
        for(int temp: preorder) System.out.print(temp + " ");
        System.out.println();
        return buildTree(inorderMap, inorder, preorder, 0, len-1, 0, len-1);
    }

    TreeNode buildTree(Map<Integer,Integer> inorderMap, int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if(preStart>preEnd || inStart>inEnd) return null;
        int current = preorder[preStart];
        TreeNode root = new TreeNode(current);
        int index = findIndex(inorder, current, inStart, inEnd);
        if(index==-1) return root;
        root.left = buildTree(inorderMap, inorder, preorder, inStart, index-1, preStart+1, preStart+index-inStart);
        root.right = buildTree(inorderMap, inorder, preorder, index+1, inEnd, preStart+index-inStart+1, preEnd);
        return root;
    }

    int findIndex(int[] inorder, int current, int inStart, int inEnd) {
        for(int i=inEnd;i>=inStart;i--) if(inorder[i]==current) return i;
        return -1;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));