package Leetcode_datastructures.BFS;

import java.util.*;

class Clone_Graph_BFS_section_But_implemented_like_DFS {
}
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
class Solution {

    public Node cloneGraph(Node node) {

        return cloneGraph2(node,new HashSet<Node>(),new HashMap<Node,Node>());

    }

    public Node cloneGraph2(Node node, Set<Node> sett, Map<Node,Node> mapp) {

        if(node==null){
            return null;
        }
        if(node.neighbors== null || node.neighbors.size()==0){
            sett.add(node);
            return new Node(node.val,node.neighbors);
        }

        Node copyNode = new Node();
        copyNode.val=node.val;
        copyNode.neighbors = new ArrayList();
        sett.add(node);
        mapp.put(node,copyNode);

        for(int i=0;i<node.neighbors.size();i++){

            if(!sett.contains(node.neighbors.get(i))){
                Node childNode =  cloneGraph2(node.neighbors.get(i),sett,mapp);

                copyNode.neighbors.add(childNode);
            }else{
                copyNode.neighbors.add(mapp.get(node.neighbors.get(i)));
            }

        }

        return copyNode;

    }

}