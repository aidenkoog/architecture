package io.github.aidenkoog.android_wear_os.presentation.setting.fragment

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieAnimationView
import com.orhanobut.logger.Logger
import io.github.aidenkoog.android_wear_os.BR
import io.github.aidenkoog.android_wear_os.R
import io.github.aidenkoog.android_wear_os.databinding.FragmentSettingMainBinding
import io.github.aidenkoog.android_wear_os.presentation.base.fragment.BaseFragment
import io.github.aidenkoog.android_wear_os.presentation.setting.viewmodel.SettingMainViewModel
import io.github.aidenkoog.android_wear_os.utils.utils.LottieUtil
import io.github.aidenkoog.android_wear_os.utils.utils.NavigationUtil

class SettingMainFragment : BaseFragment() {
    private var viewDataBinding: FragmentSettingMainBinding? = null
    private val viewModelData: SettingMainViewModel? by viewModels()

    private lateinit var loadingLottieView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentSettingMainBinding.inflate(inflater, container, false)
        viewDataBinding?.setVariable(BR.settingMainViewModel, viewModelData)
        viewDataBinding?.executePendingBindings()
        loadingLottieView = viewDataBinding?.loadingLottieView!!
        return viewDataBinding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.d("onViewCreated:")
        startLottieAnimation()
    }

    private fun startLottieAnimation() {
        LottieUtil.setLottieRawResource(loadingLottieView, R.raw.setting_loading)
        LottieUtil.setLottieSpeed(loadingLottieView, 1.2f)
        LottieUtil.addLottieAnimatorListener(loadingLottieView, lottieAnimationCallback)
        LottieUtil.playLottie(loadingLottieView)
    }

    private val lottieAnimationCallback = object : LottieUtil.LottieAnimatorListener {
        override fun onAnimationStart(animator: Animator?) {
            Logger.i("Started animation")
        }

        override fun onAnimationEnd(animator: Animator?) {
            Logger.i("End animation")
        }

        override fun onAnimationCancel(animator: Animator?) {
            Logger.i("Canceled animation")
        }

        override fun onAnimationRepeat(animator: Animator?) {
            Logger.i("Repeated animation")
        }

    }

    private fun setDataObserver() {
        viewModelData?.isLoaded?.observe(this) {
            if (it == true) {
                Logger.i("Loaded!")
            }
        }
    }
}