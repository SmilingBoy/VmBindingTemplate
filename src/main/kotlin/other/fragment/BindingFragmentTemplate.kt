package other.fragment


import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val bindingFragmentTemplate
    get() = template {
        revision = 1
        name = "Binding Fragment"
        description = "用于创建ViewBindingFragment"
        minApi = MIN_API
        minBuildApi = MIN_API
        category = Category.Other

        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )


        lateinit var layoutName: StringParameter

        val activityClass = stringParameter {
            name = "Fragment Name"
            default = "Main"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${fragmentToLayout(activityClass.value)}" }
        }
        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )
        recipe = { data: TemplateData ->
            bindingFragmentRecipe(
                data as ModuleTemplateData,
                activityClass.value,
                layoutName.value,
                packageName.value
            )
        }
    }

val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }