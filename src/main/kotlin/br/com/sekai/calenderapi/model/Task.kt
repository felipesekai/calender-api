package br.com.sekai.calenderapi.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date
import java.util.TimeZone
import java.util.Timer
import javax.persistence.*

@Entity
@Table()
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,
    @Column(length = 80, nullable = false)
    var title: String = "",
    @Column(length = 250, )
    var description: String? = null,
    @Column(nullable = false,columnDefinition = "Date" )
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    var data: Date = Date(),
    @Column(nullable = false, )
    var hour: Int = 0,
    @Column(nullable = true)
    var duration: Int? = null,


)
