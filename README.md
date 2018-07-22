# Rune Core

Yet another rune conversion tool on my GitHub, what is going on?

Well I had been playing with the idea in Go and C because I wanted a very small tool inside the unix pipeline to convert to and 
from Elder futhark

But it occurred to me that this problem, if the code were designed properly, could map basically any rune set you gave it. So I turned to Scala of course
because who wouldn't want to solve this problem in such a language?

The intention here is to have a really simple function that does the deed, like:

```scala
def translateToLatin(text: String, runeMap: RuneMap): String 
```

and 

```scala
def translateFromLatin(text: String, runeMap: RuneMap): String 
```

`RuneMap` would be a Trait and we can create RuneMaps for Elder Futhark, Younger Futhark, Dragon Language... whatever your heart desires really. The thing pretty much works like a Caesar cipher but with One to Many mappings.