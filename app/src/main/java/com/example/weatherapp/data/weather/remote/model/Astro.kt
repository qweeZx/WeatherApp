package com.example.weatherapp.data.weather.remote.model

import com.google.gson.annotations.SerializedName


data class Astro (

  @SerializedName("sunrise"           ) var sunrise          : String? = null,
  @SerializedName("sunset"            ) var sunset           : String? = null,
  @SerializedName("moonrise"          ) var moonrise         : String? = null,
  @SerializedName("moonset"           ) var moonset          : String? = null,
  @SerializedName("moon_phase"        ) var moonPhase        : String? = null,
  @SerializedName("moon_illumination" ) var moonIllumination : Double?    = null,
  @SerializedName("is_moon_up"        ) var isMoonUp         : Long?    = null,
  @SerializedName("is_sun_up"         ) var isSunUp          : Long?    = null

)