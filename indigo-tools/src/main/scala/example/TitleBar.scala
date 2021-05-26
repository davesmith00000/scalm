package example

import scalm.{Html, Scalm, Sub, Cmd}
import scalm.Html._
import scalm.Component

object TitleBar extends Component:

  type Model = Unit

  type Msg = Unit

  def subscriptions(model: Model): Sub[Msg] =
    Sub.Empty

  def update(msg: Msg, model: Model): (Model, Cmd[Msg]) =
    ((), Cmd.Empty)

  def view(model: Model): Html[Msg] =
    div(`class`("full-width-container")) {
      text("indigo")
    }
