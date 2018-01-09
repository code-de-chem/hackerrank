package temp;

/**
 *
 * @author Kewl
 */
public class IntervalTree {

    public static void main(String[] args) {
        
        int[] a = new int[]{15,10,17,5,12,30};
        int[] b = new int[]{20,30,19,20,15,40};
        ITNode root = null;
        for(int i = 0; i <a.length; i++){
            root = insert(root, new Interval(a[i], b[i]));
        }
        inorder(root);
        Interval x = new Interval(4, 21);
        Interval res = overlapSearch(root, x);
        if(res != null)
            System.out.println("Overlaps with ["+res.low+" , "+res.hi+"]");
    }
    static void inorder(ITNode root)
{
    if (root == null) return;
 
    inorder(root.left);
 
    System.out.println("["+root.i.low+ ", "+root.i.hi+"]"+ " max = "+ root.max);
 
    inorder(root.right);
}
    static Interval overlapSearch(ITNode root, Interval i) {
        if (root == null) {
            return null;
        }

        // If given interval overlaps with root
        if (doOVerlap(root.i, i)) {
            return root.i;
        }
        if (root.left != null && root.left.max >= i.low) {
            return overlapSearch(root.left, i);
        }

        // Else interval can only overlap with right subtree
        return overlapSearch(root.right, i);
    }

    static boolean doOVerlap(Interval i1, Interval i2) {
        if (i1.low <= i2.hi && i2.low <= i1.hi) {
            return true;
        }
        return false;
    }

    static ITNode insert(ITNode root, Interval i) {
        if (root == null) {
            return newNode(i);
        }

        int l = root.i.low;

        if (i.low < l) {
            root.left = insert(root.left, i);
        } else {
            root.right = insert(root.right, i);
        }

        if (root.max < i.hi) {
            root.max = i.hi;
        }

        return root;
    }

    static ITNode newNode(Interval i) {
        ITNode temp = new ITNode();
        temp.i = new Interval(i.low, i.hi);
        temp.max = i.hi;
        temp.left = temp.right = null;
        return temp;
    }

    static class Interval {

        int low, hi;

        Interval(int low, int hi) {
            this.low = low;
            this.hi = hi;
        }
    }

    static class ITNode {

        Interval i;
        int max;
        ITNode left, right;
    }
}
