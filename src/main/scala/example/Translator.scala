package example


case class Rune(
                 character: String,
                 latinCharacters: String*) {
  def supportsLatin(latin: String): Boolean =
    latinCharacters.contains(latin)


}



trait RuneMap {
  val runes: List[Rune]
}

class ElderFuthark extends RuneMap {
  val runes = List(
    Rune("ᚠ", "F"),
    Rune("ᚢ", "U"),
    Rune("ᛏ", "T"),
    Rune("ᚺ", "H"),
    Rune("ᚨ", "A"),
    Rune("ᚱ", "R"),
    Rune("ᚲ", "K","C"),
    Rune("ᛒ", "B"),

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
