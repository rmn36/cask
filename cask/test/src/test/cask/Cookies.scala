package test.cask

object Cookies extends cask.MainRoutes{
  @cask.get("/read-cookie")
  def readCookies(username: cask.CookieParam) = {
    username.cookie.value
  }

  @cask.get("/store-cookie")
  def storeCookies() = {
    cask.Response(
      "Cookies Set!",
      cookies = Seq(cask.Cookie("username", "the username"))
    )
  }

  @cask.get("/delete-cookie")
  def deleteCookie() = {
    cask.Response(
      "Cookies Deleted!",
      cookies = Seq(cask.Cookie("username", "the username", expires = java.time.Instant.EPOCH))
    )
  }

  initialize()
}

