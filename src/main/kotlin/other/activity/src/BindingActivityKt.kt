package other.activity.src

import com.android.tools.idea.wizard.template.PackageName


fun bindingAcitivityKt(
    applicationPackage: PackageName?,
    activityClass: String,
    layoutName: String,
    packageName: String
) = """
    
package $packageName
import android.os.Bundle
import com.smile.base.ui.activity.BaseBindingActivity
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Activity${activityClass}Binding
class ${activityClass}Activity : BaseBindingActivity<Activity${activityClass}Binding>() {
   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initData()
        initEvent()
    }
    
    private fun initViews() {
    
    }  
    
    private fun initData() {
    
    }
      
    private fun initEvent() {
    
    }
    
    
}
    
""".trimIndent()
