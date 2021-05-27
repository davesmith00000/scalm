package example

import scalm.{Html, Scalm, Sub, Cmd}
import scalm.Html._
import scalm.Component

object TitleBar:
  def view[Msg]: Html[Msg] =
    div(`class`("full-width-container p-0"), style("filter", "drop-shadow(0px 4px 4px #00000055)"))(
      div(`class`("full-width-container"), style("background-color", "#29016A"))(
        img(src("images/indigo_logo_solid_text.svg"), height("40px"))
      )
    )
