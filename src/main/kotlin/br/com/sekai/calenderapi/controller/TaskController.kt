package br.com.sekai.calenderapi.controller

import br.com.sekai.calenderapi.data.vo.v1.TaskVO
import br.com.sekai.calenderapi.services.TaskServices
import br.com.sekai.calenderapi.util.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:8080" , "http://127.0.0.1:5173"])
@RestController
@RequestMapping("/task/v1")
class TaskController {

    @Autowired
    private lateinit var taskServices: TaskServices

    @GetMapping(produces = [MediaType.APPLICATION_JSON])
    fun findAll(): List<TaskVO>{
        return taskServices.findAll()
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON], consumes = [MediaType.APPLICATION_JSON])
    fun create(@RequestBody taskVO: TaskVO): TaskVO{
        return taskServices.create(taskVO)
    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON], consumes = [MediaType.APPLICATION_JSON])
    fun update(@RequestBody taskVO: TaskVO): TaskVO{
        return taskServices.update(taskVO)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(name = "id") id: Long) : ResponseEntity<*>{
        taskServices.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}
