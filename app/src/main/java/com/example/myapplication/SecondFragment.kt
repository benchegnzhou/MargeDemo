package com.example.myapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textview_second.text = getDesc()
        button_1.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        button_2.setOnClickListener {
            animation_view.setAnimation("like_button.json")
            animation_view.loop(false) //设置动画是否循环播放，true表示循环播放，false表示只播放一次
            animation_view.playAnimation()
        }
        button_3.setOnClickListener {
            animation_view.setAnimation("like_button.json")
            animation_view.loop(true) //设置动画是否循环播放，true表示循环播放，false表示只播放一次
            animation_view.playAnimation()
        }
        button_4.setOnClickListener {

        }
        button_5.setOnClickListener {
            animation_view.setAnimationFromJson(
                resources.getString(R.string.animation1_json),
                "animalJson"
            )
            animation_view.loop(true) //设置动画是否循环播放，true表示循环播放，false表示只播放一次
            animation_view.playAnimation()
        }

    }

    /**
     * 获取字符串
     */
    fun getDesc(): String {
        return "简介\n" +
                "Lottie是Android和iOS的移动图书馆，用于解析Adobe After Effects动画，并以Bodymovin作为json导出，并在手机和网络上本机呈现。\n" +
                "\n" +
                "该项目在GitHub已经获得三个端累计3万+的star。\n" +
                "在Lottie社区提供了更多的动画下载。\n" +
                "如果你是一个设计师还可以将自己制作的作品发布到该社区。\n" +
                "\n" +
                "优势\n" +
                "使用方便、简单\n" +
                "无需担心屏幕尺寸适配问题\n" +
                "减少项目开发时间，增加交互的趣味性\n" +
                "针对平台包括了缓存和预加载功能，增加动画的流畅性\n" +
                "可以通过网络Json地址加载"
    }
}