package example


case class Rune(
                 character: String,
                 latinCharacters: List[String]) {
  def supportsLatin(latin: String): Boolean =
    latinCharacters.contains(latin)


}



trait RuneMap {
  val runes: List[Rune]
}

class ElderFuthark extends RuneMap {
  val runes = List(
    Rune("ᚠ", List("F")),
    Rune("ᚢ", List("U")),
    Rune("ᛏ", List("T")),
    Rune("ᚺ", List("H")),
    Rune("ᚨ", List("A")),
    Rune("ᚱ", List("R")),
    Rune("ᚲ", List("K","C")),
    Rune("ᛒ", List("B")),

  )
}

class Translator {
  def translateToLatin(text: String, runeMap: RuneMap): String = {
    println("translating " + text)
    text
      .map(x => x.toString)
      .map { character =>
        println("handling " + character)
        val rune = runeMap.runes.find(_.character == character).orNull
        if (rune!= null) {
           rune.latinCharacters.head
        } else {
           character
        }
      }.mkString
  }

  def translateFromLatin(text: String, runeMap: RuneMap): String = {
    text.toCharArray.toString
  }
}

object Translator {
  def apply(): Translator = new Translator()
}
