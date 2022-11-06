package br.com.sekai.calenderapi.mapper

import br.com.sekai.calenderapi.data.vo.v1.TaskVO
import br.com.sekai.calenderapi.model.Task

fun Task.toVO() = TaskVO(this.id, this.title,this.description, this.data, this.hour, this.duration)
fun TaskVO.toEntity() = Task(this.key, this.title,this.description, this.data, this.hour, this.duration)

fun taskListToVO(taskList: List<Task>): List<TaskVO> {
    val list : ArrayList<TaskVO> = ArrayList()
            taskList.forEach {
                list.add(it.toVO())
            }
    return list
}

fun taskListVOToEntity(taskList: List<TaskVO>): List<Task> {
    val list : ArrayList<Task> = ArrayList()
    taskList.forEach {
        list.add(it.toEntity())
    }
    return list
}
