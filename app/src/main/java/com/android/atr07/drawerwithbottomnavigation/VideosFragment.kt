package com.android.atr07.drawerwithbottomnavigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.atr07.drawerwithbottomnavigation.databinding.FragmentVideosBinding
import java.lang.Exception


class VideosFragment : Fragment(), CellClickListener {

    private var TAG = "CUSTOM MESSAGE"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_videos, container, false)
        val binding = FragmentVideosBinding.bind(view)
        binding.VideoRV.setHasFixedSize(true)
        binding.VideoRV.setItemViewCacheSize(10)

        if (requireContext() != null) {
            Log.d(TAG, "Context received from Activity")
            binding.VideoRV.layoutManager = LinearLayoutManager(context)
            binding.VideoRV.adapter = VideoAdapter(requireContext(), MainActivity.videoList, this)

        } else {
            Log.d(TAG, "requireContext is null")
            Toast.makeText(context, "Context not found", Toast.LENGTH_SHORT).show()
        }



        return view
    }

    //function to be implemented
    private fun playVideo(position: Int) {
        try {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(MainActivity.videoList[position].artUri, "video/*")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //Click Listener interface
    override fun onCellClickListener(data: Video) {
       //Toast.makeText(context,"Cell clicked at position ${data.id}", Toast.LENGTH_SHORT).show()
        playVideo(data)
    }

    // play video file
    fun playVideo(data: Video) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(data.artUri, "video/*")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}