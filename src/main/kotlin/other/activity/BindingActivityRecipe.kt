package other.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.activity.res.bindingActivityXml
import other.activity.src.bindingAcitivityKt

public fun com.android.tools.idea.wizard.template.RecipeExecutor.generateManifest(
    moduleData: com.android.tools.idea.wizard.template.ModuleTemplateData,
    activityClass: kotlin.String,
    packageName: kotlin.String,
    isLauncher: kotlin.Boolean,
    hasNoActionBar: kotlin.Boolean,
    noActionBarTheme: com.android.tools.idea.wizard.template.ThemeData /* = compiled code */,
    isNewModule: kotlin.Boolean /* = compiled code */,
    isLibrary: kotlin.Boolean /* = compiled code */,
    manifestOut: java.io.File /* = compiled code */,
    baseFeatureResOut: java.io.File /* = compiled code */,
    generateActivityTitle: kotlin.Boolean,
    isResizeable: kotlin.Boolean /* = compiled code */
): kotlin.Unit { /* compiled code */
}


fun RecipeExecutor.bindingActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
        packageName = packageName,
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false,
    )

    val mvvmActivity =
        bindingAcitivityKt(projectData.applicationPackage, activityClass, layoutName, packageName)
    // 保存Activity
    save(mvvmActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存xml
    save(bindingActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))

}
