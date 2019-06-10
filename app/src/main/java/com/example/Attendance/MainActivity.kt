package com.example.Attendance
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), NavigationHost {
    private lateinit var mFirstFragment: LoginFragment
    private lateinit var mSecondFragment: RegisterFragment
//    private lateinit var homeForAdmin: HomeForTeacher
    var tvFirst: TextView? = null
    var tvSecond: TextView? = null
    var tvFirstIsCheck = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        showFirstFragment()
        tvFirst = findViewById(R.id.tvFirst)
        tvSecond = findViewById(R.id.tvSecond)
        tvFirst?.setOnClickListener {
            firstSelected()
            showFirstFragment()
        }

        tvSecond?.setOnClickListener {
            secondSelected()
            showSecondFragment()
        }

    }
    override fun navigateTo(fragment: Fragment, addToBackstack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_layout, fragment)


        if (addToBackstack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    private fun firstSelected(){
        tvFirst?.setBackgroundResource(R.drawable.bg_selected)
        tvSecond?.setBackgroundResource(R.drawable.bg_un_selected)
        tvFirstIsCheck=true
    }

    private fun secondSelected(){
        tvSecond?.setBackgroundResource(R.drawable.bg_selected)
        tvFirst?.setBackgroundResource(R.drawable.bg_un_selected)
        tvFirstIsCheck=false
    }

    private fun initFragment() {
        mFirstFragment= LoginFragment()
        mSecondFragment= RegisterFragment()
//        homeForAdmin=HomeForTeacher()

    }

    private fun showFirstFragment() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.left_in, R.anim.left_out)
            .replace(R.id.main_layout,mFirstFragment,LoginFragment::class.java.name)
            .commit()
        firstSelected()
    }
//    private fun showHomeFragment() {
//        supportFragmentManager.beginTransaction()
//            .setCustomAnimations(R.anim.left_in, R.anim.left_out)
//            .replace(R.id.main_layout,homeForAdmin,HomeForTeacher::class.java.name)
//            .commit()
//        firstSelected()
//    }
  private fun showSecondFragment(){

        supportFragmentManager.beginTransaction()

            .setCustomAnimations(R.anim.right_in, R.anim.right_out, R.anim.left_in, R.anim.left_out)
            .replace(R.id.main_layout,mSecondFragment)
            .addToBackStack(null)
            .commit()
        secondSelected()
    }

    override fun onBackPressed() {
        if(!tvFirstIsCheck) {
            firstSelected()
            tvFirstIsCheck=true
        }
        super.onBackPressed()
    }
    public fun connected():Boolean {

        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected

    }

}

