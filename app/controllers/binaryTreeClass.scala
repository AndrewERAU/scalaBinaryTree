package binarytreepkg

class Node(inData:Int) {
   var data : Int = inData;
   var rightChild : Node = _;
   var leftChild : Node = _;
}

class binaryTreeClass {

   // syntax - update
   // http://stackoverflow.com/questions/11215915/scala-type-constraints-doesnt-allow-null
   var root : Node = _;

   var traversalResult : String = "";

   var result : String = "";

   def insert(data:Int, node:Node): Unit = { // unit is used for recursive function with 'no' return type

      // Insertion of first node
      if (root == null) {
         result = "root null"
         root = new Node(data)
      } else if (data < node.data) {
         if (node.leftChild == null)
            node.leftChild = new Node(data)
         else
            insert(data,node.leftChild)
      } else { // (data > node.data) { // data == parent.data. arbitraily choose right
         if (node.rightChild == null)
            node.rightChild = new Node(data)
         else
            insert(data,node.rightChild)
      }
      result = data.toString + " inserted!"
   }

   def search(data:Int,node:Node,parentNode:Node = null): (Node,Node) = {
      if (node == null) {
         result = data.toString + " not found."
         return (null, null)
      } else {
         if (node.data == data) {
            result = data.toString + " found!"
            return (node,parentNode)
         } else if (data < node.data) {
            search(data,node.leftChild,node)
         } else {
            search(data,node.rightChild,node)
         }
      }
   }

   def remove(data:Int, node:Node, parentOfStartNode:Node = null) {
      val (nodeToRemove, parentOfNodeToRemove) = search(data, node, parentOfStartNode)
      if (nodeToRemove == null) {
         result =  data + " not removed (not found in tree)"
         return
      } else if (nodeToRemove.leftChild == null && nodeToRemove.rightChild == null) {
         // both children equal null. easy. simply remove node
         if (nodeToRemove == root) {
            root = null // tree was just 1 node, now its 0 nodes
         } else if (parentOfNodeToRemove.leftChild != null &&
            parentOfNodeToRemove.leftChild.data == nodeToRemove.data) {
            // finds child of parent that should be deleted
            parentOfNodeToRemove.leftChild = null
         } else {
            parentOfNodeToRemove.rightChild = null
         }
      } else if (nodeToRemove.leftChild == null || nodeToRemove.rightChild == null) {
         // one child equals null. have parent point to child
         if (nodeToRemove.leftChild == null) {
            if (nodeToRemove == root) {
               root = root.rightChild
            } else if (parentOfNodeToRemove.leftChild != null &&
               parentOfNodeToRemove.leftChild.data == nodeToRemove.data) {
               // finds child of parent that should be deleted
               parentOfNodeToRemove.leftChild = nodeToRemove.rightChild
            } else {
               parentOfNodeToRemove.rightChild = nodeToRemove.rightChild
            }
         } else {// right child == nil
            if (nodeToRemove == root) {
               root = root.leftChild
            } else if (parentOfNodeToRemove.leftChild != null &&
               parentOfNodeToRemove.leftChild.data == nodeToRemove.data) {
               // finds child of parent that should be deleted
               parentOfNodeToRemove.leftChild = nodeToRemove.leftChild
            } else {
               parentOfNodeToRemove.rightChild = nodeToRemove.leftChild
            }
         }
      } else {
         // node-to-remove has 2 children
         // no special logic required for removing root in this case
         // find smallest value in right subtree
         // functional. tailrecursion
         def findNodeWithSmallestValueInSubtree(node:Node,minNode:Node=node): Node = {
            if (node == null) minNode // done traversing. return minimum node
            else findNodeWithSmallestValueInSubtree(node.leftChild,node)
         }
         val minimumNode = findNodeWithSmallestValueInSubtree(nodeToRemove.rightChild)
         /*
         var trvPtr = nodeToRemove.rightChild
         var minimumNode: Node = trvPtr
         while (trvPtr != null) {
            minimumNode = trvPtr
            trvPtr = trvPtr.leftChild
         }*/

         // replace value of node-to-remove with value of minimum
         nodeToRemove.data = minimumNode.data

         // remove minimum node from right subtree since it has been moved
         remove(nodeToRemove.data, nodeToRemove.rightChild,nodeToRemove)
      }

      result = "Removed " + data.toString + "!"
   }

   def visit(nodeToVisit : Node) = { /* Pure function */
      if (this.traversalResult != "")
         this.traversalResult + ", " + nodeToVisit.data
      else
         nodeToVisit.data.toString
   }

   def preOrderTraversal(startNode : Node): String = {

      if (startNode == this.root) // reset result variable to print traversals
         this.traversalResult = ""

      if (startNode != null) {
         this.traversalResult = visit(startNode)
         preOrderTraversal(startNode.leftChild)
         preOrderTraversal(startNode.rightChild)
      }

      this.traversalResult

   }
   def inOrderTraversal(startNode : Node): String = {
      if (startNode == this.root) // reset result variable to print traversals
         this.traversalResult = ""

      if (startNode != null) {
         inOrderTraversal(startNode.leftChild)
         traversalResult = visit(startNode)
         inOrderTraversal(startNode.rightChild)
      }

      this.traversalResult
   }
   def postOrderTraversal(startNode : Node): String = {
      if (startNode == this.root) // reset result variable to print traversals
         this.traversalResult = ""

      if (startNode != null) {
         postOrderTraversal(startNode.leftChild)
         postOrderTraversal(startNode.rightChild)
         traversalResult = visit(startNode)
      }

      this.traversalResult
   }
}

object binaryTree extends binaryTreeClass {
   def getVal(): Int = {
      99
   }
}
