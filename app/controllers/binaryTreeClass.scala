package binarytreepkg

class node {

}

class binaryTreeClass {
   val x = 5;

   val root = null;

   def preOrderTraversal(startNode:node): String = {
      "pre"
   }
   def inOrderTraversal(startNode:node): String = {
      "in"
   }
   def postOrderTraversal(startNode:node): String = {
      "post"
   }
}

object binaryTree extends binaryTreeClass {
   def getx(): Int = {
      x
   }
}
