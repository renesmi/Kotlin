package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_navi.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.START)//start:left(오른쪽에서 시작), End:right
        }

        naviView.setNavigationItemSelectedListener(this)    //네비게이션 메뉴 아이템에 클릭 속성 부여 onclicklistner역할

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {//네비게이션 메뉴 아이템 클릭시 수행
       when (item.itemId)
       {
           R.id.accesss ->Toast.makeText(applicationContext,"접근성",Toast.LENGTH_SHORT).show()
           R.id.email ->Toast.makeText(applicationContext,"이메일",Toast.LENGTH_SHORT).show()
           R.id.message->Toast.makeText(applicationContext,"메시지",Toast.LENGTH_SHORT).show()
       }
        layout_drawer.closeDrawers()//네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START))
        {
            layout_drawer.closeDrawers()
        }
        else {
            super.onBackPressed()   //일반 백버튼 기능 실행(finish)
        }
    }
}
