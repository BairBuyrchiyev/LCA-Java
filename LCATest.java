import static org.junit.Assert.*;
import org.junit.Test;

public class LCATest {

	@Test
	public void testFindLCA() {
		LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.addChild((new Node(2)));
        tree.root.getChild(1).addChild(new Node(3));
        tree.root.getChild(1).getChild(1).addChild(new Node(4));
        tree.root.getChild(1).getChild(1).getChild(1).addChild(new Node(7));
        tree.root.getChild(1).addChild(new Node(5));
        tree.root.getChild(1).getChild(2).addChild(new Node(6));
        tree.root.getChild(1).getChild(2).getChild(1).addChild(new Node(7));
        
        System.out.println(tree.root.data);
        System.out.println(tree.root.getChild(1).data);
        System.out.println(tree.root.getChild(1).getChild(1).data + "   " + tree.root.getChild(1).getChild(2).data);
        System.out.println(tree.root.getChild(1).getChild(1).getChild(1).data + "   " + tree.root.getChild(1).getChild(2).getChild(1).data);
        System.out.println(tree.root.getChild(1).getChild(1).getChild(1).getChild(1).data + " " + tree.root.getChild(1).getChild(2).getChild(1).getChild(1).data);
        
        /*
        
        1
        |
        2
        | \
        3  5
        |  |
        4  6
         \/
         7
         
        */
        
        assertEquals("LCA of 4 and 5", 2, tree.findLCA(4, 5));
        assertEquals("LCA of 4 and 6", 2, tree.findLCA(4, 6));
        assertEquals("LCA of 3 and 4", 3, tree.findLCA(3, 4));
        assertEquals("LCA of 2 and 4", 2, tree.findLCA(2, 4));
        
        LCA tree1 = new LCA();
        assertEquals("Empty tree", -1, tree1.findLCA(2, 4));
	}

}