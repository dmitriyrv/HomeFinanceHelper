package com.helper.finance

import com.helper.finance.service._

object Main {
  def main(args: Array[String]) {
    println("We're running scala..")
    val service = new Some
    println(service.getInfo())
  }
}
