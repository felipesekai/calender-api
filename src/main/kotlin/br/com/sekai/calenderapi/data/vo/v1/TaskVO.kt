package br.com.sekai.calenderapi.data.vo.v1

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import java.util.Date
import javax.persistence.*

@JsonPropertyOrder("id", "title", "data", "hour", "duration", "description")
data class TaskVO(
    @field:JsonProperty("id")
    var key : Long = 0,
    var title: String = "",
    var description: String? = null,
    @JsonFormat(pattern = "yyyy-MM-dd")
    var data: Date = Date(),
    var hour: Int = 0,
    var duration: Int? = null,
)
