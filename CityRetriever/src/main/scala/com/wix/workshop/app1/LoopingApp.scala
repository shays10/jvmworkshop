package com.wix.workshop.app1

import com.wix.workshop.app1.cache.CityCache

import scala.util.Random


object LoopingApp {

  def main(args: Array[String]) {
    println("Looping Starting....")
    val cache = new CityCache
    while (true) {
      cache.getCity(Random.nextInt(10))
    }
  }
}
