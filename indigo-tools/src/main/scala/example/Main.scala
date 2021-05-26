package example

import scalm.{Html, Scalm, Sub, Cmd}
import scalm.Html._
import org.scalajs.dom.document

object Main:
  type Msg          = Unit
  opaque type Model = Unit

  def init: (Model, Cmd[Msg]) =
    ((), Cmd.Empty)

  def update(msg: Msg, model: Model): (Model, Cmd[Msg]) =
    (model, Cmd.Empty)

  def view(model: Model): Html[Msg] =
    div(`class`("full-width-container"))(
      TitleBar.view(()),
      div(`class`("container")) {
        img(src("images/bump-example.jpg"))
      }
    )

  def subscriptions(model: Model): Sub[Msg] =
    Sub.Empty

  def main(args: Array[String]): Unit =
    Scalm.start(document.getElementById("myapp"), init, update, view, subscriptions)
