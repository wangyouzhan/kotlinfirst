package com.avic.kotlinfirst.coroutineAdapters.model

import com.google.gson.annotations.SerializedName

data class CrewResult(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("cast") var cast: List<Cast> = listOf(),
    @SerializedName("crew") var crew: List<Crew> = listOf()
)


data class Crew(
    @SerializedName("credit_id") var creditId: String = "",
    @SerializedName("department") var department: String = "",
    @SerializedName("gender") var gender: Int = 0,
    @SerializedName("id") var id: Int = 0,
    @SerializedName("job") var job: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("profile_path") var profilePath: String = ""
)


data class Cast(

    @SerializedName("cast_id") var castId: Int = 0,
    @SerializedName("character") var character: String = "",
    @SerializedName("credit_id") var creditId: String = "",
    @SerializedName("gender") var gender: Int = 0,
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("order") var order: Int = 0,
    @SerializedName("profile_path") var profilePath: String = ""

)