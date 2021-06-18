package com.github.smilingboy.vmbindingtemplate.services

import com.github.smilingboy.vmbindingtemplate.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
