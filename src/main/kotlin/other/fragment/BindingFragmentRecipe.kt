package other.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.activity.res.bindingActivityXml
import other.fragment.src.bindingFragmentKt

fun RecipeExecutor.bindingFragmentRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension


    val mvvmActivity =
        bindingFragmentKt(projectData.applicationPackage, activityClass, layoutName, packageName)
    // 保存Fragment
    save(mvvmActivity, srcOut.resolve("${activityClass}Fragment.${ktOrJavaExt}"))
    // 保存xml
    save(bindingActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

}
