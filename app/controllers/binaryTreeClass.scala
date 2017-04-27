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
