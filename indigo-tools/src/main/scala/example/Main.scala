package example

import scalm.{Html, Scalm, Sub, Cmd, Style}
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
    div(`class`("full-width-container p-0"))(
      TitleBar.view,
      div(`class`("full-width-container"), style("padding-top", "40px"))(
        img(src("images/indigo_logo_full.svg"), height("300px"), styles(Styles.centerImage))
      )
    )

  def subscriptions(model: Model): Sub[Msg] =
    Sub.Empty

  def main(args: Array[String]): Unit =
    Scalm.start(document.getElementById("myapp"), init, update, view, subscriptions)

object Styles:
  val centerImage: Style =
    Style(
      "display"      -> "block",
      "margin-left"  -> "auto",
      "margin-right" -> "auto",
      "width"        -> "50%"
    )
