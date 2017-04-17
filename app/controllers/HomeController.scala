package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request =>
    Ok(views.html.index())
  }

  // debug remove
  // def handle = Action { implicit request =>
  // request.body.asFormUrlEncoded.get("action").headOption match {
  //   case Some("insert") => Ok("Clicked edit")
  //   case Some("remove") => Ok("Clicked remove")
  //   case _ => BadRequest("This action is not allowed")
  // }
  // }

}
