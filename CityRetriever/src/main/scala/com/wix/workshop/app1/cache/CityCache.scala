package com.wix.workshop.app1.cache

import com.wix.workshop.app1.model.{City, CityId}

import scala.collection.immutable.HashMap

class CityCache {

  var cache: Map[CityId, City] = HashMap.empty

  def getCity(id: Long): City = {
    val cityId = new CityId(id)
    cache.get(cityId) match {
      case Some(city) => city
      case None =>
        val city = getCityFromDB(cityId)
        cache = cache + (cityId -> city)
        city
    }
  }

  //This emulates a remote call to DB
  private def getCityFromDB(cityId: CityId): City = {
    // The 'arr' parameter is here to make the City object larger. It's not the root cause.
    City(cityId.getId, "shortName", "name", "Israel", 3000, arr = new Array[String](1024 * 10))
  }
}
