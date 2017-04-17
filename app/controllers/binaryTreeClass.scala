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

   def insert(data:Int) = {
      // Insertion of first node
      val newNode = new Node(data)

      var trvPtr = root

      if (root == null)
         root = newNode
      else { // Insertion of additional nodes
         while (trvPtr != null) {
            val trvPtrParent = trvPtr
            if (newNode.data < trvPtr.data) {
               trvPtr = trvPtr.leftChild
               if (trvPtr == null) {
                  trvPtrParent.leftChild = newNode
               }
            } else {
               trvPtr = trvPtr.rightChild
               if (trvPtr == null) {
                  trvPtrParent.rightChild = newNode
               }
            }
         } // end while
      } // end if/else
      result = data.toString + " inserted!"
   }



   def visit(nodeToVisit : Node) = { /* Pure function */
      this.traversalResult + nodeToVisit.data
   }

   def preOrderTraversal(startNode : Node): String = {

      if (startNode == this.root) // reset result variable to print traversals
         this.traversalResult = ""

      if (startNode != null) {
         traversalResult = visit(startNode)
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
