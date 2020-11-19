package com.example.myapplication

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
/**
 * Created by benchengzhou on 2020/11/11  23:05 .
 * 作者邮箱： mappstore@163.com
 * 功能描述： 
 * 类    名： 增加了注释
 * 备    注： 这个是   --xiaoming - 的分支
 *
 *
 * xiaoming提交了代码
 *
 * 新需求来了，开始忙碌新需求
 *
 * 同学小刘更具新的需求做了一期需求迭代，已发版
 *
 *
 * 小明发现xiaoli的SDK有问题，需要更新master分支的SDK
 *
 * 小明期待发版测试，合并前更新下master的线上代码
 *
 *
 *  小明提交了代码，看不到这些代码说明代码回滚了
 *
 *  我是小明
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}