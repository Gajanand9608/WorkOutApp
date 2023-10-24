package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.databinding.ActivityHistoryAcitvityBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryAcitvity : AppCompatActivity() {
    private var binding: ActivityHistoryAcitvityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryAcitvityBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarHistoryActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "HISTORY"
        }
        binding?.toolbarHistoryActivity?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        val dao = (application as HistoryApp).db.historyDao()
        getAllWorkoutHistory(dao)
    }
    private fun getAllWorkoutHistory(historyDao: HistoryDao) {
        lifecycleScope.launch {
            historyDao.getAllWorkoutHistory().collect{
                if(it.isNotEmpty()) {
                    binding?.rvHistory?.visibility = View.VISIBLE
                    binding?.rvHistory?.layoutManager = LinearLayoutManager(this@HistoryAcitvity)
                    val dates = ArrayList<String>()
                    for(date in it){
                        dates.add(date.data)
                    }
                    val historyAdapter = ItemAdapter(dates)
                    binding?.rvHistory?.adapter = historyAdapter
                }else{
                    binding?.rvHistory?.visibility = View.GONE
                }
            }
        }
    }

    private fun setupListOfWorkoutHistory(list: ArrayList<HistoryEntity>, historyDao: HistoryDao) {

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}