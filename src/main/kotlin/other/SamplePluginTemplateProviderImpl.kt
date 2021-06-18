package other


import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.activity.bindingActivityTemplate
import other.fragment.bindingFragmentTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> {
        return listOf(bindingActivityTemplate, bindingFragmentTemplate)
    }
}