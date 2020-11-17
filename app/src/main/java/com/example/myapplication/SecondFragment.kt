package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.blankj.utilcode.util.ToastUtils
import com.opensource.svgaplayer.*
import com.opensource.svgaplayer.SVGAParser.ParseCompletion
import kotlinx.android.synthetic.main.fragment_second.*
import java.lang.Exception
import java.net.URL


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    var parser: SVGAParser? = null
    var plagSingleTimes = false
    var plagEndStatus = false
    var flagClearCanver = true
    val list = listOf(
        "alarm.svga",
        "750x80.svga",
        "angel.svga",
        "Castle.svga",
        "EmptyState.svga",
        "Goddess.svga",
        "gradientBorder.svga",
        "heartbeat.svga",
        "matteBitmap.svga",
        "matteRect.svga"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parser = SVGAParser(requireContext())
        button_1.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        button_3.setOnClickListener {
            try {
                parser?.decodeFromURL(
                    URL("http://172.16.20.255:8189/Rocket.svga"), object : SVGAParser.ParseCompletion {
                        override fun onComplete(videoItem: SVGAVideoEntity) {
                            val drawable = SVGADrawable(videoItem)
                            svga_view.setImageDrawable(drawable)
                            svga_view.startAnimation()
                        }

                        override fun onError() {
                            ToastUtils.showShort("动画下载失败了呢")
                        }
                    }
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        button_4.setOnClickListener { v ->
            plagSingleTimes = button_4.isChecked
            playTimes()
        }
        button_5.setOnClickListener { v ->
            plagEndStatus = button_5.isChecked
            playEndStatus()
        }
        button_6.setOnClickListener { v ->
            flagClearCanver = button_6.isChecked
            clearCanver()
        }
        playTimes()
        playEndStatus()

        button_2.setOnClickListener {

            parser?.decodeFromAssets(getSvgaName(), object : ParseCompletion {
                override fun onComplete(videoItem: SVGAVideoEntity) {
                    val drawable = SVGADrawable(videoItem)
                    svga_view.setImageDrawable(drawable)
                    svga_view.startAnimation()
                }

                override fun onError() {

                }
            })

        }

        animationLister()

    }

    private fun animationLister() {
        svga_view.callback = object : SVGACallback {
            override fun onFinished() {
                ToastUtils.showShort("动画执行结束了")
            }

            override fun onPause() {
                ToastUtils.showShort("动画执行暂停了,设置setLoops()时结束调用")
            }

            override fun onRepeat() {
                ToastUtils.showShort("不设置setLoops()时, 会在一次动画完成后执行")
            }

            override fun onStep(frame: Int, percentage: Double) {
                ToastUtils.showShort("不停的执行...")
            }

        }
    }


    fun playTimes() {
        svga_view.loops = if (plagSingleTimes == true) 1 else 0
    }

    fun playEndStatus() {
        svga_view.fillMode =
            if (plagEndStatus == true) SVGAImageView.FillMode.Forward else SVGAImageView.FillMode.Backward
    }

    fun clearCanver() {
        svga_view.clearsAfterStop = flagClearCanver
    }

    fun getSvgaName(): String {

        val randoms = (0..list.size - 1).random()
        return list[randoms]

    }
}


