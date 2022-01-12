package com.android.atr07.drawerwithbottomnavigation

import android.content.Context
import android.content.Intent
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.imageview.ShapeableImageView
import java.lang.Exception

class VideoAdapter(private val context: Context, private var videoList: ArrayList<Video>,private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<VideoAdapter.MyHolder>() {


    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.videoName)
        val folder = view.findViewById<TextView>(R.id.folderName)
        val duration = view.findViewById<TextView>(R.id.duration)
        val image = view.findViewById<ShapeableImageView>(R.id.videoImg)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.video_view, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.title.text = videoList[position].title
        holder.folder.text = videoList[position].folderName
        holder.duration.text = DateUtils.formatElapsedTime(videoList[position].duration / 1000)
        Glide.with(context)
            .asBitmap()
            .load(videoList[position].thumbnailUri)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_video_player).centerCrop())
            .into(holder.image);


      val data = videoList[position]

        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickListener(data)
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }



}

