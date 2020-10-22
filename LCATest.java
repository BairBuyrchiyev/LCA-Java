import static org.junit.Assert.*;
import org.junit.Test;

public class LCATest {

	@Test
	public void testFindLCA() {
		LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        assertEquals("LCA of 4 and 5", 2, tree.findLCA(4, 5));
        assertEquals("LCA of 4 and 6", 1, tree.findLCA(4, 6));
        assertEquals("LCA of 3 and 4", 1, tree.findLCA(3, 4));
        assertEquals("LCA of 2 and 4", 2, tree.findLCA(2, 4));
        
        LCA tree1 = new LCA();
        assertEquals("Empty tree", -1, tree1.findLCA(2, 4));
	}

}
