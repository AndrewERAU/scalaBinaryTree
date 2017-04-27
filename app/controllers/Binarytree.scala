package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import binarytreepkg._

class Binarytree @Inject() extends Controller {


   def insert = Action { implicit request =>
     request.body.asFormUrlEncoded.get("action").headOption match {
       case Some("insert") => {
          // extract item from DOM to use for whatever operation was pressed
          //http://stackoverflow.com/questions/11212248/how-do-i-access-post-data-from-scala-play
          val userNum = request.body.asFormUrlEncoded.get("userNum").lift(0)
          userNum map {_.toInt} getOrElse 0
          binaryTree.insert(userNum.get.toInt,binaryTree.root)

          Redirect("/") // just stay on home page. don't reload page
          //Ok("Clicked insert " + binaryTree.insert(userNum.get.toInt))
       }
       case Some("search") => {
          // extract item from DOM to use for whatever operation was pressed
          //http://stackoverflow.com/questions/11212248/how-do-i-access-post-data-from-scala-play
          val userNum = request.body.asFormUrlEncoded.get("userNum").lift(0)
          userNum map {_.toInt} getOrElse 0
          binaryTree.search(userNum.get.toInt,binaryTree.root)

          Redirect("/") // just stay on home page. don't reload page
       }
       case Some("remove") => {
          // extract item from DOM to use for whatever operation was pressed
          //http://stackoverflow.com/questions/11212248/how-do-i-access-post-data-from-scala-play
          val userNum = request.body.asFormUrlEncoded.get("userNum").lift(0)
          userNum map {_.toInt} getOrElse 0
          binaryTree.remove(userNum.get.toInt,binaryTree.root)

          Redirect("/") // just stay on home page. don't reload page
       }
       case _ => BadRequest("This action is not allowed")
     }
   }

   Redirect("/index.html")

}
