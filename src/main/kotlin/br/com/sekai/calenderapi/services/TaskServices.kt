package br.com.sekai.calenderapi.services

import br.com.sekai.calenderapi.data.vo.v1.TaskVO
import br.com.sekai.calenderapi.exceptions.ResourceNotFoundException
import br.com.sekai.calenderapi.mapper.taskListToVO
import br.com.sekai.calenderapi.mapper.toEntity
import br.com.sekai.calenderapi.mapper.toVO
import br.com.sekai.calenderapi.model.Task
import br.com.sekai.calenderapi.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class TaskServices {
    @Autowired
    private lateinit var taskRepository: TaskRepository
    private val logger = Logger.getLogger(TaskServices::class.java.name)

    fun findAll(): List<TaskVO>{
        logger.info("Find All Tasks!!")
        val tasks : List<Task> = taskRepository.findAll()
        return taskListToVO(tasks as ArrayList<Task>)
    }

    fun create (taskVO: TaskVO): TaskVO{
        logger.info("Insert new Task!!!")
        val task: Task = taskVO.toEntity()
        return taskRepository.save(task).toVO()
    }

    fun update(taskVO: TaskVO): TaskVO {
        logger.info("Update a Task!!!")
        val task = taskRepository.findById(taskVO.key)
            .orElseThrow { ResourceNotFoundException("Task with is Id is not found!!") }
        task.title = taskVO.title
        task.data = taskVO.data
        task.description = taskVO.description
        task.hour = taskVO.hour
        task.duration = taskVO.duration

        return taskRepository.save(task).toVO()
    }

    fun delete (id: Long){
        logger.info("Deleting Task with Id: $id")
        val task = taskRepository.findById(id)
            .orElseThrow{ ResourceNotFoundException("task with is Id is not found!!")}

        taskRepository.delete(task)
    }

}
