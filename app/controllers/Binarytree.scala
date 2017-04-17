package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import binarytreepkg._

class Binarytree @Inject() extends Controller {

   def insert = Action { implicit request =>
     request.body.asFormUrlEncoded.get("action").headOption match {
       case Some("insert") => Ok("Clicked insert " + binaryTree.getx())
       case Some("remove") => Ok("Clicked remove")
       case _ => BadRequest("This action is not allowed")
     }
   }
}
