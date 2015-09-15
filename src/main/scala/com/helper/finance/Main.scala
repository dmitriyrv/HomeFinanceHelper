package com.helper.finance

import com.helper.finance.service._

object Main {
  def main(args: String) : String = {
    println("We're running scala..")
    val service = new Some
    service.setInfo(args)
    println(service.getInfo())
    return service.getInfo()
  }
}
